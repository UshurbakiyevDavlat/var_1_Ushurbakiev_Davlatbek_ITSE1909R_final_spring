package com.kz.iitu.itse1909r.var_1_ushurbakiev_davlatbek_itse1909r_final_spring.Controller;

import com.kz.iitu.itse1909r.var_1_ushurbakiev_davlatbek_itse1909r_final_spring.Database.Bill;
import com.kz.iitu.itse1909r.var_1_ushurbakiev_davlatbek_itse1909r_final_spring.Database.BillDetail;
import com.kz.iitu.itse1909r.var_1_ushurbakiev_davlatbek_itse1909r_final_spring.Service.BillService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping(value = "/bill")
@Slf4j
public class BillController {
    private final BillService billService;


    public BillController(BillService billService) {
        this.billService = billService;
    }

    @GetMapping(value = "/getAll")
    @ResponseStatus(HttpStatus.OK)
    public List<Bill> getAll() throws SQLException {
        return billService.getAllBills();
    }

    @GetMapping(value = "/getByID")
    @ResponseStatus(HttpStatus.OK)
    public Bill getByID(@RequestParam("id") int id) throws SQLException {
        return billService.getBill(id);
    }

    @GetMapping(value = "/getAllDetails")
    @ResponseStatus(HttpStatus.OK)
    public List<BillDetail> getDetails() throws SQLException {
        return billService.getAllBillDetails();
    }

    @GetMapping(value = "/getByDetailByID")
    @ResponseStatus(HttpStatus.OK)
    public BillDetail getByDetailID(@RequestParam("id") int id) throws SQLException {
        return billService.getDetailById(id);
    }


    @PostMapping(value = "/create")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity create(
            @RequestBody Bill bill,
            @RequestParam("user_id") int user,
            @RequestParam("bill_detail_id") int bill_detail

    ) throws SQLException {
        List<Bill> billList = this.getAll();
        int lastId;
        if (billList.size() > 0) lastId = billList.get(billList.size() - 1).getId();
        else lastId = 1;
        if (billService.create(bill, lastId, user, bill_detail) == Response.Status.BAD_REQUEST)
            return (ResponseEntity) ResponseEntity.status(HttpStatus.BAD_REQUEST);
        return ResponseEntity.ok("Created succesfully");
    }


    @PostMapping(value = "/createDetail")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity create(
            @RequestBody BillDetail billDetail

    ) throws SQLException {
        List<BillDetail> billDetails = this.getDetails();
        int lastId;
        if (billDetails.size() > 0) lastId = billDetails.get(billDetails.size() - 1).getId();
        else lastId = 1;
        if (billService.createDetails(billDetail, lastId) == Response.Status.BAD_REQUEST)
            return (ResponseEntity) ResponseEntity.status(HttpStatus.BAD_REQUEST);
        return ResponseEntity.ok("Created succesfully");
    }
}
