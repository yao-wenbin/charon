package io.github.yaowenbin.charon;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication(exclude = {DruidDataSourceAutoConfigure.class})
@ConfigurationPropertiesScan
@MapperScan("io.github.yaowenbin.charon")
public class CharonApplication {

	public static void main(String[] args) {
		SpringApplication.run(CharonApplication.class, args);
	}

}
