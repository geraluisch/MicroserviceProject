package com.escalab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class TareaMicroconfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(TareaMicroconfigApplication.class, args);
	}

}
