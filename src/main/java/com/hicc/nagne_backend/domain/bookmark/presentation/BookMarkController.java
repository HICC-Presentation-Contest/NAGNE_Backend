package com.hicc.nagne_backend.domain.bookmark.presentation;

import com.hicc.nagne_backend.domain.bookmark.application.dto.request.BookMarkRequest;
import com.hicc.nagne_backend.domain.bookmark.application.dto.response.BookMarkResponse;
import com.hicc.nagne_backend.domain.bookmark.application.service.BookMarkCreateUseCase;
import com.hicc.nagne_backend.domain.bookmark.application.service.BookMarkGetUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BookMarkController {

    private final BookMarkGetUseCase bookMarkGetUseCase;
    private final BookMarkCreateUseCase bookMarkCreateUseCase;

    @GetMapping("/bookmark/{userId}")
    public List<BookMarkResponse.BookMarkInfoResponse> getBookMark(@PathVariable Long userId){
        return bookMarkGetUseCase.getBookMark(userId);
    }

    @PostMapping("/bookmark")
    public void createBookMark(@RequestBody BookMarkRequest.BookMarkCreateRequest bookMarkCreateRequest){
        bookMarkCreateUseCase.createBookMark(bookMarkCreateRequest);
    }
}
