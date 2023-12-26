package org.example.lab.app.services;

import org.apache.log4j.Logger;
import org.example.lab.web.dto.LoginForm;
import org.springframework.stereotype.Service;

@Service
public class LoginService {


    public boolean authenticate(LoginForm loginFrom) {
        return loginFrom.getUsername().equals("gilyazov") && loginFrom.getPassword().equals("111");
    }
}
