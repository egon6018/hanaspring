package com.hana.controller;

import com.hana.app.data.dto.MemberDto;
import com.hana.app.service.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
@Slf4j
public class MemberController {
    String dir= "member/";

    final MemberService memberService;

    @RequestMapping("/")
    public String main(Model model){
        return "index";
    }

    @RequestMapping("/login")
    public String login(Model model){
        model.addAttribute("center",dir+"login");
        return "index";
    }
    @RequestMapping("/loginimpl")
    public String loginimpl(Model model,
                            @RequestParam("memberId") String id,
                            @RequestParam("memberPw") String pwd,
                            HttpSession httpSession){
        log.info(id + pwd);
        MemberDto memberDto = null;
        try {
            model.addAttribute("location","/member/login");
            model.addAttribute("msg","ID가 틀립니다.");
            memberDto = memberService.getById(id);
            log.info(memberDto.toString());
            if(memberDto == null){
                throw new Exception();
            }
            if(!pwd.equals(memberDto.getMemberPw())){
                model.addAttribute("msg","PWD가 틀립니다.");
                throw new Exception();
            }
            httpSession.setAttribute("id", id);
        } catch (Exception e) {
            return "alert";
        }
        model.addAttribute("location","/");
        model.addAttribute("msg","로그인 되었습니다.");
        return "alert";
    }
    @RequestMapping("/logout")
    public String logout(Model model, HttpSession httpSession){
        if(httpSession != null){
            httpSession.invalidate();
        }
        model.addAttribute("location","/");
        model.addAttribute("msg","로그아웃 되었습니다.");
        return "alert";
    }

    @RequestMapping("/join2")
    public String join2(Model model){
        model.addAttribute("center",dir+"join2");
        return "index";
    }
    @RequestMapping("/join2impl")
    public String join2impl(Model model,
                           MemberDto memberDto){

        try {
            memberService.add(memberDto);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        model.addAttribute("location","/");
        model.addAttribute("msg","회원가입 되었습니다.");
        return "alert";
    }
    @ResponseBody
    @RequestMapping("/join2checkid")
    public Object join2checkid(@RequestParam("memberId") String id) throws Exception {
        String result = "0";
        MemberDto memberDto = memberService.getById(id);
        if(memberDto == null){
            result = "1";
        }
        return result;
    }

    @RequestMapping("/idFind")
    public String idFind(Model model){
        model.addAttribute("center",dir+"idFind");
        return "index";
    }
    @RequestMapping("/idFindimpl")
    public String idFindimpl(@RequestParam("memberName") String name,
                         @RequestParam("memberEmail") String email,
                         Model model){
        MemberDto memberDto = null;
        try {
            memberDto = memberService.findId(name, email);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        if(memberDto == null){
            model.addAttribute("center", dir + "idFind");
            model.addAttribute("msg", "조회되는 정보가 없습니다. 다시시도해주세요");
            return "index";
        }
        model.addAttribute("center", dir + "result");
        model.addAttribute("msg", "회원님의 아이디는");
        model.addAttribute("result", memberDto.getMemberId());
        return "index";
    }

    @RequestMapping("/passwordFind")
    public String passwordFind(Model model){
        model.addAttribute("center",dir+"passwordFind");
        return "index";
    }
    @RequestMapping("/passwordFindimpl")
    public String passwordFindimpl(Model model, @RequestParam("memberName") String name,
                                   @RequestParam("memberID") String id,
                                   @RequestParam("memberEmail") String email) throws Exception {
        MemberDto memberDto = memberService.findPw(name, id, email);
        if(memberDto == null){
            model.addAttribute("center", dir + "passwordFind");
            model.addAttribute("msg", "조회되는 정보가 없습니다. 다시시도해주세요");
            return "index";
        }
        model.addAttribute("center", dir + "result");
        model.addAttribute("msg", "회원님의 암호는");
        model.addAttribute("result", memberDto.getMemberPw());
        return "index";
    }
}
