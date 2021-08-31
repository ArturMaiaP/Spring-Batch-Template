package com.template.SpringBatchTemplate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class SpringBatchTemplateApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBatchTemplateApplication.class, args);
	}

}
