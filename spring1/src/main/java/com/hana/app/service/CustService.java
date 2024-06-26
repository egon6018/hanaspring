package com.hana.app.service;

import com.hana.app.data.CustDto;
import com.hana.app.data.CustDto;
import com.hana.app.exception.DuplicatedIdException;
import com.hana.app.exception.NotFoundIdException;
import com.hana.app.frame.ConnectionPool;
import com.hana.app.frame.Service;
import com.hana.app.repository.CustRepository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

//@RequiredArgsConstructor // lombok이 객체를 만들어줌
public class CustService implements Service<String, CustDto> {

    CustRepository repository;
    ConnectionPool cp;

    public CustService(){
        repository = new CustRepository();
        try {
            cp = ConnectionPool.create();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public CustDto add(CustDto custDto) throws DuplicatedIdException, Exception {
        Connection con = cp.getConnection();
        try {
            con.setAutoCommit(false);
            repository.insert(custDto, con);
            repository.insert(custDto, con);
            con.commit();
        }catch(Exception e){
            con.rollback();
            throw e;
        }finally {
            cp.releaseConnection(con);
        }
        return null;
    }

    @Override
    public CustDto modify(CustDto custDto) throws NotFoundIdException, Exception {
        return null;
    }

    @Override
    public Boolean remove(String s) throws NotFoundIdException, Exception {
        return null;
    }

    @Override
    public List<CustDto> get() throws Exception {
        return null;
    }

    @Override
    public CustDto get(String s) throws NotFoundIdException, Exception {
        return null;
    }
}