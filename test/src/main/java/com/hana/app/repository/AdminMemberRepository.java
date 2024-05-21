package com.hana.app.repository;

import com.hana.app.data.dto.AdminMemberDto;
import com.hana.app.frame.HanaRepository;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface AdminMemberRepository extends HanaRepository<Integer, AdminMemberDto> {
    public AdminMemberDto selectById(String id) throws Exception;
}