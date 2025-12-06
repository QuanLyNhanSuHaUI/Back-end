package com.example.quanlynhansu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class QuanLyNhanSuApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuanLyNhanSuApplication.class, args);
        System.out.println("APP is running!----------------------------------------------------------------");
    }

}
