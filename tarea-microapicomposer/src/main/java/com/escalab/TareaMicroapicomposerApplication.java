package com.escalab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;

@EnableEurekaClient
@SpringBootApplication
@RibbonClients({@RibbonClient(name = "MICRO-PACIENTE"), @RibbonClient(name = "MICRO-NUTRICIONISTA")})
public class TareaMicroapicomposerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TareaMicroapicomposerApplication.class, args);
	}

}
