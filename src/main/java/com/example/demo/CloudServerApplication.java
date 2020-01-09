package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SpringBootApplication
@EnableEurekaServer//将当前项目标记为eureka项目
public class CloudServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudServerApplication.class, args);
	}
	
	@EnableWebSecurity
	public static class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
protected void configure(HttpSecurity http) throws Exception {
	http.csrf().disable().authorizeRequests().anyRequest()
    .authenticated()
    .and()
    .httpBasic();


}
}
	}
