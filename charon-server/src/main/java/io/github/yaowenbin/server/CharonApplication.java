package io.github.yaowenbin.server;

import io.github.yaowenbin.server.autoconfiguration.DataSourceAutoConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@ConfigurationPropertiesScan
@MapperScan("io.github.yaowenbin.server")
@Import(DataSourceAutoConfiguration.class)
@ComponentScan("io.github.yaowenbin")
public class CharonApplication {

	public static void main(String[] args) {
		SpringApplication.run(CharonApplication.class, args);
	}

}
