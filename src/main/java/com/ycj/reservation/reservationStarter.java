package com.ycj.reservation;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ycj.reservation.mapper")
public class reservationStarter {
    /*
    * @Description 项目启动器
    * */
    public static void main(String[] args){
        SpringApplication.run(reservationStarter.class);
    }
}
