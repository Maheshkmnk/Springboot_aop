package com.kmnk.aop.repository;

import org.springframework.stereotype.Component;


@Component
public class Employee2 {
    private int login(int i){
        System.out.println("user login process initiated...");
        return i;
    }
    public String logout(String message){
        System.out.println("logout process initiated...");
        return "logged-out";
    }
    protected boolean sendMail(String body, String recepient){
        System.out.println("sending mail...");
        return true;
    }
}
