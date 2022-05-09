package com.kz.iitu.itse1909r.var_1_ushurbakiev_davlatbek_itse1909r_final_spring;

import com.kz.iitu.itse1909r.var_1_ushurbakiev_davlatbek_itse1909r_final_spring.Config.SettingsAppConfig;
import com.kz.iitu.itse1909r.var_1_ushurbakiev_davlatbek_itse1909r_final_spring.Config.UserAppConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

import java.sql.SQLException;

@Slf4j
@EnableAspectJAutoProxy
@Import({SettingsAppConfig.class, UserAppConfig.class})
@SpringBootApplication
public class SpringApplicationDavlat {

    public static void main(String[] args) throws SQLException {
        SpringApplication.run(SpringApplicationDavlat.class, args);
    }

}
