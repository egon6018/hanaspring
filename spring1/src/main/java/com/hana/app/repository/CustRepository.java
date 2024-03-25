package com.hana.app.repository;

import com.hana.app.data.CustDto;
import com.hana.app.exception.DuplicatedIdException;
import com.hana.app.exception.NotFoundIdException;
import com.hana.app.frame.Repository;
import com.hana.app.frame.SQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

public class CustRepository implements Repository<String, CustDto> {


    @Override
    public CustDto insert(CustDto custDto, Connection con) throws DuplicatedIdException, Exception {
        // 1. Driver Loading
        // 2. Connection
        // 1,2번은 ConnectionPool이 대신 해줄꺼임
        // 3. SQL
        // SQL.java파일에서 이미 만듦

        // 4. PreparedStatement
        PreparedStatement pstmt = null;

        try{
            pstmt = con.prepareStatement(SQL.insertCust);
            pstmt.setString(1,custDto.getId());
            pstmt.setString(2,custDto.getPwd());
            pstmt.setString(3,custDto.getName());
            pstmt.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e){
            throw new DuplicatedIdException("Err0001");
        } catch (SQLException e){
            throw new Exception("EXX0001");
        } finally {
            // 5. close
            if(pstmt != null){
                try{
                    pstmt.close();
                } catch(SQLException e){
                    throw new RuntimeException(e);
                }
            }
        }

        return custDto;
//        PreparedStatement pstmt = con.prepareStatement(SQL.insertCust);
//        pstmt.setString(1,custDto.getId());
//        pstmt.setString(2,custDto.getPwd());
//        pstmt.setString(3,custDto.getName());
//        pstmt.executeUpdate();

        // 5. Close
//        if(pstmt != null){
//            try{
//                pstmt.close();
//            } catch(SQLException e){
//                throw new RuntimeException(e);
//            }
//        }
//
//        cp.releaseConnection(con);
    }

    @Override
    public CustDto update(CustDto custDto, Connection con) throws DuplicatedIdException, Exception {
        return null;
    }

    @Override
    public Boolean delete(String s, Connection con) throws NotFoundIdException, Exception {
        return null;
    }

    @Override
    public List<CustDto> select(Connection con) throws Exception {
        return null;
    }

    @Override
    public CustDto select(String s, Connection con) throws NotFoundIdException, Exception {
        return null;
    }
}
