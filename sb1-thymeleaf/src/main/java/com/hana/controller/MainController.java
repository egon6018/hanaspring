package com.hana.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    @RequestMapping("/")
    public String main(){
        return "main"; // main.jsp를 실행시키도록
    }

    @RequestMapping("/login")
    public String login(Model model){
        model.addAttribute("centerpage", "login");
        return "main"; // main.jsp를 실행시키도록
    }

    @RequestMapping("/register")
    public String register(Model model){
        model.addAttribute("centerpage", "register");
        return "main"; // main.jsp를 실행시키도록
    }
}
