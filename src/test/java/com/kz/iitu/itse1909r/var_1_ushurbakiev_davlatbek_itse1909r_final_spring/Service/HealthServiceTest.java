package com.kz.iitu.itse1909r.var_1_ushurbakiev_davlatbek_itse1909r_final_spring.Service;

import com.kz.iitu.itse1909r.var_1_ushurbakiev_davlatbek_itse1909r_final_spring.Database.HealthHistory;
import com.kz.iitu.itse1909r.var_1_ushurbakiev_davlatbek_itse1909r_final_spring.Database.LabReport;
import com.kz.iitu.itse1909r.var_1_ushurbakiev_davlatbek_itse1909r_final_spring.Database.User;
import com.kz.iitu.itse1909r.var_1_ushurbakiev_davlatbek_itse1909r_final_spring.Repository.HealthRepository;
import com.kz.iitu.itse1909r.var_1_ushurbakiev_davlatbek_itse1909r_final_spring.Repository.LabReportsRepository;
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

import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

class HealthServiceTest {
    @Mock
    HealthRepository healthRepository;
    @Mock
    UserRepository userRepository;
    @Mock
    SessionFactory sessionFactory;
    @Mock
    LabReportsRepository labReportsRepository;
    @Mock
    CacheManager cacheManager;
    @Mock
    Logger log;
    @InjectMocks
    HealthService healthService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAllHistories() throws SQLException {
        when(healthRepository.getAll()).thenReturn(Arrays.<HealthHistory>asList(new HealthHistory()));

        List<HealthHistory> result = healthService.getAllHistories();
        Assertions.assertNotEquals(Arrays.<HealthHistory>asList(new HealthHistory()), result);
    }

    @Test
    void testGetAllLabs() throws SQLException {
        when(labReportsRepository.getAll()).thenReturn(Arrays.<LabReport>asList(new LabReport()));

        List<LabReport> result = healthService.getAllLabs();
        Assertions.assertNotEquals(Arrays.<LabReport>asList(new LabReport()), result);
    }

    @Test
    void testGetConcrete() throws SQLException {
        when(healthRepository.getByTitle(anyString())).thenReturn(Arrays.<HealthHistory>asList(new HealthHistory()));

        List<HealthHistory> result = healthService.getConcrete("title");
        Assertions.assertNotNull(result);
    }

    @Test
    void testCreate() throws SQLException {
        when(userRepository.getUserById(anyInt())).thenReturn(Arrays.<User>asList(new User()));

        Response.Status result = healthService.create(new HealthHistory(), 0, 0, 0);
        Assertions.assertEquals(Response.Status.BAD_REQUEST, result);
    }

    @Test
    void testCreateLabs() throws SQLException {
        when(healthRepository.getById(anyInt())).thenReturn(Arrays.<HealthHistory>asList(new HealthHistory()));
        when(userRepository.getUserById(anyInt())).thenReturn(Arrays.<User>asList(new User()));

        Response.Status result = healthService.createLabs(new LabReport(), 0, 0, 0);
        Assertions.assertEquals(Response.Status.BAD_REQUEST, result);
    }

    @Test
    void testLabReports() {
        when(labReportsRepository.getById(anyInt())).thenReturn(new LabReport());

        LabReport result = healthService.labReports(0);
        Assertions.assertNotEquals(new LabReport(), result);
    }

    @Test
    void testUpdate() throws SQLException {
        Response.Status result = healthService.update(new HealthHistory(), 0);
        Assertions.assertEquals(Response.Status.NOT_MODIFIED, result);
    }

    @Test
    void testUpdateLab() throws SQLException {
        Response.Status result = healthService.updateLab(new LabReport(), "blood", "heart", "vision", "body");
        Assertions.assertEquals(Response.Status.NOT_MODIFIED, result);
    }

    @Test
    void testDelete() throws SQLException {
        when(healthRepository.getById(anyInt())).thenReturn(Arrays.<HealthHistory>asList(new HealthHistory()));

        Response.Status result = healthService.delete(Integer.valueOf(0));
        Assertions.assertEquals(Response.Status.NOT_MODIFIED, result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme