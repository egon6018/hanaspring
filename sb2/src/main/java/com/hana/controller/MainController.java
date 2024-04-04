package com.hana.controller;

import com.hana.app.data.dto.CustDto;
import com.hana.app.service.CustService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
@RequiredArgsConstructor
public class MainController {

    final CustService custService;

    @RequestMapping("/")
    public String main(){
        return "index";
    }

    @RequestMapping("/login")
    public String login(Model model){
        model.addAttribute("center","login");
        return "index";
    }
    @RequestMapping("/logout")
    public String logout(Model model, HttpSession httpSession){
        if(httpSession != null){
            httpSession.invalidate();
        }
        return "index";
    }
    @RequestMapping("/loginimpl")
    public String loginimpl(Model model,
                            @RequestParam("id") String id,
                            @RequestParam("pwd") String pwd, HttpSession httpSession){

        CustDto custDto = null;
        try {
            custDto = custService.get(id);
            if(custDto == null){ // 이 사람이 로그인 했는데 해당id가 db에 없는 경우
                throw new Exception();
            }
            if(!custDto.getPwd().equals(pwd)){ // id는 찾았는데 패스워드가 같지 않으면
                throw new Exception();
            }
            httpSession.setAttribute("id", id);
        } catch (Exception e) {
            //throw new RuntimeException(e);
            model.addAttribute("center","loginfail"); // 로그인 실패하면 loginfail파일로
        }


//        if(id.equals("qqq") && pwd.equals("111")){
//            //httpSession.setMaxInactiveInterval(80000);
//            log.info(id);
//            httpSession.setAttribute("id", id);
//        }else{
//            model.addAttribute("center","loginfail");
//        }


        return "index";
    }

    @RequestMapping("/registerimpl")
    public String registerimpl(Model model,
                               CustDto custDto, HttpSession httpSession){
//        log.info(custDto.getId());
//        log.info(custDto.getName());

        try{
            custService.add(custDto);
            httpSession.setAttribute("id", custDto.getId());
        } catch (Exception e) {
            // 동일한 id를 register하면 db에 이미 있으니까 에러
            //throw new RuntimeException(e);

            model.addAttribute("center","registerfail"); // 에러 나면 registerfail파일로
        }

        return "index";
    }
    @RequestMapping("/register")
    public String register(Model model){
        model.addAttribute("center","register");
        return "index";
    }
}


//package com.hana.controller;
//
//import jakarta.servlet.http.HttpSession;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//@Controller
//@Slf4j // log.info()쓰고 싶을때 ==> lombok에서 디버깅해볼 수 있음. 콘솔창에 System.out.println()해서 디버깅하는 것처럼
//public class MainController {
//    @RequestMapping("/")
//    public String main(){
//        return "index"; // index.jsp를 실행시키도록
//    }
//
//    @RequestMapping("/login")
//    public String login(Model model){
//        model.addAttribute("center", "login");
//        return "index";
//    }
//
//    @RequestMapping("/logout")
//    public String logout(Model model, HttpSession httpSession){
//        if(httpSession != null){
//            httpSession.invalidate(); // 세션에서는 다시 저장하지 않는다.
//        }
//        return "index";
//    }
//
//    @RequestMapping("/loginimpl")
//    public String loginimpl(Model model,
//                            @RequestParam("id") String id,
//                            @RequestParam("pwd") String pwd,
//                            HttpSession httpSession){
////        log.info("--------------------------------------------------");
////        log.info(id+" "+pwd);
//        if(id.equals("qqq") && pwd.equals("111")){ // 로그인 성공
//            //httpSession.setMaxInactiveInterval(80000); // 1초 1000ms
//            log.info(id);
//            httpSession.setAttribute("id", id);
//        } else { // 로그인 실패
//            model.addAttribute("center", "loginfail"); // 페이지 이동
//        }
//
//        return "index";
//    }
//
//    @RequestMapping("/register")
//    public String register(Model model){
//        model.addAttribute("center", "register");
//        return "index";
//    }
//}
