package com.kz.iitu.itse1909r.var_1_ushurbakiev_davlatbek_itse1909r_final_spring.Controller;

import com.kz.iitu.itse1909r.var_1_ushurbakiev_davlatbek_itse1909r_final_spring.Database.Role;
import com.kz.iitu.itse1909r.var_1_ushurbakiev_davlatbek_itse1909r_final_spring.Database.User;
import com.kz.iitu.itse1909r.var_1_ushurbakiev_davlatbek_itse1909r_final_spring.JMS.Action;
import com.kz.iitu.itse1909r.var_1_ushurbakiev_davlatbek_itse1909r_final_spring.JMS.Reciever;
import com.kz.iitu.itse1909r.var_1_ushurbakiev_davlatbek_itse1909r_final_spring.Service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/users")
@Slf4j
public class UserController {
    private final UserService userService;
    private final Action action;
    private final Reciever reciever;

    @Autowired
    public UserController(UserService userService, Action action, Reciever reciever) {
        this.userService = userService;
        this.action = action;
        this.reciever = reciever;
    }

    @GetMapping("/print-all-headers")
    public Map<String, String> getAllheaders(@RequestHeader Map<String, String> headers) {
        return headers;
    }

    @GetMapping("/listen")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> listen() throws SQLException {
        log.info(reciever.receiveMessage("text"));
        return new ResponseEntity<String>(HttpStatus.OK);
    }

    @PostMapping("/send")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> send() throws SQLException {
        try {
            action.SendMessage();
        } catch (Exception exception) {
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<String>(HttpStatus.OK);
    }

    @GetMapping(value = "/testDelay")
    @ResponseStatus(HttpStatus.OK)
    @Scheduled(initialDelay = 2000,fixedDelay = 200000)
    public void testingDelay () {
        log.info("Info about testing delay job.");
    }
    @GetMapping(value = "/testRate")
    @ResponseStatus(HttpStatus.OK)
    @Scheduled(fixedRate = 20000)
    public void testingRate () {
        log.info("Info about testing rate job.");
    }

    @GetMapping(value = "/getAll")
    @ResponseStatus(HttpStatus.OK)
    public List<User> getAll() throws SQLException {
        return userService.getUsers();
    }

    @GetMapping(value = "/getUserWithRole")
    @ResponseStatus(HttpStatus.OK)
    public List<User> getUserById(@RequestParam("id") int id) throws SQLException {
        List<User> user = userService.getUserById(id);
        if (user.isEmpty()) throw new IllegalStateException();
        return user;
    }

    @GetMapping(value = "/getUserByLogin")
    @ResponseStatus(HttpStatus.OK)
    public List<User> getUserByLogin(@RequestParam("login") String login) throws SQLException {
        List<User> user = userService.getUserByLogin(login);
        if (user.isEmpty()) throw new IllegalStateException();
        return user;
    }

    @GetMapping(value = "/getRoles")
    @ResponseStatus(HttpStatus.OK)
    @Cacheable(value = "roles")
    public List<Role> getRoles() throws SQLException {
        List<Role> roles = userService.getRoles();
        if (roles.isEmpty()) throw new IllegalStateException();
        return roles;
    }

    @PostMapping(value = "/create")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity create(@RequestBody User user) throws SQLException {
        List<User> listUsers = this.getAll();
        int lastId = listUsers.get(listUsers.size() - 1).getId();
        if (userService.create(user, lastId) == Response.Status.BAD_REQUEST)  return (ResponseEntity) ResponseEntity.status(HttpStatus.BAD_REQUEST);
        return ResponseEntity.ok("Created succesfully");
    }

    @PutMapping(value = "/updatePassword")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity update (
            @RequestParam("login") String login,
            @RequestParam("password") String pass) throws SQLException {
        User user = this.getUserByLogin(login).get(0);
        if (userService.update(user,pass) == Response.Status.NOT_MODIFIED) return (ResponseEntity) ResponseEntity.status(HttpStatus.NOT_MODIFIED);
        return ResponseEntity.ok("User changed login|password");

    }
    @DeleteMapping(value = "/delete")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity delete(@NotNull @RequestParam("id") Integer id) throws SQLException {
        if (userService.delete(id) == Response.Status.NOT_MODIFIED) return (ResponseEntity) ResponseEntity.status(HttpStatus.NOT_MODIFIED);
        return ResponseEntity.ok("User deleted");
    }
}
