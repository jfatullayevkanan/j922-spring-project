package com.example.j922springproject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.beans.Encoder;

@Configuration
public class BeanConfig {

    @Bean
    Encoder getEncoder() {
        return new Encoder();
    }
}
