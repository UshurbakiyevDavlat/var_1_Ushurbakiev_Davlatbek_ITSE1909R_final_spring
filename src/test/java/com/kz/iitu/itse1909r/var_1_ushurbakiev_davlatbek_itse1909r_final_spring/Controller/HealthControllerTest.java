package com.kz.iitu.itse1909r.var_1_ushurbakiev_davlatbek_itse1909r_final_spring.Controller;

import com.kz.iitu.itse1909r.var_1_ushurbakiev_davlatbek_itse1909r_final_spring.Database.HealthHistory;
import com.kz.iitu.itse1909r.var_1_ushurbakiev_davlatbek_itse1909r_final_spring.Database.LabReport;
import com.kz.iitu.itse1909r.var_1_ushurbakiev_davlatbek_itse1909r_final_spring.Database.User;
import com.kz.iitu.itse1909r.var_1_ushurbakiev_davlatbek_itse1909r_final_spring.Service.HealthService;
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
import java.util.List;

import static org.mockito.Mockito.*;

class HealthControllerTest {
    @Mock
    HealthService healthService;
    @Mock
    Logger log;
    @InjectMocks
    HealthController healthController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAll() throws SQLException {
        when(healthService.getAllHistories()).thenReturn(Arrays.<HealthHistory>asList(new HealthHistory()));

        List<HealthHistory> result = healthController.getAll();
        Assertions.assertNotEquals(Arrays.<HealthHistory>asList(new HealthHistory()), result);
    }

    @Test
    void testGetAllLabs() throws SQLException {
        when(healthService.getAllLabs()).thenReturn(Arrays.<LabReport>asList(new LabReport()));

        List<LabReport> result = healthController.getAllLabs();
        Assertions.assertNotEquals(Arrays.<LabReport>asList(new LabReport()), result);
    }

    @Test
    void testGetLab() throws SQLException {
        when(healthService.labReports(anyInt())).thenReturn(new LabReport());

        LabReport result = healthController.getLab(0);
        Assertions.assertNotNull(result);
    }

    @Test
    void testGetConcrete() throws SQLException {
        when(healthService.getConcrete(anyString())).thenReturn(Arrays.<HealthHistory>asList(new HealthHistory()));

        List<HealthHistory> result = healthController.getConcrete("title");
        Assertions.assertNotEquals(Arrays.<HealthHistory>asList(new HealthHistory()), result);
    }

    @Test
    void testCreate() throws SQLException {
        HealthHistory healthHistory = new HealthHistory();
        healthHistory.setId(1);
        healthHistory.setStatus(1);
        healthHistory.setTitle("Test");
        healthHistory.setUser(new User());
        healthHistory.setDoctor(new User());

        when(healthService.getAllHistories()).thenReturn(Arrays.<HealthHistory>asList(healthHistory));
        when(healthService.create(any(), anyInt(), anyInt(), anyInt())).thenReturn(Response.Status.OK);

        ResponseEntity result = healthController.create(new HealthHistory(), 0, 0);
        Assertions.assertNotEquals(null, result);
    }

    @Test
    void testCreate2() throws SQLException {
        LabReport labReport = new LabReport();
        labReport.setBody("test");
        labReport.setVision("test");
        labReport.setHealth(new HealthHistory());
        labReport.setBlood("test");
        labReport.setId(1);

        when(healthService.getAllLabs()).thenReturn(Arrays.<LabReport>asList(labReport));
        when(healthService.createLabs(any(), anyInt(), anyInt(), anyInt())).thenReturn(Response.Status.OK);

        ResponseEntity result = healthController.create(new LabReport(), 0, 0);
        Assertions.assertNotEquals(null, result);
    }

    @Test
    void testUpdate() throws SQLException {
        when(healthService.getConcrete(anyString())).thenReturn(Arrays.<HealthHistory>asList(new HealthHistory()));
        when(healthService.update(any(), anyInt())).thenReturn(Response.Status.OK);

        ResponseEntity result = healthController.update("title", 0);
        Assertions.assertEquals("<200 OK OK,Updated status!,[]>", result.toString());
    }

    @Test
    void testUpdateLab() throws SQLException {
        when(healthService.labReports(anyInt())).thenReturn(new LabReport());
        when(healthService.updateLab(any(), anyString(), anyString(), anyString(), anyString())).thenReturn(Response.Status.OK);

        ResponseEntity result = healthController.updateLab(0, "blood", "heart", "vision", "body");
        Assertions.assertEquals("<200 OK OK,Updated status!,[]>", result.toString());
    }

    @Test
    void testDelete() throws SQLException {
        when(healthService.delete(anyInt())).thenReturn(Response.Status.OK);

        ResponseEntity result = healthController.delete(Integer.valueOf(0));
        Assertions.assertEquals("<200 OK OK,Card deleted,[]>", result.toString());
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme