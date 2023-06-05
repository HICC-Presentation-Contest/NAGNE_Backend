package com.hicc.nagne_backend.domain.bookmark.application.service;

import com.hicc.nagne_backend.common.annotation.UseCase;
import com.hicc.nagne_backend.domain.bookmark.application.dto.request.BookMarkRequest;
import com.hicc.nagne_backend.domain.bookmark.domain.service.BookMarkSaveService;
import com.hicc.nagne_backend.domain.trip.domain.entity.Trip;
import com.hicc.nagne_backend.domain.trip.domain.service.TripQueryService;
import com.hicc.nagne_backend.domain.user.domain.entity.User;
import com.hicc.nagne_backend.domain.user.domain.service.UserQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@RequiredArgsConstructor
@Transactional
public class BookMarkCreateUseCase {

    private final UserQueryService userQueryService;
    private final TripQueryService tripQueryService;
    private final BookMarkSaveService bookMarkSaveService;

    public void createBookMark(BookMarkRequest.BookMarkCreateRequest bookMarkCreateRequest){
        User user = userQueryService.findById(bookMarkCreateRequest.getUserId());
        Trip trip = tripQueryService.findById(bookMarkCreateRequest.getTripId());

        bookMarkSaveService.save(user, trip);
    }
}
