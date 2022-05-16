package com.kz.iitu.itse1909r.var_1_ushurbakiev_davlatbek_itse1909r_final_spring.Service;

import com.kz.iitu.itse1909r.var_1_ushurbakiev_davlatbek_itse1909r_final_spring.Database.Bill;
import com.kz.iitu.itse1909r.var_1_ushurbakiev_davlatbek_itse1909r_final_spring.Database.BillDetail;
import com.kz.iitu.itse1909r.var_1_ushurbakiev_davlatbek_itse1909r_final_spring.Database.User;
import com.kz.iitu.itse1909r.var_1_ushurbakiev_davlatbek_itse1909r_final_spring.Repository.BillDetailsRepository;
import com.kz.iitu.itse1909r.var_1_ushurbakiev_davlatbek_itse1909r_final_spring.Repository.BillsRepository;
import com.kz.iitu.itse1909r.var_1_ushurbakiev_davlatbek_itse1909r_final_spring.Repository.UserRepository;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.springframework.cache.CacheManager;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import static org.mockito.Mockito.*;

class BillServiceTest {
    @Mock
    BillsRepository billsRepository = new BillsRepository() {
        @Override
        public List<Bill> getAll() {
            return null;
        }

        @Override
        public Bill getById(int id) {
            return null;
        }

        @Override
        public List<Bill> findAll() {
            return null;
        }

        @Override
        public List<Bill> findAll(Sort sort) {
            return null;
        }

        @Override
        public List<Bill> findAllById(Iterable<Long> longs) {
            return null;
        }

        @Override
        public <S extends Bill> List<S> saveAll(Iterable<S> entities) {
            return null;
        }

        @Override
        public void flush() {

        }

        @Override
        public <S extends Bill> S saveAndFlush(S entity) {
            return null;
        }

        @Override
        public <S extends Bill> List<S> saveAllAndFlush(Iterable<S> entities) {
            return null;
        }

        @Override
        public void deleteAllInBatch(Iterable<Bill> entities) {

        }

        @Override
        public void deleteAllByIdInBatch(Iterable<Long> longs) {

        }

        @Override
        public void deleteAllInBatch() {

        }

        @Override
        public Bill getOne(Long aLong) {
            return null;
        }

        @Override
        public Bill getById(Long aLong) {
            return null;
        }

        @Override
        public <S extends Bill> List<S> findAll(Example<S> example) {
            return null;
        }

        @Override
        public <S extends Bill> List<S> findAll(Example<S> example, Sort sort) {
            return null;
        }

        @Override
        public Page<Bill> findAll(Pageable pageable) {
            return null;
        }

        @Override
        public <S extends Bill> S save(S entity) {
            return null;
        }

        @Override
        public Optional<Bill> findById(Long aLong) {
            return Optional.empty();
        }

        @Override
        public boolean existsById(Long aLong) {
            return false;
        }

        @Override
        public long count() {
            return 0;
        }

        @Override
        public void deleteById(Long aLong) {

        }

        @Override
        public void delete(Bill entity) {

        }

        @Override
        public void deleteAllById(Iterable<? extends Long> longs) {

        }

        @Override
        public void deleteAll(Iterable<? extends Bill> entities) {

        }

        @Override
        public void deleteAll() {

        }

        @Override
        public <S extends Bill> Optional<S> findOne(Example<S> example) {
            return Optional.empty();
        }

        @Override
        public <S extends Bill> Page<S> findAll(Example<S> example, Pageable pageable) {
            return null;
        }

        @Override
        public <S extends Bill> long count(Example<S> example) {
            return 0;
        }

        @Override
        public <S extends Bill> boolean exists(Example<S> example) {
            return false;
        }

        @Override
        public <S extends Bill, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
            return null;
        }
    };
    @Mock
    BillDetailsRepository billDetailsRepository = new BillDetailsRepository() {
        @Override
        public List<BillDetail> getAll() {
            return null;
        }

        @Override
        public BillDetail getById(int id) {
            return null;
        }

        @Override
        public List<BillDetail> findAll() {
            return null;
        }

        @Override
        public List<BillDetail> findAll(Sort sort) {
            return null;
        }

        @Override
        public List<BillDetail> findAllById(Iterable<Long> longs) {
            return null;
        }

        @Override
        public <S extends BillDetail> List<S> saveAll(Iterable<S> entities) {
            return null;
        }

        @Override
        public void flush() {

        }

        @Override
        public <S extends BillDetail> S saveAndFlush(S entity) {
            return null;
        }

        @Override
        public <S extends BillDetail> List<S> saveAllAndFlush(Iterable<S> entities) {
            return null;
        }

        @Override
        public void deleteAllInBatch(Iterable<BillDetail> entities) {

        }

        @Override
        public void deleteAllByIdInBatch(Iterable<Long> longs) {

        }

        @Override
        public void deleteAllInBatch() {

        }

        @Override
        public BillDetail getOne(Long aLong) {
            return null;
        }

        @Override
        public BillDetail getById(Long aLong) {
            return null;
        }

        @Override
        public <S extends BillDetail> List<S> findAll(Example<S> example) {
            return null;
        }

        @Override
        public <S extends BillDetail> List<S> findAll(Example<S> example, Sort sort) {
            return null;
        }

        @Override
        public Page<BillDetail> findAll(Pageable pageable) {
            return null;
        }

        @Override
        public <S extends BillDetail> S save(S entity) {
            return null;
        }

        @Override
        public Optional<BillDetail> findById(Long aLong) {
            return Optional.empty();
        }

        @Override
        public boolean existsById(Long aLong) {
            return false;
        }

        @Override
        public long count() {
            return 0;
        }

        @Override
        public void deleteById(Long aLong) {

        }

        @Override
        public void delete(BillDetail entity) {

        }

        @Override
        public void deleteAllById(Iterable<? extends Long> longs) {

        }

        @Override
        public void deleteAll(Iterable<? extends BillDetail> entities) {

        }

        @Override
        public void deleteAll() {

        }

        @Override
        public <S extends BillDetail> Optional<S> findOne(Example<S> example) {
            return Optional.empty();
        }

        @Override
        public <S extends BillDetail> Page<S> findAll(Example<S> example, Pageable pageable) {
            return null;
        }

        @Override
        public <S extends BillDetail> long count(Example<S> example) {
            return 0;
        }

        @Override
        public <S extends BillDetail> boolean exists(Example<S> example) {
            return false;
        }

        @Override
        public <S extends BillDetail, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
            return null;
        }
    };
    @Mock
    SessionFactory sessionFactory;
    @Mock
    UserRepository userRepository = new UserRepository() {
        @Override
        public List<User> getUserByLogin(String login) {
        return new ArrayList<>();
        }

        @Override
        public List<User> getUsers() {
            return null;
        }

        @Override
        public List<User> getUserById(int id) {
            return null;
        }

        @Override
        public List<User> findAll() {
            return null;
        }

        @Override
        public List<User> findAll(Sort sort) {
            return null;
        }

        @Override
        public List<User> findAllById(Iterable<Long> longs) {
            return null;
        }

        @Override
        public <S extends User> List<S> saveAll(Iterable<S> entities) {
            return null;
        }

        @Override
        public void flush() {

        }

        @Override
        public <S extends User> S saveAndFlush(S entity) {
            return null;
        }

        @Override
        public <S extends User> List<S> saveAllAndFlush(Iterable<S> entities) {
            return null;
        }

        @Override
        public void deleteAllInBatch(Iterable<User> entities) {

        }

        @Override
        public void deleteAllByIdInBatch(Iterable<Long> longs) {

        }

        @Override
        public void deleteAllInBatch() {

        }

        @Override
        public User getOne(Long aLong) {
            return null;
        }

        @Override
        public User getById(Long aLong) {
            return null;
        }

        @Override
        public <S extends User> List<S> findAll(Example<S> example) {
            return null;
        }

        @Override
        public <S extends User> List<S> findAll(Example<S> example, Sort sort) {
            return null;
        }

        @Override
        public Page<User> findAll(Pageable pageable) {
            return null;
        }

        @Override
        public <S extends User> S save(S entity) {
            return null;
        }

        @Override
        public Optional<User> findById(Long aLong) {
            return Optional.empty();
        }

        @Override
        public boolean existsById(Long aLong) {
            return false;
        }

        @Override
        public long count() {
            return 0;
        }

        @Override
        public void deleteById(Long aLong) {

        }

        @Override
        public void delete(User entity) {

        }

        @Override
        public void deleteAllById(Iterable<? extends Long> longs) {

        }

        @Override
        public void deleteAll(Iterable<? extends User> entities) {

        }

        @Override
        public void deleteAll() {

        }

        @Override
        public <S extends User> Optional<S> findOne(Example<S> example) {
            return Optional.empty();
        }

        @Override
        public <S extends User> Page<S> findAll(Example<S> example, Pageable pageable) {
            return null;
        }

        @Override
        public <S extends User> long count(Example<S> example) {
            return 0;
        }

        @Override
        public <S extends User> boolean exists(Example<S> example) {
            return false;
        }

        @Override
        public <S extends User, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
            return null;
        }
    };
    @Mock
    CacheManager cacheManager;
    @Mock
    Logger log;
    @InjectMocks
    BillService billService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAllBills() throws SQLException {


        when(billsRepository.getAll()).thenReturn(Arrays.<Bill>asList(new Bill()));

        List<Bill> result = billService.getAllBills();
        Assertions.assertNotNull(result);
    }

    @Test
    void testGetBill() throws SQLException {
        Bill bill = new Bill();
        bill.setId(1);
        bill.setBillDetail(new BillDetail());
        bill.setUser(new User());
        when(billsRepository.getById(anyInt())).thenReturn(bill);

        Bill result = billService.getBill(1);
        Assertions.assertNotEquals(new Bill(), result);
    }

    @Test
    void testGetAllBillDetails() throws SQLException {
        BillDetail billDetail = new BillDetail();
        billDetail.setId(1);
        billDetail.setAdditionalPay(1);
        billDetail.setInsurance(1);
        billDetail.setDoctorCost(1);
        billDetail.setLabCost(1);
        when(billDetailsRepository.getAll()).thenReturn(Arrays.<BillDetail>asList(billDetail));

        List<BillDetail> result = billService.getAllBillDetails();
        Assertions.assertNotEquals(Arrays.<BillDetail>asList(new BillDetail()), result);
    }

    @Test
    void testGetDetailById() throws SQLException {
        when(billDetailsRepository.getById(anyInt())).thenReturn(new BillDetail());

        BillDetail result = billService.getDetailById(0);
        Assertions.assertNotEquals(new BillDetail(), result);
    }

    @Test
    void testCreate() throws SQLException {
        when(billDetailsRepository.getById(anyInt())).thenReturn(new BillDetail());
        when(userRepository.getUserById(anyInt())).thenReturn(Arrays.<User>asList(new User()));

        Response.Status result = billService.create(new Bill(), 0, 0, 0);
        Assertions.assertEquals(Response.Status.BAD_REQUEST, result);
    }

    @Test
    void testCreateDetails() throws SQLException {
        Response.Status result = billService.createDetails(new BillDetail(), 0);
        Assertions.assertEquals(Response.Status.BAD_REQUEST, result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme