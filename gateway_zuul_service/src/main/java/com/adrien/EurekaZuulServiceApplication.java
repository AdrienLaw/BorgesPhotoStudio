package com.adrien;

import com.adrien.filter.TokenFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableZuulProxy
public class EurekaZuulServiceApplication {
    public static void main( String[] args ) {
        SpringApplication.run(EurekaZuulServiceApplication.class,args);
    }

    @Bean
    public TokenFilter tokenFilter() {
        return new TokenFilter();
    }
}
