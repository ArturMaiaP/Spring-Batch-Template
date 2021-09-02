package com.template.springbatchtemplate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@ComponentScan(basePackages = {"com.template.springbatchtemplate.job", "com.template.springbatchtemplate.tasks",
				"com.template.springbatchtemplate.domain", "com.template.springbatchtemplate.service",
				"com.template.springbatchtemplate.repository", "com.template.springbatchtemplate.shared"})
public class SpringBatchTemplateApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBatchTemplateApplication.class, args);
	}

}
