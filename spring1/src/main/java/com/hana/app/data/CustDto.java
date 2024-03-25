package com.hana.app.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustDto {
    private String id;
    private String pwd;
    private String name;
    // db에서는 대소문자 구분안해서 cust_name이라고 하고, 자바에서는 custName이라고 해도 알아서 맞춰주는 라이브러리가 있긴 함
}
