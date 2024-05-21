package com.hana.app.service;

import com.hana.app.data.dto.CustomerDto;
import com.hana.app.data.dto.CustomerQnaDto;
import com.hana.app.data.dto.MemberDto;
import com.hana.app.frame.HanaService;
import com.hana.app.repository.CustomerQnaRepository;
import com.hana.app.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerQnaService implements HanaService<Integer, CustomerQnaDto> {
    final CustomerQnaRepository customerQnaRepository;

    @Override
    public int add(CustomerQnaDto customerQnaDto) throws Exception {
        return customerQnaRepository.insert(customerQnaDto);
    }

    @Override
    public int del(Integer integer) throws Exception {
        return customerQnaRepository.delete(integer);
    }

    @Override
    public int modify(CustomerQnaDto customerQnaDto) throws Exception {
        return customerQnaRepository.update(customerQnaDto);
    }

    @Override
    public CustomerQnaDto get(Integer integer) throws Exception {
        return customerQnaRepository.selectOne(integer);
    }

    @Override
    public List<CustomerQnaDto> get() throws Exception {
        return customerQnaRepository.select();
    }

    public List<CustomerQnaDto> search(String key, String select) throws Exception {
        switch (select){
            case "title" :
                return customerQnaRepository.searchTitle(key);
            case "content":
                return customerQnaRepository.searchContent(key);
            default:
                return null;
        }
    }

    public CustomerQnaDto findQna(String pwd) throws Exception {
        return customerQnaRepository.findQna(pwd);
    }
}