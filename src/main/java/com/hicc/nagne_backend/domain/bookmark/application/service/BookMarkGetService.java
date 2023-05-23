package com.hicc.nagne_backend.domain.bookmark.application.service;

import com.hicc.nagne_backend.domain.bookmark.application.dto.response.BookMarkResponse;
import com.hicc.nagne_backend.domain.bookmark.application.mapper.BookMarkMapper;
import com.hicc.nagne_backend.domain.bookmark.domain.entity.BookMark;
import com.hicc.nagne_backend.domain.bookmark.domain.service.BookMarkQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookMarkGetService {

    private final BookMarkQueryService bookMarkQueryService;
    public List<BookMarkResponse.BookMarkInfoResponse> getBookMark(Long userId){
        List<BookMark> bookMarkList = bookMarkQueryService.findByUserId(userId);
        return BookMarkMapper.mapToBookMarkList(bookMarkList);
    }
}
