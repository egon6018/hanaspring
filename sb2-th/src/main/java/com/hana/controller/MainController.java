package com.hana.controller;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j // log.info()쓰고 싶을때 ==> lombok에서 디버깅해볼 수 있음. 콘솔창에 System.out.println()해서 디버깅하는 것처럼
public class MainController {
    @RequestMapping("/")
    public String main(){
        return "index"; // index.jsp를 실행시키도록
    }

    @RequestMapping("/login")
    public String login(Model model){
        model.addAttribute("center", "login");
        return "index";
    }

    @RequestMapping("/logout")
    public String logout(Model model, HttpSession httpSession){
        if(httpSession != null){
            httpSession.invalidate(); // 세션에서는 다시 저장하지 않는다.
        }
        return "index";
    }

    @RequestMapping("/loginimpl")
    public String loginimpl(Model model,
                            @RequestParam("id") String id,
                            @RequestParam("pwd") String pwd,
                            HttpSession httpSession){
//        log.info("--------------------------------------------------");
//        log.info(id+" "+pwd);
        if(id.equals("qqq") && pwd.equals("111")){ // 로그인 성공
            //httpSession.setMaxInactiveInterval(80000); // 1초 1000ms
            httpSession.setAttribute("id", id);
        } else { // 로그인 실패
            model.addAttribute("center", "loginfail"); // 페이지 이동
        }

        return "index";
    }

    @RequestMapping("/register")
    public String register(Model model){
        model.addAttribute("center", "register");
        return "index";
    }
}
