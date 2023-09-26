package com.example.sbhw;

import com.example.sbhw.domain.Dog;
import com.example.sbhw.domain.Person;
import com.example.sbhw.domain.Pet;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("aplicationContext.xml");
        var person = context.getBean("person", Person.class);
        person.callPet();
        context.close();
    }
}
