package com.adrien;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class EurekaZuulServiceApplication {
    public static void main( String[] args ) {
        SpringApplication.run(EurekaZuulServiceApplication.class,args);
    }
}
