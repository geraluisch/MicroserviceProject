package com.escalab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@EnableDiscoveryClient
@SpringBootApplication
@EnableResourceServer
public class TareaMicropacienteApplication {

	public static void main(String[] args) {
		SpringApplication.run(TareaMicropacienteApplication.class, args);
	}

}
