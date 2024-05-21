package com.hana.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    String dir= "product/";

    @RequestMapping("/")
    public String main(Model model){
        return "index";
    }

    @RequestMapping("/product01")
    public String product01(Model model){
        model.addAttribute("center",dir+"product01");
        return "index";
    }



}
