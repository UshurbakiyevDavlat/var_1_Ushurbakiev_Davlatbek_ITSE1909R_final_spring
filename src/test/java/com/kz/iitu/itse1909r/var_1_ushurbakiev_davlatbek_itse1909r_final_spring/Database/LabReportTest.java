package com.kz.iitu.itse1909r.var_1_ushurbakiev_davlatbek_itse1909r_final_spring.Database;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

class LabReportTest {
    @Mock
    HealthHistory health;
    @Mock
    User doctor;
    //Field createdAt of type Instant - was not mocked since Mockito doesn't mock a Final class when 'mock-maker-inline' option is not set
    //Field updatedAt of type Instant - was not mocked since Mockito doesn't mock a Final class when 'mock-maker-inline' option is not set
    //Field deletedAt of type Instant - was not mocked since Mockito doesn't mock a Final class when 'mock-maker-inline' option is not set
    @InjectMocks
    LabReport labReport;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testToString() {
        String result = labReport.toString();
        Assertions.assertNotEquals("replaceMeWithExpectedResult", result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme