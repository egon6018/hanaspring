package com.hana.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/geo") // 절대경로를 /html로 붙이기
public class GeoController {
    String dir="geo/";
    @RequestMapping("/")
    public String main(Model model){
        model.addAttribute("left", dir+"left");
        model.addAttribute("center", dir+"center");
        return "index";
    }

    @RequestMapping("/geo1")
    public String html1(Model model){
        model.addAttribute("left", dir+"left");
        model.addAttribute("center", dir+"geo1");
        return "index";
    }

    @RequestMapping("/geo2")
    public String html2(Model model){
        model.addAttribute("left", dir+"left");
        model.addAttribute("center", dir+"geo2");
        return "index";
    }

    @RequestMapping("/geo3")
    public String html3(Model model){
        model.addAttribute("left", dir+"left");
        model.addAttribute("center", dir+"geo3");
        return "index";
    }
}
