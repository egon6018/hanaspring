package com.hana.app.service;

import com.hana.app.data.dto.CommunityDto;
import com.hana.app.frame.HanaService;
import com.hana.app.repository.CommunityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommunityService implements HanaService<Integer, CommunityDto> {

    final CommunityRepository communityRepository;

    @Override
    public int add(CommunityDto communityDto) throws SQLException, FileNotFoundException, Exception {
        int result = 0;
        result= communityRepository.insert(communityDto);

        return result;
    }

    @Override
    public int del(Integer s) throws SQLException,FileNotFoundException,Exception {
        CommunityDto communityDto = communityRepository.selectOne(s);

        return communityRepository.delete(s);
    }

    @Override
    public int modify(CommunityDto communityDto) throws SQLException,FileNotFoundException,Exception {
        int result = 0;
        result = communityRepository.update(communityDto);

        return result;
    }

    @Override
    public CommunityDto get(Integer s) throws SQLException,Exception {
        return communityRepository.selectOne(s);
    }

    @Override
    public List<CommunityDto> get() throws SQLException,Exception {
        return communityRepository.select();
    }

    public List<CommunityDto> search(String key, String select) throws Exception {
        switch (select){
            case "title" :
                return communityRepository.searchTitle(key);
            case "content":
                return communityRepository.searchContent(key);
            default:
                return null;
        }
    }


    // 관리자 admin
    public List<CommunityDto> Ordering(String option) throws Exception {
        switch (option){
            case "id_asc":
                return communityRepository.selectedIdAsc();
            case "id_desc":
                return communityRepository.selectedIdDesc();
            case "regdate_asc":
                return communityRepository.selectedDateAsc();
            case "regdate_desc":
                return communityRepository.selectedDateDesc();
        }
        return communityRepository.select();
    }

    public List<CommunityDto> searchAll(String keyword) throws Exception {
        return communityRepository.searchAll(keyword);
    }
    public List<CommunityDto> searchTitle(String keyword) throws Exception {
        return communityRepository.searchTitle(keyword);
    }
    public List<CommunityDto> searchContent(String keyword) throws Exception {
        return communityRepository.searchContent(keyword);
    }
    public List<CommunityDto> searchId(String keyword) throws Exception {
        return communityRepository.searchId(keyword);
    }
}
