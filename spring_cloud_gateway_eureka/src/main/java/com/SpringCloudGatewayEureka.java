package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringCloudGatewayEureka {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudGatewayEureka.class,args);
    }
}
