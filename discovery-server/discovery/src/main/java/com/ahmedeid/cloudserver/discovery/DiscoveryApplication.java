package com.ahmedeid.cloudserver.discovery;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DiscoveryApplication {

	@Value("${port}")
	private static String port;

	public static void main(String[] args) {

		SpringApplication.run(DiscoveryApplication.class, args);
	}

}
