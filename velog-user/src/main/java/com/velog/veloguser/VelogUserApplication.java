package com.velog.veloguser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class VelogUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(VelogUserApplication.class, args);
    }

}
