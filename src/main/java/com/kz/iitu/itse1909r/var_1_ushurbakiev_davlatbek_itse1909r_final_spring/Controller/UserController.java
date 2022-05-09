package com.kz.iitu.itse1909r.var_1_ushurbakiev_davlatbek_itse1909r_final_spring.Controller;

import com.kz.iitu.itse1909r.var_1_ushurbakiev_davlatbek_itse1909r_final_spring.Database.Role;
import com.kz.iitu.itse1909r.var_1_ushurbakiev_davlatbek_itse1909r_final_spring.Database.User;
import com.kz.iitu.itse1909r.var_1_ushurbakiev_davlatbek_itse1909r_final_spring.Service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
@Slf4j
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
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
    public List<Role> getRoles() throws SQLException {
        List<Role> roles = userService.getRoles();
        if (roles.isEmpty()) throw new IllegalStateException();
        return roles;
    }

    @PostMapping(value = "/create")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Response.Status create(@RequestBody User user) throws SQLException {
        List<User> listUsers = this.getAll();
        int lastId = listUsers.get(listUsers.size() - 1).getId();
        if (userService.create(user, lastId) == Response.Status.BAD_REQUEST) return Response.Status.BAD_REQUEST;
        return Response.Status.OK;
    }

    @DeleteMapping(value = "/delete")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Response.Status delete(@NotNull @RequestParam("id") Integer id) throws SQLException {
        if (userService.delete(id) == Response.Status.NOT_MODIFIED) return Response.Status.NOT_MODIFIED;
        return Response.Status.OK;
    }
}
