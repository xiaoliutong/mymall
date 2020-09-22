package com.marco.mymall.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Date:2020/9/20 17:36
 * @Authour:lenovo
 * @Description:
 */
@SpringBootApplication
public class StratAdmin {
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(StratAdmin.class);
        springApplication.run(args);
    }
}
