package io.github.yaowenbin.server;

import io.github.yaowenbin.server.autoconfiguration.DataSourceAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import java.util.Arrays;
import java.util.Optional;

@SpringBootApplication
@ConfigurationPropertiesScan
@Import(DataSourceAutoConfiguration.class)
@ComponentScan("io.github.yaowenbin")
public class CharonApplication {

	public static void main(String[] args) {
		checkForArgs(args);
		SpringApplication.run(CharonApplication.class, args);
	}

	static void checkForArgs(String... args) {
		Arrays.stream(args).filter(s -> s.contains("--spring.config.additional-location")).findAny()
				.orElseThrow(() -> new RuntimeException("please set a configuration file before start."));
	}

}
