package com.hicc.nagne_backend.domain.bookmark.application.service;

import com.hicc.nagne_backend.common.annotation.UseCase;
import com.hicc.nagne_backend.domain.bookmark.domain.service.BookMarkQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@RequiredArgsConstructor
@Transactional
public class BookMarkCountGetUseCase {

    private final BookMarkQueryService bookMarkQueryService;

    public Long getBookMarkCount(Long tripId){
        return bookMarkQueryService.countByTripId(tripId);
    }
}
