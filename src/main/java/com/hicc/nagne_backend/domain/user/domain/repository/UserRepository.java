package com.hicc.nagne_backend.domain.user.domain.repository;

import com.hicc.nagne_backend.domain.user.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
