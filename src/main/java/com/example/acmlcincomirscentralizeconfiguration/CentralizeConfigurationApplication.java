package com.example.acmlcincomirscentralizeconfiguration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication(exclude = {
		RedisAutoConfiguration.class
})
public class CentralizeConfigurationApplication {

	public static void main(String[] args) {
		SpringApplication.run(CentralizeConfigurationApplication.class, args);
	}

}
