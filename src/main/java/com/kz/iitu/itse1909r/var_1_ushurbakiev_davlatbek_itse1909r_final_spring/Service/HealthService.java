package com.kz.iitu.itse1909r.var_1_ushurbakiev_davlatbek_itse1909r_final_spring.Service;

import com.kz.iitu.itse1909r.var_1_ushurbakiev_davlatbek_itse1909r_final_spring.Aop.LogToken;
import com.kz.iitu.itse1909r.var_1_ushurbakiev_davlatbek_itse1909r_final_spring.Database.HealthHistory;
import com.kz.iitu.itse1909r.var_1_ushurbakiev_davlatbek_itse1909r_final_spring.Database.LabReport;
import com.kz.iitu.itse1909r.var_1_ushurbakiev_davlatbek_itse1909r_final_spring.Database.User;
import com.kz.iitu.itse1909r.var_1_ushurbakiev_davlatbek_itse1909r_final_spring.Repository.HealthRepository;
import com.kz.iitu.itse1909r.var_1_ushurbakiev_davlatbek_itse1909r_final_spring.Repository.LabReportsRepository;
import com.kz.iitu.itse1909r.var_1_ushurbakiev_davlatbek_itse1909r_final_spring.Repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
@EnableScheduling
@EnableAsync
@Transactional
public class HealthService {
    public final HealthRepository healthRepository;
    private final UserRepository userRepository;
    private final SessionFactory sessionFactory;
    private final LabReportsRepository labReportsRepository;

    public HealthService(SessionFactory sessionFactory, HealthRepository healthRepository, UserRepository userRepository, LabReportsRepository labReportsRepository) {
        this.sessionFactory = sessionFactory;
        this.healthRepository = healthRepository;
        this.userRepository = userRepository;
        this.labReportsRepository = labReportsRepository;
    }

    @LogToken
    @Transactional(timeout = 10,
            rollbackFor = {SQLException.class},
            propagation = Propagation.REQUIRED,
            isolation = Isolation.DEFAULT,
            readOnly = true,
            noRollbackFor = {IllegalStateException.class}
    )
    public List<HealthHistory> getAllHistories() throws SQLException {
        return this.healthRepository.getAll();
    }

    @LogToken
    @Transactional(timeout = 10,
            rollbackFor = {SQLException.class},
            propagation = Propagation.REQUIRED,
            isolation = Isolation.DEFAULT,
            readOnly = true,
            noRollbackFor = {IllegalStateException.class}
    )
    public List<LabReport> getAllLabs() throws SQLException{
        return this.labReportsRepository.getAll();
    }

    @LogToken
    @Transactional(timeout = 10,
            rollbackFor = {SQLException.class},
            propagation = Propagation.REQUIRED,
            isolation = Isolation.DEFAULT,
            readOnly = true,
            noRollbackFor = {IllegalStateException.class}
    )
    public List<HealthHistory> getConcrete(String title) throws SQLException {
        return this.healthRepository.getByTitle(title);
    }


    @Transactional
    public Response.Status create(HealthHistory healthHistory, int last_id,int d_id,int u_id) throws SQLException {
        User user = userRepository.getUserById(u_id).get(0);
        User doctor = userRepository.getUserById(d_id).get(0);
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            healthHistory.setId(last_id + 1);
            healthHistory.setCreatedAt(new Date().toInstant());
            healthHistory.setDoctor(doctor);
            healthHistory.setUser(user);
            session.save(healthHistory);
            session.getTransaction().commit();
            session.close();
        } catch (Exception exception) {
            return Response.Status.BAD_REQUEST;
        }
        return Response.Status.OK;
    }

    @Transactional
    public Response.Status createLabs(LabReport labReport, int last_id,int card_id,int doctor_id) throws SQLException {
        User doctor = userRepository.getUserById(doctor_id).get(0);
        HealthHistory healthHistory1 = healthRepository.getById(card_id).get(0);
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            labReport.setId(last_id + 1);
            labReport.setCreatedAt(new Date().toInstant());
            labReport.setHealth(healthHistory1);
            labReport.setDoctor(doctor);
            session.save(labReport);
            session.getTransaction().commit();
            session.close();
        } catch (Exception exception) {
            return Response.Status.BAD_REQUEST;
        }
        return Response.Status.OK;
    }

    @Transactional
    public LabReport labReports (int id) {
        return labReportsRepository.getById(id);
    }
    @Transactional
    @Modifying
    public Response.Status update(HealthHistory healthHistory, int status) throws SQLException {
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();

            healthHistory.setStatus(status);

            session.update(healthHistory);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            return Response.Status.NOT_MODIFIED;
        }
        return Response.Status.OK;
    }

    @Transactional
    @Modifying
    public Response.Status updateLab(LabReport labReport, String blood,String heart,String vision,String body) throws SQLException {
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();

            labReport.setBlood(blood);
            labReport.setHeart(heart);
            labReport.setVision(vision);
            labReport.setBody(body);

            session.update(labReport);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            return Response.Status.NOT_MODIFIED;
        }
        return Response.Status.OK;
    }

    @Transactional
    @Modifying
    public Response.Status delete(Integer id) throws SQLException {
        try {
            List<HealthHistory> healthHistoryList = this.healthRepository.getById(id);

            Session sessionOne = sessionFactory.openSession();
            sessionOne.beginTransaction();

            sessionOne.remove(sessionOne.contains(healthHistoryList.get(0)) ? healthHistoryList.get(0) : sessionOne.merge(healthHistoryList.get(0)));

            sessionOne.getTransaction().commit();

            sessionOne.close();

        } catch (Exception exception) {
            log.info(exception.getLocalizedMessage());
            return Response.Status.NOT_MODIFIED;
        }
        return Response.Status.OK;
    }
}
