package com.hana.app.repository;

import com.hana.app.data.entity.LoginCust;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LoginCustRepository extends CrudRepository<LoginCust,String> { // redis에 저장하기 위함
    // entity를 redis에 CRUD하려고 함
}