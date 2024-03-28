package com.hana.controller;

import com.hana.app.data.dto.CustDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/cust")
public class CustController {
    String dir = "cust/";

    @RequestMapping("/get")
    public String get(Model model){
        // Databse에서 데이터를 가지고 온다.
        List<CustDto> list = new ArrayList<>();
        list.add(new CustDto("id01","pwd01","james"));
        list.add(new CustDto("id02","pwd02","james"));
        list.add(new CustDto("id03","pwd03","james"));
        list.add(new CustDto("id04","pwd04","james"));
        list.add(new CustDto("id05","pwd05","james"));
        list.add(new CustDto("id06","pwd06","james"));
        list.add(new CustDto("id07","pwd07","james"));
        list.add(new CustDto("id08","pwd08","james"));
        list.add(new CustDto("id09","pwd09","james"));
        list.add(new CustDto("id010","pwd10","james"));

        model.addAttribute("custs", list);
        model.addAttribute("center",dir+"get");
        return "index";
    }
}
