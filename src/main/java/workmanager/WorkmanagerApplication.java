package workmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("workmanager.dao")//tkmybatis的注解
public class WorkmanagerApplication {
    public static void main(String[] args) {
        SpringApplication.run(WorkmanagerApplication.class, args);
    }
}
