package com.kz.iitu.itse1909r.var_1_ushurbakiev_davlatbek_itse1909r_final_spring.Controller;

import com.kz.iitu.itse1909r.var_1_ushurbakiev_davlatbek_itse1909r_final_spring.Database.Bill;
import com.kz.iitu.itse1909r.var_1_ushurbakiev_davlatbek_itse1909r_final_spring.Database.BillDetail;
import com.kz.iitu.itse1909r.var_1_ushurbakiev_davlatbek_itse1909r_final_spring.Database.User;
import com.kz.iitu.itse1909r.var_1_ushurbakiev_davlatbek_itse1909r_final_spring.Service.BillService;
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

class BillControllerTest {
    @Mock
    BillService billService;
    @Mock
    Logger log;
    @InjectMocks
    BillController billController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAll() throws SQLException {
        when(billService.getAllBills()).thenReturn(Arrays.<Bill>asList(new Bill()));

        List<Bill> result = billController.getAll();
        Assertions.assertNotEquals(Arrays.<Bill>asList(new Bill()), result);
    }

    @Test
    void testGetByID() throws SQLException {
        when(billService.getBill(anyInt())).thenReturn(new Bill());

        Bill result = billController.getByID(0);
        Assertions.assertNotEquals(new Bill(), result);
    }

    @Test
    void testGetDetails() throws SQLException {
        when(billService.getAllBillDetails()).thenReturn(Arrays.<BillDetail>asList(new BillDetail()));

        List<BillDetail> result = billController.getDetails();
        Assertions.assertNotEquals(Arrays.<BillDetail>asList(new BillDetail()), result);
    }

    @Test
    void testGetByDetailID() throws SQLException {
        when(billService.getDetailById(anyInt())).thenReturn(new BillDetail());

        BillDetail result = billController.getByDetailID(0);
        Assertions.assertNotEquals(new BillDetail(), result);
    }

    @Test
    void testCreate() throws SQLException {
        Bill bill = new Bill();
        bill.setId(1);
        bill.setUser(new User());
        bill.setBillDetail(new BillDetail());
        when(billService.getAllBills()).thenReturn(Arrays.<Bill>asList(bill));
        when(billService.create(any(), anyInt(), anyInt(), anyInt())).thenReturn(Response.Status.OK);

        ResponseEntity result = billController.create(new Bill(), 0, 0);
        Assertions.assertNotEquals(null, result);
    }

    @Test
    void testCreate2() throws SQLException {
        BillDetail billDetail = new BillDetail();
        billDetail.setBills(Arrays.asList(new Bill()));
        billDetail.setInsurance(15000);
        billDetail.setAdditionalPay(10000);
        billDetail.setLabCost(10000);
        billDetail.setDoctorCost(10000);
        billDetail.setId(1);
        when(billService.getAllBillDetails()).thenReturn(Arrays.<BillDetail>asList(billDetail));
        when(billService.createDetails(any(), anyInt())).thenReturn(Response.Status.OK);

        ResponseEntity result = billController.create(new BillDetail());
        Assertions.assertNotEquals(null, result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme