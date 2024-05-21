package com.hana.app.service;

import com.hana.app.data.dto.MemberDto;
import com.hana.app.frame.HanaService;
import com.hana.app.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService implements HanaService<Integer, MemberDto> {

    final MemberRepository memberRepository;


    @Override
    public int add(MemberDto memberDto) throws Exception {
        return memberRepository.insert(memberDto);
    }

    @Override
    public int del(Integer integer) throws Exception {
        return memberRepository.delete(integer);
    }

    @Override
    public int modify(MemberDto memberDto) throws Exception {
        return memberRepository.update(memberDto);
    }

    @Override
    public MemberDto get(Integer integer) throws Exception {
        return memberRepository.selectOne(integer);
    }

    public MemberDto getById(String string) throws Exception {
        return memberRepository.selectOneId(string);
    }

    @Override
    public List<MemberDto> get() throws Exception {
        return memberRepository.select();
    }

    public MemberDto findId(String name, String email) throws Exception {
        return memberRepository.findId(name, email);
    }
    public MemberDto findPw(String name, String id, String email) throws Exception {
        return memberRepository.findPw(name, id, email);
    }

    // 관리자 admin
    public List<MemberDto> Ordering(String option) throws Exception {
        switch (option){
            case "id_asc":
                return memberRepository.selectedIdAsc();
            case "id_desc":
                return memberRepository.selectedIdDesc();
            case "joindate_asc":
                return memberRepository.selectedDateAsc();
            case "joindate_desc":
                return memberRepository.selectedDateDesc();
        }
        return memberRepository.select();
    }

    public List<MemberDto> searchAll(String keyword) throws Exception {
        return memberRepository.searchAll(keyword);
    }
    public List<MemberDto> searchEmail(String keyword) throws Exception {
        return memberRepository.searchEmail(keyword);
    }
    public List<MemberDto> searchName(String keyword) throws Exception {
        return memberRepository.searchName(keyword);
    }
    public List<MemberDto> searchId(String keyword) throws Exception {
        return memberRepository.searchId(keyword);
    }
}