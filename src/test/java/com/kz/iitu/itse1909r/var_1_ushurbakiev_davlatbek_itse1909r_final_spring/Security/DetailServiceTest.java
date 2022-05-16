package com.kz.iitu.itse1909r.var_1_ushurbakiev_davlatbek_itse1909r_final_spring.Security;

import com.kz.iitu.itse1909r.var_1_ushurbakiev_davlatbek_itse1909r_final_spring.Database.Address;
import com.kz.iitu.itse1909r.var_1_ushurbakiev_davlatbek_itse1909r_final_spring.Database.Role;
import com.kz.iitu.itse1909r.var_1_ushurbakiev_davlatbek_itse1909r_final_spring.Database.User;
import com.kz.iitu.itse1909r.var_1_ushurbakiev_davlatbek_itse1909r_final_spring.Repository.RoleRepository;
import com.kz.iitu.itse1909r.var_1_ushurbakiev_davlatbek_itse1909r_final_spring.Repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;

import static org.mockito.Mockito.*;

class DetailServiceTest {
    @Mock
    UserRepository userRepository;
    @Mock
    RoleRepository roleRepository;
    @Mock
    PasswordEncoder passwordEncoder;
    @Mock
    LoginAttemptService loginAttemptService;
    @Mock
    HttpServletRequest request;
    @Mock
    Logger log;
    @InjectMocks
    DetailService detailService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testLoadUserByUsername() {
        User user = new User();
        user.setLogin("Name");
        user.setPassword("test");
        user.setStatus(1);
        user.setAddress(new Address());
        user.setAge(22);
        Role role = new Role();
        role.setId(1);
        role.setTitle("Admin");
        user.setRole(role);
        when(userRepository.getUserByLogin(anyString())).thenReturn(Arrays.<User>asList(user));
        when(roleRepository.getAll()).thenReturn(Arrays.<Role>asList(role));
        when(loginAttemptService.isBlocked(anyString())).thenReturn(true);


        try {
            UserDetails result = detailService.loadUserByUsername(
                    user.getLogin()
            );
        } catch (Exception e) {
            Assertions.assertNotNull(e);
        }
    }

    private Collection<? extends GrantedAuthority> getAuthorities(
            Collection<String> roles) {
        log.info(roles.toString());

        List<GrantedAuthority> authorities
                = new ArrayList<>();
        for (String role : roles) {
            authorities.add(new SimpleGrantedAuthority(role));
        }

        log.info(authorities.toString());
        return authorities;
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme