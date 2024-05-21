package com.hana.app.data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerDto {
    private int one2oneIdx;
    private String one2oneName;
    private String one2onePhone;
    private String one2oneEmail;
    private String one2oneAddress;
    private String one2oneTitle;
    private String one2oneContent;
    private LocalDate one2oneDate;
}
