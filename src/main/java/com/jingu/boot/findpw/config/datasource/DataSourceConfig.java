package com.jingu.boot.findpw.config.datasource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.jingu.boot.findpw.*"})
@EntityScan(basePackages = {"com.jingu.boot.findpw.*"})
@MapperScan(basePackages = {"com.jingu.boot.findpw.**.dao"})
public class DataSourceConfig {
	
}
