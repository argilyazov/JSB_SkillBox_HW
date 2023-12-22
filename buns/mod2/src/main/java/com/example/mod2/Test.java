package com.example.mod2;


import com.example.mod2.domain.Book;
import com.example.mod2.domain.Library;
import com.example.mod2.domain.UniLibrary;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args){
        var context = new AnnotationConfigApplicationContext(Config.class);
        var uniLibrary = context.getBean("uniLibrary", UniLibrary.class);
        var book = new Book("Война и мир","Л.Н. Толстой");
        uniLibrary.getBook(book);
        uniLibrary.addAuthor("Достоевский");
        //uniLibrary.addAuthor("Достоевский");
        uniLibrary.returnBook(book);
        context.close();
    }
}
