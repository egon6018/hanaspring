package com.hana.app.repository;

//import com.github.pagehelper.Page;

import com.hana.app.data.dto.MemberDto;
import com.hana.app.frame.HanaRepository;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface MemberRepository extends HanaRepository<Integer, MemberDto> {
    MemberDto selectOneId(String id);
    MemberDto findId(String name, String email) throws Exception;
    MemberDto findPw(String name, String id, String email) throws Exception;

    // 관리자 admin
    public List<MemberDto> selectedDateDesc() throws Exception;
    public List<MemberDto> selectedDateAsc() throws Exception;
    public List<MemberDto> selectedIdDesc() throws Exception;
    public List<MemberDto> selectedIdAsc() throws Exception;

    public List<MemberDto> searchAll(String keyword) throws Exception;
    public List<MemberDto> searchEmail(String keyword) throws Exception;
    public List<MemberDto> searchName(String keyword) throws Exception;
    public List<MemberDto> searchId(String keyword) throws Exception;
}