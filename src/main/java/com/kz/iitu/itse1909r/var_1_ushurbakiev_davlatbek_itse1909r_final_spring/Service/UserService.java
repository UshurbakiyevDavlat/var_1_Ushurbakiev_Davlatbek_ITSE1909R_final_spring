package com.kz.iitu.itse1909r.var_1_ushurbakiev_davlatbek_itse1909r_final_spring.Service;

import com.kz.iitu.itse1909r.var_1_ushurbakiev_davlatbek_itse1909r_final_spring.Aop.LogToken;
import com.kz.iitu.itse1909r.var_1_ushurbakiev_davlatbek_itse1909r_final_spring.Database.Role;
import com.kz.iitu.itse1909r.var_1_ushurbakiev_davlatbek_itse1909r_final_spring.Database.User;
import com.kz.iitu.itse1909r.var_1_ushurbakiev_davlatbek_itse1909r_final_spring.Repository.RoleRepository;
import com.kz.iitu.itse1909r.var_1_ushurbakiev_davlatbek_itse1909r_final_spring.Repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;
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
public class UserService {
    public UserRepository userRepository;
    public RoleRepository roleRepository;

    private final SessionFactory sessionFactory;

    @PersistenceContext
    private EntityManager em;

    public UserService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Autowired
    @Transactional(timeout = 10, rollbackFor = {SQLException.class}, propagation = Propagation.REQUIRED)
    public void setUserRepository(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @LogToken
    @Transactional(timeout = 10,
            rollbackFor = {SQLException.class},
            propagation = Propagation.REQUIRED,
            isolation = Isolation.DEFAULT,
            readOnly = true,
            noRollbackFor = {IllegalStateException.class}
    )
    public List<User> getUsers() throws SQLException {
        return this.userRepository.getUsers();
    }

    @LogToken
    @Transactional(timeout = 10,
            rollbackFor = {SQLException.class},
            propagation = Propagation.REQUIRED,
            isolation = Isolation.DEFAULT,
            readOnly = true,
            noRollbackFor = {IllegalStateException.class}
    )
    public List<User> getUserById(@Valid int id) throws SQLException {
        List<User> user = this.userRepository.getUserById(id);
        if (user.get(0).getDeletedAt() != null) {
            log.info("User is archieved so please do not continue.");
            return new ArrayList<User>();
        }
        return user;
    }

    @LogToken
    @Transactional(timeout = 10,
            rollbackFor = {SQLException.class},
            propagation = Propagation.REQUIRED,
            isolation = Isolation.DEFAULT,
            readOnly = true,
            noRollbackFor = {IllegalStateException.class}
    )
    public List<User> getUserByLogin(@Valid String login) throws SQLException {
        List<User> user = this.userRepository.getUserByLogin(login);
        if (user.get(0).getDeletedAt() != null) {
            log.info("User is archieved so please do not continue.");
            return new ArrayList<User>();
        }
        return user;
    }

    public List<Role> getRoles() throws SQLException {
        return this.roleRepository.getAll();
    }

    public Response.Status create(User user, int last_id) throws SQLException {
        List<Role> roles = this.roleRepository.getAll();
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            user.setId(last_id + 1);
            user.setCreatedAt(new Date().toInstant());
            user.setRole(roles.get(0));
            session.save(user);
            session.getTransaction().commit();
            session.close();
        } catch (Exception exception) {
            return Response.Status.BAD_REQUEST;
        }
        return Response.Status.OK;
    }


    @Transactional
    @Modifying
    public Response.Status delete(int id) throws SQLException {
        try {
            List<User> user = this.userRepository.getUserById(id);

            Session sessionOne = sessionFactory.openSession();
            sessionOne.beginTransaction();

            sessionOne.remove(sessionOne.contains(user.get(0)) ? user.get(0) : sessionOne.merge(user.get(0)));

            sessionOne.getTransaction().commit();

            sessionOne.close();

        } catch (Exception exception) {
            log.info(exception.getLocalizedMessage());
            return Response.Status.NOT_MODIFIED;
        }
        return Response.Status.OK;
    }
}
