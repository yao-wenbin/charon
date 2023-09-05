package io.github.yaowenbin.server;

import io.github.yaowenbin.server.autoconfiguration.DataSourceAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@ConfigurationPropertiesScan
@Import(DataSourceAutoConfiguration.class)
@ComponentScan("io.github.yaowenbin")
public class CharonApplication {

	public static void main(String[] args) {
		SpringApplication.run(CharonApplication.class, args);
	}

}
