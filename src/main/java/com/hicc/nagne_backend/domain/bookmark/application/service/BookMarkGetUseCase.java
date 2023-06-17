package com.hicc.nagne_backend.domain.bookmark.application.service;

import com.hicc.nagne_backend.common.annotation.UseCase;
import com.hicc.nagne_backend.domain.bookmark.application.dto.response.BookMarkResponse;
import com.hicc.nagne_backend.domain.bookmark.application.mapper.BookMarkMapper;
import com.hicc.nagne_backend.domain.bookmark.domain.entity.BookMark;
import com.hicc.nagne_backend.domain.bookmark.domain.service.BookMarkQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@UseCase
@RequiredArgsConstructor
@Transactional
public class BookMarkGetUseCase {

    private final BookMarkQueryService bookMarkQueryService;
    public List<BookMarkResponse.BookMarkInfoResponse> getBookMark(Long userId){
        List<BookMark> bookMarkList = bookMarkQueryService.findByUserId(userId);
        return BookMarkMapper.mapToBookMarkList(bookMarkList);
    }
}
