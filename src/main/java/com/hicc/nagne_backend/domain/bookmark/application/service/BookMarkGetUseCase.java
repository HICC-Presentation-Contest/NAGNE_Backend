package com.hicc.nagne_backend.domain.bookmark.application.service;

import com.hicc.nagne_backend.common.annotation.UseCase;
import com.hicc.nagne_backend.common.slice.SliceResponse;
import com.hicc.nagne_backend.domain.bookmark.application.dto.response.BookMarkResponse;
import com.hicc.nagne_backend.domain.bookmark.application.mapper.BookMarkMapper;
import com.hicc.nagne_backend.domain.bookmark.domain.entity.BookMark;
import com.hicc.nagne_backend.domain.bookmark.domain.service.BookMarkQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@RequiredArgsConstructor
@Transactional
public class BookMarkGetUseCase {

    private final BookMarkQueryService bookMarkQueryService;
    public SliceResponse<BookMarkResponse.BookMarkInfoResponse> getBookMark(Long userId, Pageable pageable){
        Slice<BookMark> bookMarkList = bookMarkQueryService.findByUserId(userId, pageable);

        Slice<BookMarkResponse.BookMarkInfoResponse> bookMarkResponseList
                = bookMarkList.map(bookMark -> {
                    return BookMarkMapper.mapToBookMarkInfoResponse(bookMark);
                });
        return SliceResponse.of(bookMarkResponseList);
    }
}
