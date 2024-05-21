package com.hana.controller;

import com.hana.app.data.dto.CommunityDto;
import com.hana.app.service.CommunityService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/community")
@RequiredArgsConstructor
public class CommunityController {
    String dir= "community/";

    final CommunityService communityService;

    @RequestMapping("/")
    public String main(Model model){
        return "index";
    }

    @RequestMapping("/community01")
    public String community01(Model model){
        List<CommunityDto> list = new ArrayList<>();
        try {
            list = communityService.get();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        model.addAttribute("noticelist",list);
        model.addAttribute("center",dir+"community01");

        return "index";
    }

    @RequestMapping("/community01_1")
    public String community01_1(Model model,@RequestParam("idx") int idx){
        // Database에서 데이터를 가지고 온다.
        CommunityDto communityDto = null;
        try {
            communityDto = communityService.get(idx);
            model.addAttribute("noticeidx", communityDto);
            model.addAttribute("center",dir+"community01_1");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "index";
    }

    @RequestMapping("/communityOneSearch")
    public String communityOneSearch(Model model, HttpSession session,
                                     @RequestParam("keyword") String keyword,
                                     @RequestParam("select") String select) throws Exception {
        List<CommunityDto> list = communityService.search(keyword, select);
        model.addAttribute("noticelist",list);
        model.addAttribute("center",dir+"community01");

        return "index";
    }

}
