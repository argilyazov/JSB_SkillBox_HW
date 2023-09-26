package com.example.sbhw.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Person {
    Pet pet;
    public void callPet(){
        System.out.println("Call my pet");
        pet.say();
    }
}
