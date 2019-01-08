package com.ycj.reservation.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class DecodePassword {

    public static void main(String [] args){
        System.out.println(new DecodePassword().docode("yi"));
    }
    public String docode(String password){
        return new BCryptPasswordEncoder().encode(password);
    }
}
