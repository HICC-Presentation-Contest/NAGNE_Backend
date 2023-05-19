package com.hicc.nagne_backend.domain.follow.domain.repository;

import com.hicc.nagne_backend.domain.follow.domain.entity.Follow;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FollowRepository extends JpaRepository<Follow, Long> {
    List<Follow> findByReceiverId(Long receiverId);
}
