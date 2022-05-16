package com.kz.iitu.itse1909r.var_1_ushurbakiev_davlatbek_itse1909r_final_spring.Controller;

import com.kz.iitu.itse1909r.var_1_ushurbakiev_davlatbek_itse1909r_final_spring.Database.Address;
import com.kz.iitu.itse1909r.var_1_ushurbakiev_davlatbek_itse1909r_final_spring.Database.Role;
import com.kz.iitu.itse1909r.var_1_ushurbakiev_davlatbek_itse1909r_final_spring.Database.User;
import com.kz.iitu.itse1909r.var_1_ushurbakiev_davlatbek_itse1909r_final_spring.JMS.Action;
import com.kz.iitu.itse1909r.var_1_ushurbakiev_davlatbek_itse1909r_final_spring.JMS.Reciever;
import com.kz.iitu.itse1909r.var_1_ushurbakiev_davlatbek_itse1909r_final_spring.Service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.springframework.http.ResponseEntity;

import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.*;

class UserControllerTest {
    @Mock
    UserService userService;
    @Mock
    Action action;
    @Mock
    Reciever reciever;
    @Mock
    Logger log;
    @InjectMocks
    UserController userController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAllheaders() {
        Map<String, String> result = userController.getAllheaders(new HashMap<String, String>() {{
            put("String", "String");
        }});
        Assertions.assertEquals(new HashMap<String, String>() {{
            put("String", "String");
        }}, result);
    }

    @Test
    void testListen() throws SQLException {
        when(reciever.receiveMessage(anyString())).thenReturn("receiveMessageResponse");

        String result = userController.listen();
        Assertions.assertEquals("receiveMessageResponse", result);
    }

    @Test
    void testSend() throws SQLException {
        when(action.SendMessage(anyString())).thenReturn("SendMessageResponse");

        String result = userController.send("msg");
        Assertions.assertEquals("Send - SendMessageResponse", result);
    }

    @Test
    void testSending() throws SQLException {
        when(action.SendMessage(anyString())).thenReturn("SendMessageResponse");

        userController.sending();
    }

    @Test
    void testListening() throws SQLException {
        when(reciever.receiveMessage(anyString())).thenReturn("receiveMessageResponse");

        userController.listening();
    }

    @Test
    void testGetAll() throws SQLException {
        when(userService.getUsers()).thenReturn(Arrays.<User>asList(new User()));

        List<User> result = userController.getAll();
        Assertions.assertNotEquals(Arrays.<User>asList(new User()), result);
    }

    @Test
    void testGetUserById() throws SQLException {
        when(userService.getUserById(anyInt())).thenReturn(Arrays.<User>asList(new User()));

        List<User> result = userController.getUserById(0);
        Assertions.assertNotNull(result);
    }

    @Test
    void testGetUserByLogin() throws SQLException {
        when(userService.getUserByLogin(anyString())).thenReturn(Arrays.<User>asList(new User()));

        List<User> result = userController.getUserByLogin("login");
        Assertions.assertNotNull(result);
    }

    @Test
    void testGetRoles() throws SQLException {
        when(userService.getRoles()).thenReturn(Arrays.<Role>asList(new Role()));

        List<Role> result = userController.getRoles();
        Assertions.assertNotEquals(Arrays.<Role>asList(new Role()), result);
    }

    @Test
    void testGetAddresses() throws SQLException {
        when(userService.getAddresses()).thenReturn(Arrays.<Address>asList(new Address()));

        List<Address> result = userController.getAddresses();
        Assertions.assertNotEquals(Arrays.<Address>asList(new Address()), result);
    }

    @Test
    void testCreate() throws SQLException {
        User test = new User();
        test.setId(1);
        test.setLogin("test");
        test.setPassword("test1");
        when(userService.getUsers()).thenReturn(Arrays.<User>asList(test));
        when(userService.getAddressById(8)).thenReturn(new Address());
        when(userService.create(any(), anyInt(), any())).thenReturn(Response.Status.OK);

        ResponseEntity result = userController.create(new User(), 8);
        Assertions.assertEquals("<200 OK OK,Created succesfully,[]>",result.toString());
    }

    @Test
    void testUpdate() throws SQLException {
        when(userService.getUserByLogin(anyString())).thenReturn(Arrays.<User>asList(new User()));
        when(userService.update(any(), anyString())).thenReturn(Response.Status.OK);

        ResponseEntity result = userController.update("login", "pass");
        Assertions.assertEquals("<200 OK OK,User changed login|password,[]>", result.toString());
    }

    @Test
    void testDelete() throws SQLException {
        when(userService.delete(anyInt())).thenReturn(Response.Status.OK);

        ResponseEntity result = userController.delete(Integer.valueOf(0));
        Assertions.assertEquals("<200 OK OK,User deleted,[]>", result.toString());
    }

    @Test
    void testLogout() {
        ResponseEntity result = userController.logout();
        Assertions.assertNotEquals("", result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme