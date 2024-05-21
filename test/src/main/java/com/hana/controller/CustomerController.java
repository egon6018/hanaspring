package com.hana.controller;

import com.hana.app.data.dto.CommunityDto;
import com.hana.app.data.dto.CustomerDto;
import com.hana.app.data.dto.CustomerQnaDto;
import com.hana.app.data.dto.MemberDto;
import com.hana.app.service.CustomerQnaService;
import com.hana.app.service.CustomerService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {
    final CustomerService customerService;
    final CustomerQnaService customerQnaService;

    String dir= "customer/";

    @RequestMapping("/")
    public String main(Model model){
        return "index";
    }

    @RequestMapping("/customer01")
    public String customer01(Model model, HttpSession httpSession){
        if(httpSession.getAttribute("id") == null) {
            model.addAttribute("location","/member/login");
            model.addAttribute("msg","로그인 후 사용하세요.");
            return "alert";
        }

        model.addAttribute("center",dir+"customer01");
        return "index";
    }
    @RequestMapping("/customerimpl")
    public String customerimpl(Model model, CustomerDto customerDto, HttpSession httpSession){
        if(httpSession.getAttribute("id") == null) {
            model.addAttribute("location","/member/login");
            model.addAttribute("msg","로그인 후 사용하세요.");
            return "alert";
        }

        try {
            customerService.add(customerDto);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        model.addAttribute("location","/");
        model.addAttribute("msg","1대1 문의가 전송되었습니다.");
        return "alert";
    }

    @RequestMapping("/customer02")
    public String customer02(Model model, HttpSession httpSession){
        if(httpSession.getAttribute("id") == null) {
            model.addAttribute("location","/member/login");
            model.addAttribute("msg","로그인 후 사용하세요.");
            return "alert";
        }

        List<CustomerQnaDto> list = new ArrayList<>();
        try {
            list = customerQnaService.get();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        model.addAttribute("qnalist",list);
        model.addAttribute("center",dir+"customer02");

        return "index";
    }
    @RequestMapping("/customerOneSearch")
    public String customerOneSearch(Model model, HttpSession session,
                                     @RequestParam("keyword") String keyword,
                                     @RequestParam("select") String select) throws Exception {
        List<CustomerQnaDto> list = customerQnaService.search(keyword, select);
        model.addAttribute("qnalist",list);
        model.addAttribute("center",dir+"customer02");

        return "index";
    }
    @RequestMapping("/customer02_3")
    public String customer02_3(Model model, @RequestParam("idx") int idx){
        CustomerQnaDto customerQnaDto = null;
        try {
            customerQnaDto = customerQnaService.get(idx);
            model.addAttribute("qnaidx", customerQnaDto);
            model.addAttribute("center",dir+"customer02_3");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return "index";
    }
    @RequestMapping("/customer02_3impl")
    public String customer02_3impl(@RequestParam("qnaidx") int qnaidx, @RequestParam("qnaPw") String pwd, Model model, HttpSession httpSession){
        //CustomerQnaDto customerQnaDto1 = null;
        CustomerQnaDto customerQnaDto2 = null;
        try {
            //customerQnaDto1 = customerQnaService.get(idx);
            customerQnaDto2 = customerQnaService.findQna(pwd);
            httpSession.setAttribute("qnapwd", pwd);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        if(customerQnaDto2 == null){
            model.addAttribute("center", dir + "customer02_3");
            model.addAttribute("location","customer02");
            model.addAttribute("msg", "조회되는 정보가 없습니다. 다시시도해주세요");
            return "alert";
        }

        return "redirect:/customer/customer02_4?idx="+qnaidx;
    }
    @RequestMapping("/customer02_4")
    public String customer02_4(Model model,@RequestParam("idx") int idx){
        // Database에서 데이터를 가지고 온다.
        CustomerQnaDto customerQnaDto = null;
        try {
            customerQnaDto = customerQnaService.get(idx);
            model.addAttribute("qnaidx", customerQnaDto);
            model.addAttribute("center",dir+"customer02_4");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "index";
    }

    @RequestMapping("/customer02_2")
    public String customer02_2(Model model){
        model.addAttribute("center",dir+"customer02_2");
        return "index";
    }

    @RequestMapping("/customer03")
    public String customer03(Model model, HttpSession httpSession){
        if(httpSession.getAttribute("id") == null) {
            model.addAttribute("location","/member/login");
            model.addAttribute("msg","로그인 후 사용하세요.");
            return "alert";
        }

        model.addAttribute("center",dir+"customer03");
        return "index";
    }

}
