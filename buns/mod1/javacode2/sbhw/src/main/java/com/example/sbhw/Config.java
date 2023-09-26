package com.example.sbhw;

import com.example.sbhw.domain.Dog;
import com.example.sbhw.domain.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public Dog dogBean(){
        return new Dog();
    }

    @Bean
    public Person personBean(){
        return new Person(dogBean());
    }
}
