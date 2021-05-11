package kr.co.sboard2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("kr.co.sboard2.dao")
public class Sboard2Application {

	public static void main(String[] args) {
		SpringApplication.run(Sboard2Application.class, args);
	}

}
