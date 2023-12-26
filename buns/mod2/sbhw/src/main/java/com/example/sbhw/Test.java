package com.example.sbhw;

import com.example.sbhw.domain.Library;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args){
        var context = new AnnotationConfigApplicationContext(Config.class);
        var uniLibrary = context.getBean("uniLibrary", Library.class);
        uniLibrary.getBook();
        uniLibrary.addAuthor("Достоевский");
        uniLibrary.returnBook();
        uniLibrary.getAuthors();
        context.close();
    }
}
