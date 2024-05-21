package com.hana.app.data.dto;

import lombok.*;

import java.time.LocalDate;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberDto {
    private int memberIdx;
    private String memberId;
    private String memberPw;
    private String memberName;
    private String memberEmail;
    private int memberEmailReceive;
    private int memberPwQuestion;
    private String memberPwAnswer;
    private String memberGender;
    private LocalDate memberBirthDate;
    private LocalDate memberJoinDate;
}