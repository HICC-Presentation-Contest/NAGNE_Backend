package com.hicc.nagne_backend;

import com.hicc.nagne_backend.common.security.jwt.JwtProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@EnableConfigurationProperties(JwtProperties.class)
public class NagneBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(NagneBackendApplication.class, args);
	}

}
