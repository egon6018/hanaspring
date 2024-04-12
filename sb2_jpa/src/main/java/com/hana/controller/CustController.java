package com.hana.controller;

import com.hana.app.data.dto.CustDto;
import com.hana.app.service.CustService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/cust") // 절대경로를 /html로 붙이기
@RequiredArgsConstructor
public class CustController {
    String dir = "cust/";

    final CustService custService; // 고객 정보를 불러오기 위해서는 필요

    @RequestMapping("/")
    public String main(Model model) {
        model.addAttribute("left", dir + "left");
        model.addAttribute("center", dir + "center");
        return "index";
    }

    @RequestMapping("/add")
    public String add(Model model) {
        model.addAttribute("left", dir + "left");
        model.addAttribute("center", dir + "add");
        return "index";
    }

    @RequestMapping("/addimpl")
    public String addimpl(Model model, CustDto custDto) {
        try {
            custService.add(custDto);
        } catch (Exception e) {
            //throw new RuntimeException(e);
            model.addAttribute("left", dir + "left");
            model.addAttribute("center", "registerfail");
            return "index";
        }

        return "redirect:/cust/detail?id="+custDto.getId();
    }

//    @RequestMapping("/get")
//    public String get(Model model) {
//        //@RequestParam("id") String id, @RequestParam("pwd") String pwd, @RequestParam("name") String name
//        // Data를 DB에서 조회한다. (DB에서 조회한거를 나한테 리턴받는다)
//        CustDto custDto = null;
//                //CustDto.builder().id(id).pwd(pwd).name(name).build();
//
//        try {
//            custDto = custService.get("id75");
//            model.addAttribute("custOne", custDto);
//            model.addAttribute("left", dir + "left");
//            model.addAttribute("center", dir + "get");
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//
//        return "index";
//    }

    @RequestMapping("/get")
    public String html3(Model model){
        // Data를 DB에서 조회 한다.
        List<CustDto> list = null;

        try {
            list = custService.get();
            model.addAttribute("custs", list);
            model.addAttribute("left", dir+"left");
            model.addAttribute("center",dir+"get");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return "index";
    }


    @RequestMapping("/detail")
    public String detail(Model model, @RequestParam("id") String id) {
        CustDto custDto = null;

        try {
            custDto = custService.get(id);
            model.addAttribute("cust", custDto);
            model.addAttribute("left", dir + "left");
            model.addAttribute("center", dir + "detail");
        } catch (Exception e) {
            //throw new RuntimeException(e);
            model.addAttribute("left", dir + "left");
            model.addAttribute("center", "registerfail");
        }

        return "index";
    }

}

