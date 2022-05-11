package com.kz.iitu.itse1909r.var_1_ushurbakiev_davlatbek_itse1909r_final_spring.Controller;


import com.kz.iitu.itse1909r.var_1_ushurbakiev_davlatbek_itse1909r_final_spring.Database.HealthHistory;
import com.kz.iitu.itse1909r.var_1_ushurbakiev_davlatbek_itse1909r_final_spring.Database.User;
import com.kz.iitu.itse1909r.var_1_ushurbakiev_davlatbek_itse1909r_final_spring.Service.HealthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping(value = "/health")
@Slf4j
public class HealthController {
    private final HealthService healthService;


    public HealthController(HealthService healthService) {
        this.healthService = healthService;
    }

    @GetMapping(value = "/getAll")
    @ResponseStatus(HttpStatus.OK)
    public List<HealthHistory> getAll() throws SQLException {
        return healthService.getAllHistories();
    }

    @GetMapping(value = "/getConcrete")
    @ResponseStatus(HttpStatus.OK)
    public List<HealthHistory> getConcrete(@RequestParam("title") String title) throws SQLException {
        return healthService.getConcrete(title);
    }

    @PostMapping(value = "/create")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity create(
            @RequestBody HealthHistory healthHistory,
            @RequestParam("doctor_id") int doctor,
            @RequestParam("user_id") int user

    ) throws SQLException {
        List<HealthHistory> healthHistoryList = this.getAll();
        int lastId;
        if (healthHistoryList.size() > 0)  lastId = healthHistoryList.get(healthHistoryList.size() - 1).getId();
        else lastId = 1;
        if (healthService.create(healthHistory, lastId,user,doctor) == Response.Status.BAD_REQUEST)  return (ResponseEntity) ResponseEntity.status(HttpStatus.BAD_REQUEST);
        return ResponseEntity.ok("Created succesfully");
    }

    @PutMapping(value = "/updateStatus")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity update (
            @RequestParam("title") String title, @RequestParam("status") int status) throws SQLException {
        HealthHistory healthHistory = this.getConcrete(title).get(0);
        if (healthService.update(healthHistory,status) == Response.Status.NOT_MODIFIED) return (ResponseEntity) ResponseEntity.status(HttpStatus.NOT_MODIFIED);
        return ResponseEntity.ok("Updated status!");

    }
    @DeleteMapping(value = "/delete")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity delete(@NotNull @RequestParam("id") Integer id) throws SQLException {
        if (healthService.delete(id) == Response.Status.NOT_MODIFIED) return (ResponseEntity) ResponseEntity.status(HttpStatus.NOT_MODIFIED);
        return ResponseEntity.ok("Card deleted");
    }
}
