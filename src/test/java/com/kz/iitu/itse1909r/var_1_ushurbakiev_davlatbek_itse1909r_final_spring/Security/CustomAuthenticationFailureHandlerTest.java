package com.kz.iitu.itse1909r.var_1_ushurbakiev_davlatbek_itse1909r_final_spring.Security;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.context.MessageSource;
import org.springframework.security.core.AuthenticationException;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.logging.Logger;

import static org.mockito.Mockito.*;

class CustomAuthenticationFailureHandlerTest {
    @Mock
    ObjectMapper objectMapper;
    @Mock
    MessageSource messages;
    @Mock
    Logger log;
    @InjectMocks
    CustomAuthenticationFailureHandler customAuthenticationFailureHandler;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testOnAuthenticationFailure() throws ServletException, IOException {
        String msg = "test error";
        customAuthenticationFailureHandler.onAuthenticationFailure(null, null, new AuthenticationException (msg) {
            @Override
            public String toString() {
                return super.toString();
            }
        });
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme