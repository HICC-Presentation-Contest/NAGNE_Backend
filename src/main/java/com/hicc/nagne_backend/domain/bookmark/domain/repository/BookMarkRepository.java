package com.hicc.nagne_backend.domain.bookmark.domain.repository;

import com.hicc.nagne_backend.domain.bookmark.domain.entity.BookMark;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookMarkRepository extends JpaRepository<BookMark, Long> {

    Slice<BookMark> findByUserId(Long userId, Pageable pageable);

    boolean existsByUserIdAndTripId(Long userId, Long tripId);

    void deleteByUserIdAndTripId(Long userId, Long tripId);

    Long countByTripId(Long tripId);
}
