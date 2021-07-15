package com.springboot.OnlineAssessmentApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

import com.springboot.OnlineAssessmentApplication.OnlineAssessmentApplication;

@SpringBootApplication
@ComponentScan
public class OnlineAssessmentApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(OnlineAssessmentApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application)
	{
		setRegisterErrorPageFilter(false);
		
		return application.sources(OnlineAssessmentApplication.class);
	}
}
