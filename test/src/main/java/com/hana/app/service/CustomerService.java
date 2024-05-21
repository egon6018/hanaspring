package com.hana.app.service;

import com.hana.app.data.dto.CommunityDto;
import com.hana.app.data.dto.CustomerDto;
import com.hana.app.frame.HanaService;
import com.hana.app.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService implements HanaService<Integer, CustomerDto> {
    final CustomerRepository customerRepository;

    @Override
    public int add(CustomerDto customerDto) throws Exception {
        return customerRepository.insert(customerDto);
    }

    @Override
    public int del(Integer integer) throws Exception {
        return customerRepository.delete(integer);
    }

    @Override
    public int modify(CustomerDto customerDto) throws Exception {
        return customerRepository.update(customerDto);
    }

    @Override
    public CustomerDto get(Integer integer) throws Exception {
        return customerRepository.selectOne(integer);
    }

    @Override
    public List<CustomerDto> get() throws Exception {
        return customerRepository.select();
    }

    public List<CustomerDto> search(String key, String select) throws Exception {
        switch (select){
            case "title" :
                return customerRepository.searchTitle(key);
            case "content":
                return customerRepository.searchContent(key);
            default:
                return null;
        }
    }
}