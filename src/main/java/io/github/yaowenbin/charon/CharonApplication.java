package io.github.yaowenbin.charon;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication(exclude = {DruidDataSourceAutoConfigure.class})
@ConfigurationPropertiesScan
public class CharonApplication {

	public static void main(String[] args) {
		SpringApplication.run(CharonApplication.class, args);
	}

}
