package org.example.mod2.config;

import org.example.mod2.services.IdProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "org.example.mod2")
public class AppContextConfig {

    @Bean
    public IdProvider idProvider() {
        return new IdProvider();
    }
}
