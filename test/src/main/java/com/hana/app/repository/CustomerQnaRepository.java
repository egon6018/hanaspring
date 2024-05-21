package com.hana.app.repository;

import com.hana.app.data.dto.CustomerQnaDto;
import com.hana.app.data.dto.MemberDto;
import com.hana.app.frame.HanaRepository;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CustomerQnaRepository extends HanaRepository<Integer, CustomerQnaDto> {
    List<CustomerQnaDto> searchTitle(String key) throws Exception;
    List<CustomerQnaDto> searchContent(String key) throws Exception;
    CustomerQnaDto findQna(String pwd) throws Exception;
}