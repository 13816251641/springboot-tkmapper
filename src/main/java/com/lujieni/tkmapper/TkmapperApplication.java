package com.lujieni.tkmapper;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
/*扫描mapper接口,mybatis和tkmapper都需要*/
@MapperScan("com.**.dao")
public class TkmapperApplication {

    public static void main(String[] args) {
        SpringApplication.run(TkmapperApplication.class, args);
    }

}
