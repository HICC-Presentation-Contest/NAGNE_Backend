package com.hicc.nagne_backend.domain.user.domain.service;

import com.hicc.nagne_backend.domain.user.domain.entity.User;
import com.hicc.nagne_backend.domain.user.domain.repository.UserRepository;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserSaveService {

	private final UserRepository userRepository;

	public void save(User user) {
		userRepository.save(user);
	}

}