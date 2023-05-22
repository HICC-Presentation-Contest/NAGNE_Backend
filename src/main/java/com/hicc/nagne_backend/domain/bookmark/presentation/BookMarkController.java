package com.hicc.nagne_backend.domain.bookmark.presentation;

import com.hicc.nagne_backend.domain.bookmark.application.dto.request.BookMarkRequest;
import com.hicc.nagne_backend.domain.bookmark.application.dto.response.BookMarkResponse;
import com.hicc.nagne_backend.domain.bookmark.application.service.BookMarkCreateService;
import com.hicc.nagne_backend.domain.bookmark.application.service.BookMarkGetService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BookMarkController {

    private final BookMarkGetService bookMarkGetService;
    private final BookMarkCreateService bookMarkCreateService;

    @GetMapping("/bookmark/{userId}")
    public List<BookMarkResponse.BookMarkInfoResponse> getBookMark(@PathVariable Long userId){
        return bookMarkGetService.getBookMark(userId);
    }

    @PostMapping("/bookmark")
    public void createBookMark(@RequestBody BookMarkRequest.BookMarkCreateRequest bookMarkCreateRequest){
        bookMarkCreateService.createBookMark(bookMarkCreateRequest);
    }
}
