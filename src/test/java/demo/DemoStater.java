package demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ycj.reservation.mapper")
public class DemoStater {
    public static void main(String []args){
        SpringApplication.run(DemoStater.class,args);
    }
}
