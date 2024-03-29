package com.hana.controller;

import com.hana.app.data.dto.CustDto;
import com.hana.app.data.dto.ShopDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@RestController
public class AjaximplController {
    @RequestMapping("/getservertime")
    public Object getservertime(){
        Date date = new Date();
        return date;
    }

    @RequestMapping("/geo/getdata")
    public Object geogetdata(){
        List<ShopDto> list = new ArrayList<>();
        list.add(new ShopDto(100,"순대국","a.jpg",37.5747611,127.0654625));
        list.add(new ShopDto(101,"파스타","b.jpg",37.5747611,127.0554625));
        list.add(new ShopDto(102,"햄버거","c.jpg",37.5747611,127.0154625));
        return list;
    }

    @RequestMapping("/checkid")
    public Object checkid(@RequestParam("id") String id){
        String result = "1";
        if(id.equals("qqq")){ // id 'qqq'는 이미 db에 있으니까 더이상 되지 않도록
            result = "0";
        }
        return result;
    }
}
