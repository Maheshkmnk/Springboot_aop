package com.kmnk.aop.service;


import com.kmnk.aop.repository.Employee;
import com.kmnk.aop.repository.Employee2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@Slf4j
public class BusinessLogic implements CommandLineRunner {
    @Autowired
    private Employee employee1;

    @Override
    public void run(String... args) throws Exception {

        log.info("save method-----------------");
        employee1.save(new Employee2());

//        log.info("read method-----------------");
//        employee.read();
//
//        log.info("delete method-----------------");
//        employee.delete(1);

//        log.info("login method-----------------");
//        employee.login(3);

        log.info("sendMail method-----------------");
        employee1.sendMail("completed", "karthik");
//
//        log.info("logout method-----------------");
//        employee.logout("successfully logged out");

    }

}
