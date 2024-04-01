package com.hana;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class Sb2ThApplication {

    public static void main(String[] args) {
        SpringApplication.run(Sb2ThApplication.class, args);
    }

    @Test
    public void contextLoads(){
        log.info("---OK---");
    }

}
