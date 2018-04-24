package personal.diarydemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("personal.mapper")
public class DiaryDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DiaryDemoApplication.class, args);
    }
}
