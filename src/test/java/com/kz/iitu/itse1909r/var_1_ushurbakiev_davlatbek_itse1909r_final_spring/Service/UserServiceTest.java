package com.kz.iitu.itse1909r.var_1_ushurbakiev_davlatbek_itse1909r_final_spring.Service;

import com.kz.iitu.itse1909r.var_1_ushurbakiev_davlatbek_itse1909r_final_spring.Database.Address;
import com.kz.iitu.itse1909r.var_1_ushurbakiev_davlatbek_itse1909r_final_spring.Database.Role;
import com.kz.iitu.itse1909r.var_1_ushurbakiev_davlatbek_itse1909r_final_spring.Database.User;
import com.kz.iitu.itse1909r.var_1_ushurbakiev_davlatbek_itse1909r_final_spring.Repository.AddressRepository;
import com.kz.iitu.itse1909r.var_1_ushurbakiev_davlatbek_itse1909r_final_spring.Repository.RoleRepository;
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
import org.springframework.test.util.ReflectionTestUtils;

import javax.persistence.EntityManager;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import static org.mockito.Mockito.*;

class UserServiceTest {
    @Mock
    UserRepository userRepository = new UserRepository() {
        @Override
        public List<User> getUserByLogin(String login) {
            return null;
        }

        @Override
        public List<User> getUsers() {
            return new ArrayList<>();
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
    RoleRepository roleRepository = new RoleRepository() {
        @Override
        public List<Role> getAll() {
            return null;
        }

        @Override
        public List<Role> findAll() {
            return null;
        }

        @Override
        public List<Role> findAll(Sort sort) {
            return null;
        }

        @Override
        public List<Role> findAllById(Iterable<Long> longs) {
            return null;
        }

        @Override
        public <S extends Role> List<S> saveAll(Iterable<S> entities) {
            return null;
        }

        @Override
        public void flush() {

        }

        @Override
        public <S extends Role> S saveAndFlush(S entity) {
            return null;
        }

        @Override
        public <S extends Role> List<S> saveAllAndFlush(Iterable<S> entities) {
            return null;
        }

        @Override
        public void deleteAllInBatch(Iterable<Role> entities) {

        }

        @Override
        public void deleteAllByIdInBatch(Iterable<Long> longs) {

        }

        @Override
        public void deleteAllInBatch() {

        }

        @Override
        public Role getOne(Long aLong) {
            return null;
        }

        @Override
        public Role getById(Long aLong) {
            return null;
        }

        @Override
        public <S extends Role> List<S> findAll(Example<S> example) {
            return null;
        }

        @Override
        public <S extends Role> List<S> findAll(Example<S> example, Sort sort) {
            return null;
        }

        @Override
        public Page<Role> findAll(Pageable pageable) {
            return null;
        }

        @Override
        public <S extends Role> S save(S entity) {
            return null;
        }

        @Override
        public Optional<Role> findById(Long aLong) {
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
        public void delete(Role entity) {

        }

        @Override
        public void deleteAllById(Iterable<? extends Long> longs) {

        }

        @Override
        public void deleteAll(Iterable<? extends Role> entities) {

        }

        @Override
        public void deleteAll() {

        }

        @Override
        public <S extends Role> Optional<S> findOne(Example<S> example) {
            return Optional.empty();
        }

        @Override
        public <S extends Role> Page<S> findAll(Example<S> example, Pageable pageable) {
            return null;
        }

        @Override
        public <S extends Role> long count(Example<S> example) {
            return 0;
        }

        @Override
        public <S extends Role> boolean exists(Example<S> example) {
            return false;
        }

        @Override
        public <S extends Role, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
            return null;
        }
    };
    @Mock
    AddressRepository addressRepository = new AddressRepository() {
        @Override
        public List<Address> getAll() {
            return null;
        }

        @Override
        public Address getById(int id) {
            return null;
        }

        @Override
        public List<Address> findAll() {
            return null;
        }

        @Override
        public List<Address> findAll(Sort sort) {
            return null;
        }

        @Override
        public List<Address> findAllById(Iterable<Long> longs) {
            return null;
        }

        @Override
        public <S extends Address> List<S> saveAll(Iterable<S> entities) {
            return null;
        }

        @Override
        public void flush() {

        }

        @Override
        public <S extends Address> S saveAndFlush(S entity) {
            return null;
        }

        @Override
        public <S extends Address> List<S> saveAllAndFlush(Iterable<S> entities) {
            return null;
        }

        @Override
        public void deleteAllInBatch(Iterable<Address> entities) {

        }

        @Override
        public void deleteAllByIdInBatch(Iterable<Long> longs) {

        }

        @Override
        public void deleteAllInBatch() {

        }

        @Override
        public Address getOne(Long aLong) {
            return null;
        }

        @Override
        public Address getById(Long aLong) {
            return null;
        }

        @Override
        public <S extends Address> List<S> findAll(Example<S> example) {
            return null;
        }

        @Override
        public <S extends Address> List<S> findAll(Example<S> example, Sort sort) {
            return null;
        }

        @Override
        public Page<Address> findAll(Pageable pageable) {
            return null;
        }

        @Override
        public <S extends Address> S save(S entity) {
            return null;
        }

        @Override
        public Optional<Address> findById(Long aLong) {
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
        public void delete(Address entity) {

        }

        @Override
        public void deleteAllById(Iterable<? extends Long> longs) {

        }

        @Override
        public void deleteAll(Iterable<? extends Address> entities) {

        }

        @Override
        public void deleteAll() {

        }

        @Override
        public <S extends Address> Optional<S> findOne(Example<S> example) {
            return Optional.empty();
        }

        @Override
        public <S extends Address> Page<S> findAll(Example<S> example, Pageable pageable) {
            return null;
        }

        @Override
        public <S extends Address> long count(Example<S> example) {
            return 0;
        }

        @Override
        public <S extends Address> boolean exists(Example<S> example) {
            return false;
        }

        @Override
        public <S extends Address, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
            return null;
        }
    };
    @Mock
    SessionFactory sessionFactory;
    @Mock
    EntityManager em;
    @Mock
    CacheManager cacheManager;
    @Mock
    Logger log;
    @InjectMocks
    UserService userService;

    User user;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        this.user = new User();
        ReflectionTestUtils.setField(user, "id", 1);
        ReflectionTestUtils.setField(user, "password", "passwordTest");
        ReflectionTestUtils.setField(user, "login", "Test");
        ReflectionTestUtils.setField(user, "role", new Role());
        ReflectionTestUtils.setField(user, "age", 22);
        ReflectionTestUtils.setField(user, "status", 1);
    }

    @Test
    void testSetUserRepository() {
        userService.setUserRepository(null, null);
    }

//    @Test
//    void testGetUsers() throws SQLException {
//        User user = new User();
//        user.setId(1);
//        user.setAddress(new Address());
//        user.setPassword("test");
//        user.setRole(new Role());
//        user.setLogin("test");
//        user.setStatus(1);
//
//        when(userRepository.getUsers()).thenReturn(Arrays.<User>asList(user));
//
//        List<User> result = userService.getUsers();
//        Assertions.assertNotEquals(Arrays.<User>asList(new User()), result);
//    }

//    @Test
//    void testGetUserById() throws SQLException {
//        when(userRepository.getUserById(anyInt())).thenReturn(Arrays.<User>asList(new User()));
//
//        List<User> result = userService.getUserById(0);
//        Assertions.assertEquals(Arrays.<User>asList(new User()), result);
//    }
//
//    @Test
//    void testGetUserByLogin() throws SQLException {
//        when(userRepository.getUserByLogin(anyString())).thenReturn(Arrays.<User>asList(new User()));
//
//        List<User> result = userService.getUserByLogin("login");
//        Assertions.assertEquals(Arrays.<User>asList(new User()), result);
//    }
//
//    @Test
//    void testGetRoles() throws SQLException {
//        when(roleRepository.getAll()).thenReturn(Arrays.<Role>asList(new Role()));
//
//        List<Role> result = userService.getRoles();
//        Assertions.assertEquals(Arrays.<Role>asList(new Role()), result);
//    }

//    @Test
//    void testCreate() throws SQLException {
//        when(roleRepository.getAll()).thenReturn(Arrays.<Role>asList(new Role()));
//
//        Response.Status result = userService.create(new User(), 0, new Address());
//        Assertions.assertEquals(Response.Status.BAD_REQUEST, result);
//    }

    @Test
    void testGetAddresses() throws SQLException {

        Address address = new Address();
        address.setId(1);
        address.setName("TestAddress");

        when(addressRepository.getAll()).thenReturn(Arrays.<Address>asList(address));

        List<Address> result = userService.getAddresses();
        Assertions.assertNotEquals(Arrays.<Address>asList(new Address()), result);
    }

    @Test
    void testGetAddressById() throws SQLException {
        Address address = new Address();
        address.setId(1);
        address.setName("TestAddress");
        when(addressRepository.getById(anyInt())).thenReturn(address);

        Address result = userService.getAddressById(1);
        Assertions.assertNotEquals(new Address(), result);
    }



    @Test
    void testUpdate() throws SQLException {
        Response.Status result = userService.update(new User(), "newPass");
        Assertions.assertEquals(Response.Status.NOT_MODIFIED, result);
    }

    @Test
    void testDelete() throws SQLException {
        when(userRepository.getUserById(anyInt())).thenReturn(Arrays.<User>asList(new User()));

        Response.Status result = userService.delete(0);
        Assertions.assertEquals(Response.Status.NOT_MODIFIED, result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme