package com.example.sbhw.domain;

import org.springframework.stereotype.Component;

@Component
public class Dog implements Pet{
    @Override
    public void say() {
        System.out.println("wow-wow");
    }
}
