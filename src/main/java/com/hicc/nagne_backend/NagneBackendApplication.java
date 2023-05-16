package com.hicc.nagne_backend;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.hicc.nagne_backend.domain.trip.domain.entity.Trip;
import com.hicc.nagne_backend.domain.trip.domain.repository.TripRepository;
import com.hicc.nagne_backend.domain.user.domain.User;
import com.hicc.nagne_backend.domain.user.domain.UserRepository;
import com.hicc.nagne_backend.domain.user.domain.UserSaveService;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@EnableJpaAuditing
public class NagneBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(NagneBackendApplication.class, args);
	}

}
