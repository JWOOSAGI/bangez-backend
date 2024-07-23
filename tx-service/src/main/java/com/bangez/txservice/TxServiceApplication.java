package com.bangez.txservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class TxServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TxServiceApplication.class, args);
    }

}
