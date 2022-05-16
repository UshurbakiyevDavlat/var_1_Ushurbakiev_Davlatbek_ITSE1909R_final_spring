package com.kz.iitu.itse1909r.var_1_ushurbakiev_davlatbek_itse1909r_final_spring.Aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.SourceLocation;
import org.aspectj.runtime.internal.AroundClosure;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.jms.JMSException;
import java.util.logging.Logger;

import static org.mockito.Mockito.*;

class AspectLogAllTest {
    @Mock
    Logger log;
    @InjectMocks
    AspectLogAll aspectLogAll;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testTokenProcessingMethods() {
        aspectLogAll.tokenProcessingMethods();
    }

    @Test
    void testExecTime() throws Throwable {
        Object result = aspectLogAll.ExecTime(new ProceedingJoinPoint() {
            @Override
            public void set$AroundClosure(AroundClosure aroundClosure) {

            }

            @Override
            public Object proceed() throws Throwable {
                return null;
            }

            @Override
            public Object proceed(Object[] objects) throws Throwable {
                return null;
            }

            @Override
            public String toShortString() {
                return null;
            }

            @Override
            public String toLongString() {
                return null;
            }

            @Override
            public Object getThis() {
                return null;
            }

            @Override
            public Object getTarget() {
                return null;
            }

            @Override
            public Object[] getArgs() {
                return new Object[0];
            }

            @Override
            public Signature getSignature() {
                return null;
            }

            @Override
            public SourceLocation getSourceLocation() {
                return null;
            }

            @Override
            public String getKind() {
                return null;
            }

            @Override
            public StaticPart getStaticPart() {
                return null;
            }
        });
        Assertions.assertNull(result);
    }

    @Test
    void testWithinException() {
        aspectLogAll.WithinException(new ProceedingJoinPoint() {
            @Override
            public void set$AroundClosure(AroundClosure aroundClosure) {

            }

            @Override
            public Object proceed() throws Throwable {
                return null;
            }

            @Override
            public Object proceed(Object[] objects) throws Throwable {
                return null;
            }

            @Override
            public String toShortString() {
                return null;
            }

            @Override
            public String toLongString() {
                return null;
            }

            @Override
            public Object getThis() {
                return null;
            }

            @Override
            public Object getTarget() {
                return null;
            }

            @Override
            public Object[] getArgs() {
                return new Object[0];
            }

            @Override
            public Signature getSignature() {
                return null;
            }

            @Override
            public SourceLocation getSourceLocation() {
                return null;
            }

            @Override
            public String getKind() {
                return null;
            }

            @Override
            public StaticPart getStaticPart() {
                return null;
            }
        },new JMSException("null"));
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme