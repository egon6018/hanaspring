package com.hana.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/company")
@RequiredArgsConstructor
public class CompanyController {
    String dir= "company/";

    @RequestMapping("/")
    public String main(Model model){
        return "index";
    }

    @RequestMapping("/company01")
    public String company01(Model model){
        model.addAttribute("center",dir+"company01");
        return "index";
    }

    @RequestMapping("/company03")
    public String company03(Model model){
        model.addAttribute("center",dir+"company03");
        return "index";
    }

}
