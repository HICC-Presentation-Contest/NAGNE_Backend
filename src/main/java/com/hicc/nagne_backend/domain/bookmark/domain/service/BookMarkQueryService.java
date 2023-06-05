package com.hicc.nagne_backend.domain.bookmark.domain.service;

import com.hicc.nagne_backend.common.annotation.DomainService;
import com.hicc.nagne_backend.domain.bookmark.domain.entity.BookMark;
import com.hicc.nagne_backend.domain.bookmark.domain.repository.BookMarkRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@DomainService
@RequiredArgsConstructor
public class BookMarkQueryService {

    private final BookMarkRepository bookMarkRepository;

    public List<BookMark> findByUserId(Long userId){
        List<BookMark> bookMarkList = bookMarkRepository.findByUserId(userId);
        return bookMarkList;
    }
}
