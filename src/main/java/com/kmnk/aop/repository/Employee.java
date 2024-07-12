package com.kmnk.aop.repository;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.validation.annotation.Validated;

import java.util.Random;

@Component
@Slf4j
public class Employee {

    @Validated
    public void save(Employee2 emp2){
//        if(new Random().nextInt(12) < 10){
//            throw new RuntimeException("Dummy exception....");
//        }
        log.info("record saving...");
    }
    public int delete(int i){
        log.info("deleting record...");
        return i;
    }
//    protected Employee2 uppdate(){
//        System.out.println("updating record...");
//        return new Employee2();
//    }
    public String read(){
        log.info("reading the data...");
        return "Success";
    }

    public int login(int i){
        log.info("user login process initiated...");
        return i;
    }
    public String logout(String message){
        log.info("logout process initiated...");
        return "logged-out";
    }

    @Validated
    public boolean sendMail(String body, String recipient){
        log.info("sending mail to {} with body {}",recipient, body);
        return true;
    }
}
