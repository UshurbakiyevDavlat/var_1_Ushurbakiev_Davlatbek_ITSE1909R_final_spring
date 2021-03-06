package com.kz.iitu.itse1909r.var_1_ushurbakiev_davlatbek_itse1909r_final_spring.Aop;

import lombok.extern.java.Log;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Aspect
@Log
public class Aspects {

    @Pointcut("@annotation(LogToken)")
    public void tokenProcessingMethods() {
    }

    @Before("tokenProcessingMethods()")
    public void meBefore(JoinPoint point) {
        log.info("From method: " + point.getSignature().getName() + ", execution. timestamp: " + new Date().getTime());
    }


    @After("tokenProcessingMethods()")
    public void meAfter(JoinPoint point) {
        log.info("from method: " + point.getSignature().getName() + ",executed. Time: " + new Date().getTime());
    }

    @AfterReturning(pointcut = "execution(public * com.kz.iitu.itse1909r.var_1_ushurbakiev_davlatbek_itse1909r_final_spring.Service.UserService.getUsers())", returning = "result")
    public void checkAllUsers(JoinPoint point, Object result) {
        log.info("Checked in the method: " + point.getSignature().getName() + ": We have this list of user data: ");
        log.info(result.toString());
    }

    @AfterReturning(pointcut = "execution(public * com.kz.iitu.itse1909r.var_1_ushurbakiev_davlatbek_itse1909r_final_spring.Service.UserService.getUserById(int))", returning = "result")
    public void checkUserByID(JoinPoint point, Object result) {
        log.info("Checked in the method: " + point.getSignature().getName() + ": We have this list of user data: ");
        log.info(result.toString());
    }

    @AfterReturning(pointcut = "execution(public * com.kz.iitu.itse1909r.var_1_ushurbakiev_davlatbek_itse1909r_final_spring.Service.UserService.getUserByLogin(String))", returning = "result")
    public void checkUserByLogin(JoinPoint point, Object result) {
        log.info("Checked in the method: " + point.getSignature().getName() + ": We have this list of user data: ");
        log.info(result.toString());
    }

    @AfterReturning(pointcut = "execution(public * com.kz.iitu.itse1909r.var_1_ushurbakiev_davlatbek_itse1909r_final_spring.Service.UserService.getRoles())", returning = "result")
    public void checkUserRoles(JoinPoint point, Object result) {
        log.info("Checked in the method: " + point.getSignature().getName() + ": We have this list of roles data: ");
        log.info(result.toString());
    }

    @AfterReturning(pointcut = "execution(public * com.kz.iitu.itse1909r.var_1_ushurbakiev_davlatbek_itse1909r_final_spring.Service.UserService.create())", returning = "result")
    public void checkCreationOfUser(JoinPoint point, Object result) {
        log.info("Checked in the method: " + point.getSignature().getName() + ": We have this creation of user: ");
        log.info(result.toString());
    }

    @AfterReturning(pointcut = "execution(public * com.kz.iitu.itse1909r.var_1_ushurbakiev_davlatbek_itse1909r_final_spring.Service.UserService.delete())", returning = "result")
    public void checkDeletionOfData(JoinPoint point, Object result) {
        log.info("Checked in the method: " + point.getSignature().getName() + ": We have this deletion of user data: ");
        log.info(result.toString());
    }

    @AfterReturning(pointcut = "execution(public * com.kz.iitu.itse1909r.var_1_ushurbakiev_davlatbek_itse1909r_final_spring.Service.HealthService.getAllHistories())", returning = "result")
    public void checkHealthHistory(JoinPoint point, Object result) {
        log.info("Checked in the method: " + point.getSignature().getName() + ": We check histories of health: ");
        log.info(result.toString());
    }

    @AfterReturning(pointcut = "execution(public * com.kz.iitu.itse1909r.var_1_ushurbakiev_davlatbek_itse1909r_final_spring.Service.HealthService.getAllLabs())", returning = "result")
    public void checkLabsHistory(JoinPoint point, Object result) {
        log.info("Checked in the method: " + point.getSignature().getName() + ": We check histories of labs: ");
        log.info(result.toString());
    }

    @AfterReturning(pointcut = "execution(public * com.kz.iitu.itse1909r.var_1_ushurbakiev_davlatbek_itse1909r_final_spring.Service.HealthService.update())", returning = "result")
    public void checkUpdationOfHealthCard(JoinPoint point, Object result) {
        log.info("Checked in the method: " + point.getSignature().getName() + ": We update health card: ");
        log.info(result.toString());
    }

}
