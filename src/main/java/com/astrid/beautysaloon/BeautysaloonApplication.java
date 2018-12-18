package com.astrid.beautysaloon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class BeautysaloonApplication {

  public static void main(String[] args) {
    SpringApplication.run(BeautysaloonApplication.class, args);
  }

}

