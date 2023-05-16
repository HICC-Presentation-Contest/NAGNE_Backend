package com.hicc.nagne_backend.domain.user.domain;

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
