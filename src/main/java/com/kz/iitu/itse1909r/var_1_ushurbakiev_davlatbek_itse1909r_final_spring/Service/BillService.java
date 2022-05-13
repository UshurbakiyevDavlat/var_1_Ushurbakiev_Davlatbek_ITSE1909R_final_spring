package com.kz.iitu.itse1909r.var_1_ushurbakiev_davlatbek_itse1909r_final_spring.Service;

import com.kz.iitu.itse1909r.var_1_ushurbakiev_davlatbek_itse1909r_final_spring.Aop.LogToken;
import com.kz.iitu.itse1909r.var_1_ushurbakiev_davlatbek_itse1909r_final_spring.Database.Bill;
import com.kz.iitu.itse1909r.var_1_ushurbakiev_davlatbek_itse1909r_final_spring.Database.BillDetail;
import com.kz.iitu.itse1909r.var_1_ushurbakiev_davlatbek_itse1909r_final_spring.Database.User;
import com.kz.iitu.itse1909r.var_1_ushurbakiev_davlatbek_itse1909r_final_spring.Repository.BillDetailsRepository;
import com.kz.iitu.itse1909r.var_1_ushurbakiev_davlatbek_itse1909r_final_spring.Repository.BillsRepository;
import com.kz.iitu.itse1909r.var_1_ushurbakiev_davlatbek_itse1909r_final_spring.Repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
@EnableScheduling
@EnableAsync
@Transactional
public class BillService {
    public final BillsRepository billsRepository;
    public final BillDetailsRepository billDetailsRepository;
    private final SessionFactory sessionFactory;
    private final UserRepository userRepository;

    private final CacheManager cacheManager;

    public BillService(BillsRepository billsRepository, BillDetailsRepository billDetailsRepository, SessionFactory sessionFactory, UserRepository userRepository, CacheManager cacheManager) {
        this.billsRepository = billsRepository;
        this.billDetailsRepository = billDetailsRepository;
        this.sessionFactory = sessionFactory;
        this.userRepository = userRepository;
        this.cacheManager = cacheManager;
    }

    @LogToken
    @Transactional(timeout = 10,
            rollbackFor = {SQLException.class},
            propagation = Propagation.REQUIRED,
            isolation = Isolation.DEFAULT,
            readOnly = true,
            noRollbackFor = {IllegalStateException.class}
    )
    public List<Bill> getAllBills() throws SQLException {
        List<Bill> list = this.billsRepository.getAll();
        if (list.isEmpty()) throw new SQLException();
        return list;
    }

    @LogToken
    @Transactional(timeout = 10,
            rollbackFor = {SQLException.class},
            propagation = Propagation.REQUIRED,
            isolation = Isolation.DEFAULT,
            readOnly = true,
            noRollbackFor = {IllegalStateException.class}
    )
    @Cacheable(value = "bills", key = "#id")
    public Bill getBill(int id) throws SQLException {
        Bill list = this.billsRepository.getById(id);
        if (list.getId() == null) throw new SQLException();
        return list;
    }


    @LogToken
    @Transactional(timeout = 10,
            rollbackFor = {SQLException.class},
            propagation = Propagation.REQUIRED,
            isolation = Isolation.DEFAULT,
            readOnly = true,
            noRollbackFor = {IllegalStateException.class}
    )
    public List<BillDetail> getAllBillDetails() throws SQLException {
        List<BillDetail> list = this.billDetailsRepository.getAll();
        log.info("------"+ list.toString());
        if (list.isEmpty()) throw  new SQLException();
        int sumOfPayments = 0;
        int sum = 0;
        for (BillDetail i: list) {
            if (i.getInsurance() == null) {
                sumOfPayments += i.getAdditionalPay() + i.getDoctorCost() + i.getLabCost();
                sum = i.getAdditionalPay() + i.getDoctorCost() + i.getLabCost();
            }
            else {
                sumOfPayments += i.getInsurance();
                sum = i.getInsurance();
            }
            sum = 0;
        }
        log.info("sum of all payment is :" + sumOfPayments);
        return list;
    }

    @LogToken
    @Transactional(timeout = 10,
            rollbackFor = {SQLException.class},
            propagation = Propagation.REQUIRED,
            isolation = Isolation.DEFAULT,
            readOnly = true,
            noRollbackFor = {IllegalStateException.class}
    )
    public BillDetail getDetailById(int id) throws SQLException {
        BillDetail billDetail = this.billDetailsRepository.getById(id);
        if (billDetail == null) throw new SQLException();
        log.info("sum of it patient payment:" + billDetail.getInsurance());
        return billDetail;
    }


    @Transactional
    public Response.Status create(Bill bill, int last_id, int user_id, int bill_detail_id) throws SQLException {
        User user = userRepository.getUserById(user_id).get(0);
        BillDetail billDetail = billDetailsRepository.getById(bill_detail_id);
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            bill.setId(last_id + 1);
            bill.setCreatedAt(new Date().toInstant());
            bill.setBillDetail(billDetail);
            bill.setUser(user);
            session.save(bill);
            session.getTransaction().commit();
            session.close();
        } catch (Exception exception) {
            return Response.Status.BAD_REQUEST;
        }
        return Response.Status.OK;
    }

    @Transactional
    public Response.Status createDetails(BillDetail billDetail, int last_id) throws SQLException {
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            billDetail.setId(last_id + 1);
            session.save(billDetail);
            session.getTransaction().commit();
            session.close();
        } catch (Exception exception) {
            return Response.Status.BAD_REQUEST;
        }
        return Response.Status.OK;
    }


}
