package com.hana.app.repository;

import com.hana.app.data.dto.CommunityDto;
import com.hana.app.data.dto.MemberDto;
import com.hana.app.data.dto.CustomerDto;
import com.hana.app.frame.HanaRepository;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CustomerRepository extends HanaRepository<Integer, CustomerDto> {
    public List<CustomerDto> searchTitle(String key) throws Exception;
    public List<CustomerDto> searchContent(String key) throws Exception;
}