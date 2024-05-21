package com.hana.controller;

import com.hana.app.data.dto.AdminMemberDto;
import com.hana.app.data.dto.CommunityDto;
import com.hana.app.data.dto.MemberDto;
import com.hana.app.service.AdminMemberService;
import com.hana.app.service.CommunityService;
import com.hana.app.service.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
public class AdminMemberController {
    final AdminMemberService adminMemberService;
    final MemberService memberService;
    final CommunityService communityService;

    String dir = "admin/";

    @RequestMapping("/admin")
    public String main(Model model) throws Exception {
        model.addAttribute("center",dir + "admin_login");
        return "index";
    }

    @RequestMapping("/admin/loginimpl")
    public String loginimpl(Model model, AdminMemberDto dto, HttpSession httpSession){
        String id = dto.getMemberId();
        String pwd = dto.getMemberPw();
        AdminMemberDto adminMemberDto = null;
        log.info(id + pwd);
        try {
            model.addAttribute("location","/admin");
            model.addAttribute("msg","ID가 틀립니다.");
            adminMemberDto = adminMemberService.getById(id);
            log.info(adminMemberDto.toString());
            if(adminMemberDto == null){
                throw new Exception();
            }
            if(!pwd.equals(adminMemberDto.getMemberPw())){
                model.addAttribute("msg","PWD가 틀립니다.");
                throw new Exception();
            }
            httpSession.setAttribute("adminid", id);
        } catch (Exception e) {
            return "alert";
        }
        model.addAttribute("location","/admin_member");
        model.addAttribute("msg","로그인되었습니다.");
        return "alert";
    }

    @RequestMapping("/admin_member")
    public String admin_member(Model model) throws Exception {
        List<MemberDto> list = memberService.get();
        model.addAttribute("center",dir + "admin_member");
        model.addAttribute("list", list);
        return "index";
    }
    @RequestMapping("/admin_memberimpl")
    public String admin_member_impl(Model model, @RequestParam("keyword") String keyword,
                                   @RequestParam("select") String select) throws Exception {
        List<MemberDto> list = null;
        if(select.equals("all"))
            list = memberService.searchAll(keyword);
        if(select.equals("name"))
            list = memberService.searchName(keyword);
        if(select.equals("email"))
            list = memberService.searchEmail(keyword);
        if(select.equals("id"))
            list = memberService.searchId(keyword);

        model.addAttribute("center", dir + "admin_member");
        model.addAttribute("list", list);
        return "index";
    }
    @RequestMapping("/admin_member/order")
    @ResponseBody
    public Object admin_member_order(@RequestParam("order") String selectedOption) throws Exception {
        List<MemberDto> list = memberService.Ordering(selectedOption);
        return list;
    }


    @RequestMapping("/admin_notice")
    public String admin_notice(Model model) throws Exception {
        List<CommunityDto> list = communityService.get();
        model.addAttribute("center",dir + "admin_notice");
        model.addAttribute("list", list);
        return "index";
    }
    @RequestMapping("/admin_noticeimpl")
    public String admin_notice_impl(Model model, HttpSession session,
                             @RequestParam("keyword") String keyword, @RequestParam("select") String select) throws Exception {
        List<CommunityDto> list = communityService.searchAll(keyword);
        if(select.equals("all"))
            list = communityService.searchAll(keyword);
        if(select.equals("title"))
            list = communityService.searchTitle(keyword);
        if(select.equals("content"))
            list = communityService.searchContent(keyword);
        if(select.equals("id"))
            list = communityService.searchId(keyword);

        model.addAttribute("center", dir + "admin_notice");
        model.addAttribute("list", list);
        return "index";
    }
    @RequestMapping("/admin_notice/order")
    @ResponseBody
    public Object admin_notice_order(@RequestParam("order") String selectedOption) throws Exception {
        List<CommunityDto> list = communityService.Ordering(selectedOption);
        log.info(list.toString());
        return list;
    }

    @RequestMapping("/admin_notice_view")
    public String admin_notice_view(Model model, @RequestParam("idx") int id) throws Exception {
        CommunityDto communityDto = communityService.get(id);
        model.addAttribute("center",dir + "admin_notice_view");
        model.addAttribute("data", communityDto);
        return "index";
    }

    @RequestMapping("/admin_notice_write")
    public String admin_notice_write(Model model) throws Exception {
        model.addAttribute("center",dir + "admin_notice_write");
        return "index";
    }

    @RequestMapping("/admin_notice_modify")
    public String admin_notice_modify(CommunityDto communityDto) throws Exception {
        log.info(communityDto.toString());
        communityService.modify(communityDto);
        return "redirect:/admin_notice";
    }

    @RequestMapping("/admin_notice_delete")
    public Object admin_notice_delete(@RequestParam("idx") int idx) throws Exception {
        communityService.del(idx);
        return "redirect:/admin_notice";
    }

    @RequestMapping("/admin_notice/addimpl")
    public String admin_notice_add(CommunityDto communityDto, HttpSession httpSession) throws Exception {
        String id = (String) httpSession.getAttribute("adminid");
        communityDto.setNoticeMemberId(id);
        communityService.add(communityDto);
        return "redirect:/admin_notice";
    }
}