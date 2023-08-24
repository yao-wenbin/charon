package io.github.yaowenbin.charon;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
@MapperScan("io.github.yaowenbin.charon")
public class CharonApplication {

	public static void main(String[] args) {
		SpringApplication.run(CharonApplication.class, args);
	}

}
