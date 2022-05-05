package com.jingu.boot;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@EnableAutoConfiguration
@SpringBootApplication
public class JinguApplication {

    @PostConstruct
    void started() {
    	TimeZone.setDefault(TimeZone.getTimeZone("Asia/Seoul"));
    }
    
    public static void main(String[] args) {
        SpringApplication.run(JinguApplication.class, args);
    }
    
    //@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(JinguApplication.class);
	}

}
