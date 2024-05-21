package com.hana.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/business")
@RequiredArgsConstructor
public class BusinessController {
    String dir= "business/";

    @RequestMapping("/")
    public String main(Model model){
        return "index";
    }

    @RequestMapping("/business01")
    public String company01(Model model){
        model.addAttribute("center",dir+"business01");
        return "index";
    }



}
