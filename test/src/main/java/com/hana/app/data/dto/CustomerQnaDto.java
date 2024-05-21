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
public class CustomerQnaDto {
    private int qnaIdx;
    private String qnaName;
    private String qnaPw;
    private String qnaTitle;
    private String qnaContent;
    private LocalDate qnaDate;
}
