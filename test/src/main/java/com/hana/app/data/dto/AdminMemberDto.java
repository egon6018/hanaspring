package com.hana.app.data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdminMemberDto {
    private int memberIdx;
    private String memberId;
    private String memberPw;
    private String memberName;
    private String memberEmail;
    private LocalDate memberJoinDate;
}