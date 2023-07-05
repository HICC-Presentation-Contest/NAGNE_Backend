package com.hicc.nagne_backend.domain.follow.domain.repository;

import com.hicc.nagne_backend.domain.follow.domain.entity.Follow;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FollowRepository extends JpaRepository<Follow, Long> {
    Slice<Follow> findByReceiverId(Long receiverId, Pageable pageable);
    Slice<Follow> findBySenderId(Long senderId, Pageable pageable);

    Long countBySenderId(Long senderId);
    Long countByReceiverId(Long receiverId);

    boolean existsBySenderIdAndReceiverId(Long senderId, Long receiverId);
    void deleteBySenderIdAndReceiverId(Long senderId, Long receiverId);

}
