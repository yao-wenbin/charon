package io.github.yaowenbin.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
@MapperScan("io.github.yaowenbin.server")
public class CharonApplication {

	public static void main(String[] args) {
		SpringApplication.run(CharonApplication.class, args);
	}

}
