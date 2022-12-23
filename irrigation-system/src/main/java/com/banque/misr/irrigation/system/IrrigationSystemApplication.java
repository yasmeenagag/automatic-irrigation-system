package com.banque.misr.irrigation.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableRetry
public class IrrigationSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(IrrigationSystemApplication.class, args);
    }

}
