package com.example.sbhw;

import com.example.sbhw.domain.Dog;
import com.example.sbhw.domain.Person;
import com.example.sbhw.domain.Pet;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args){
        var context = new AnnotationConfigApplicationContext(Config.class);
        var person = context.getBean("personBean", Person.class);
        person.callPet();
        context.close();
    }
}
