package com.hicc.nagne_backend.domain.bookmark.domain.service;

import com.hicc.nagne_backend.common.annotation.DomainService;
import com.hicc.nagne_backend.domain.bookmark.domain.repository.BookMarkRepository;
import lombok.RequiredArgsConstructor;

@DomainService
@RequiredArgsConstructor
public class BookMarkDeleteService {

    private final BookMarkRepository bookMarkRepository;

    public void deleteBookMark(Long userId, Long tripId){
        bookMarkRepository.deleteByUserIdAndTripId(userId, tripId);
    }

}
