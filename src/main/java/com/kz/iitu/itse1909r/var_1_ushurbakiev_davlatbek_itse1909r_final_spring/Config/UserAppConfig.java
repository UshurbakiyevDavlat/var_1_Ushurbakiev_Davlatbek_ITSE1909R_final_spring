package com.kz.iitu.itse1909r.var_1_ushurbakiev_davlatbek_itse1909r_final_spring.Config;

import com.kz.iitu.itse1909r.var_1_ushurbakiev_davlatbek_itse1909r_final_spring.Service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;

import java.sql.SQLException;

@Configuration
@Slf4j
@ComponentScan(basePackages = "com.kz.iitu.itse1909r.var_1_ushurbakiev_davlatbek_itse1909r_final_spring")
@PropertySource("classpath:application.properties")
public class UserAppConfig {
    private final UserService userService;

    @Autowired
    public UserAppConfig(UserService userService) {
        this.userService = userService;
    }


    @Bean(initMethod = "", destroyMethod = "")
    @Lazy
    public void getUsers() throws SQLException {
        userService.getUsers().forEach(users -> log.info("User: {}", users));
    }
}
