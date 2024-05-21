package com.hana.app.data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommunityDto {
    private int noticeIdx;
    private String noticeTitle;
    private String noticeContent;
    private String noticeMemberId;
    private LocalDate noticeDate;
}





