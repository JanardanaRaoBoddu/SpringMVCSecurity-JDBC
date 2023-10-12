package com.jana.demoSpringMVCSecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogInController {

    @GetMapping("/showMyLoginPage")
    public String showMyLoginPage(){
        return "customized-Login";
    }

    //add request mapping for access denied
    @GetMapping("/access-denied")
    public String showAccessDenied(){
        return "access-denied";
    }
}
