package com.hana.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jquery") // 절대경로를 /html로 붙이기
public class JqueryController {
    String dir="jquery/";
    @RequestMapping("/")
    public String main(Model model){
        model.addAttribute("left", dir+"left");
        model.addAttribute("center", dir+"center");
        return "index";
    }

    @RequestMapping("/jquery1")
    public String html1(Model model){
        model.addAttribute("left", dir+"left");
        model.addAttribute("center", dir+"jquery1");
        return "index";
    }

    @RequestMapping("/jquery2")
    public String html2(Model model){
        model.addAttribute("left", dir+"left");
        model.addAttribute("center", dir+"jquery2");
        return "index";
    }

    @RequestMapping("/jquery3")
    public String html3(Model model){
        model.addAttribute("left", dir+"left");
        model.addAttribute("center", dir+"jquery3");
        return "index";
    }
}
