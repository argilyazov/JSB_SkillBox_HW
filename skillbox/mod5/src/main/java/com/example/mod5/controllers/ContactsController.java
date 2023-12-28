package com.example.mod5.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/contacts")
public class ContactsController {

    @GetMapping
    public String getContactsPage(){
        return "contacts";
    }
}
