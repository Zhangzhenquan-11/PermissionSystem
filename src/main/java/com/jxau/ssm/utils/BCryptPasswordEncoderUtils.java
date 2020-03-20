package com.jxau.ssm.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptPasswordEncoderUtils {

    private static BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    public static String encodePassword(String password){
        return bCryptPasswordEncoder.encode(password);
    }

    public static void main(String[] args) {
        String password = "123";
        String pwd = encodePassword(password);
        //$2a$10$Qw11T2Y5TvIRPxzLf3hcIu7iZtIhHaK5zm8IBDD67CtxJ0/JnvmYG
        System.out.println(pwd);
    }
}
