package com.adrien;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ConsulProducerApplication02 {
    public static void main( String[] args ) {
        SpringApplication.run(ConsulProducerApplication02.class,args);
    }
}
