package com.escalab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@EnableEurekaClient
@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class TareaMicrosecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(TareaMicrosecurityApplication.class, args);
	}

}
