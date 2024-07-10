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
    private Employee emp;

    @Override
    public void run(String... args) throws Exception {
        log.info("save method-----------------");
        emp.save(new Employee2());

        log.info("read method-----------------");
        emp.read();
    }

}
