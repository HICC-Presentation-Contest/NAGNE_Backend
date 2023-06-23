package com.hicc.nagne_backend.domain.bookmark.domain.service;

import com.hicc.nagne_backend.common.annotation.DomainService;
import com.hicc.nagne_backend.domain.bookmark.domain.entity.BookMark;
import com.hicc.nagne_backend.domain.bookmark.domain.repository.BookMarkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.transaction.annotation.Transactional;

@DomainService
@RequiredArgsConstructor
@Transactional
public class BookMarkQueryService {

    private final BookMarkRepository bookMarkRepository;

    public Slice<BookMark> findByUserId(Long userId,  Pageable pageable){
        Slice<BookMark> bookMarkList = bookMarkRepository.findByUserId(userId, pageable);
        return bookMarkList;
    }

    public boolean existsByUserIdAndTripId(Long userId, Long tripId){
        return bookMarkRepository.existsByUserIdAndTripId(userId, tripId);
    }

    public Long countByTripId(Long tripId){
        return bookMarkRepository.countByTripId(tripId);
    }
}
