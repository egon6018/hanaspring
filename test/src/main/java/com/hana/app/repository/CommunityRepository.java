package com.hana.app.repository;

import com.hana.app.data.dto.CommunityDto;
import com.hana.app.frame.HanaRepository;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CommunityRepository extends HanaRepository<Integer, CommunityDto> {
    List<CommunityDto> searchTitle(String key) throws Exception;
    List<CommunityDto> searchContent(String key) throws Exception;

    // 관리자 admin
    List<CommunityDto> searchId(String key) throws Exception;
    List<CommunityDto> searchAll(String key) throws Exception;
    public List<CommunityDto> selectedDateDesc() throws Exception;
    public List<CommunityDto> selectedDateAsc() throws Exception;
    public List<CommunityDto> selectedIdDesc() throws Exception;
    public List<CommunityDto> selectedIdAsc() throws Exception;
}
