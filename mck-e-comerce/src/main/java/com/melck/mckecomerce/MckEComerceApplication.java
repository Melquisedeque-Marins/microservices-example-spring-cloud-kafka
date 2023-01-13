package com.melck.mckecomerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MckEComerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MckEComerceApplication.class, args);
	}

}
