package com.hicc.nagne_backend.domain.bookmark.presentation;

import com.hicc.nagne_backend.common.slice.SliceResponse;
import com.hicc.nagne_backend.domain.bookmark.application.dto.request.BookMarkRequest;
import com.hicc.nagne_backend.domain.bookmark.application.dto.response.BookMarkResponse;
import com.hicc.nagne_backend.domain.bookmark.application.service.BookMarkCreateUseCase;
import com.hicc.nagne_backend.domain.bookmark.application.service.BookMarkGetUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class BookMarkController {

    private final BookMarkGetUseCase bookMarkGetUseCase;
    private final BookMarkCreateUseCase bookMarkCreateUseCase;

    @GetMapping("/bookmark/{userId}")
    public SliceResponse<BookMarkResponse.BookMarkInfoResponse> getBookMark(@PathVariable Long userId, Pageable pageable){
        return bookMarkGetUseCase.getBookMark(userId, pageable);
    }

    @PostMapping("/bookmark")
    public void createBookMark(@RequestBody BookMarkRequest.BookMarkCreateRequest bookMarkCreateRequest){
        bookMarkCreateUseCase.createBookMark(bookMarkCreateRequest);
    }
}
