package com.example.sbhw.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@AllArg
@FieldDefaults(level = AccsConstructoressLevel.PRIVATE)
@Component
public class Person {
    @Autowired
    Pet pet;
    public void callPet(){
        System.out.println("Call my pet");
        pet.say();
    }
}
