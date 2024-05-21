package com.hana.app.data.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.time.LocalDateTime;

@RedisHash(value = "logincust", timeToLive = 600) // value="logincust": 레디스 내부 식별값
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class LoginCust {
    @Id // primary key값
    private String loginId;

}