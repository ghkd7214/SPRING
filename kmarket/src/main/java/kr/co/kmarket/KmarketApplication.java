package kr.co.kmarket;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("kr.co.kmarket.dao")
public class KmarketApplication {

	public static void main(String[] args) {
		SpringApplication.run(KmarketApplication.class, args);
	}

}
