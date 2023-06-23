package com.hicc.nagne_backend.domain.bookmark.application.service;

import com.hicc.nagne_backend.common.annotation.UseCase;
import com.hicc.nagne_backend.common.util.UserUtils;
import com.hicc.nagne_backend.domain.bookmark.domain.service.BookMarkDeleteService;
import com.hicc.nagne_backend.domain.bookmark.domain.service.BookMarkQueryService;
import com.hicc.nagne_backend.domain.bookmark.domain.service.BookMarkSaveService;
import com.hicc.nagne_backend.domain.trip.domain.entity.Trip;
import com.hicc.nagne_backend.domain.trip.domain.service.TripQueryService;
import com.hicc.nagne_backend.domain.user.domain.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@RequiredArgsConstructor
@Transactional
public class BookMarkCreateUseCase {

    private final UserUtils userUtils;
    private final TripQueryService tripQueryService;
    private final BookMarkSaveService bookMarkSaveService;
    private final BookMarkQueryService bookMarkQueryService;
    private final BookMarkDeleteService bookMarkDeleteService;

    public void createBookMark(Long tripId){
        User user = userUtils.getUser();
        if(bookMarkQueryService.existsByUserIdAndTripId(user.getId(), tripId)){
            bookMarkDeleteService.deleteBookMark(user.getId(), tripId);
        }else {
            Trip trip = tripQueryService.findById(tripId);
            bookMarkSaveService.save(user, trip);
        }
    }
}
