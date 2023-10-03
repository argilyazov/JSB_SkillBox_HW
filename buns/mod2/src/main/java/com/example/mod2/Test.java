package com.example.mod2;


import com.example.mod2.domain.Library;
import com.example.mod2.domain.UniLibrary;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args){
        var context = new AnnotationConfigApplicationContext(Config.class);
        var uniLibrary = context.getBean("uniLibrary", UniLibrary.class);
        uniLibrary.getBook();
        uniLibrary.addAuthor("Достоевский");
        uniLibrary.addAuthor("Достоевский");
        uniLibrary.returnBook();
        context.close();
    }
}
