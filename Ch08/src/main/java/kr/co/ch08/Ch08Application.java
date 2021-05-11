package kr.co.ch08;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("kr.co.ch08.dao")
public class Ch08Application {

	public static void main(String[] args) {
		SpringApplication.run(Ch08Application.class, args);
	}

}
