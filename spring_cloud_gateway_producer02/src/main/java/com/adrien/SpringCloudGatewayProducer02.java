package com.adrien;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringCloudGatewayProducer02 {
    public static void main( String[] args ) {
        SpringApplication.run(SpringCloudGatewayProducer02.class,args);
    }
}
