package com.escalab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

import com.escalab.config.ApplicationConfig;

@EnableDiscoveryClient
@SpringBootApplication
@EnableResourceServer
@RibbonClient(name = "MICRO-PACIENTE", configuration = {ApplicationConfig.class})
public class TareaMicronutricionistaApplication {

	public static void main(String[] args) {
		SpringApplication.run(TareaMicronutricionistaApplication.class, args);
	}

}
