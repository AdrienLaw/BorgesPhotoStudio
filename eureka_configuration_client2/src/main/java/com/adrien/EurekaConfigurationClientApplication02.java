package com.adrien;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
public class EurekaConfigurationClientApplication02 {
    public static void main( String[] args ) {
        SpringApplication.run(EurekaConfigurationClientApplication02.class,args);
    }
}
