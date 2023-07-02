package com.hicc.nagne_backend.domain.bookmark.application.service;

import com.hicc.nagne_backend.common.annotation.UseCase;
import com.hicc.nagne_backend.common.slice.SliceResponse;
import com.hicc.nagne_backend.common.util.UserUtils;
import com.hicc.nagne_backend.domain.bookmark.application.dto.response.BookMarkResponse;
import com.hicc.nagne_backend.domain.bookmark.domain.entity.BookMark;
import com.hicc.nagne_backend.domain.bookmark.domain.service.BookMarkQueryService;
import com.hicc.nagne_backend.domain.trip.domain.entity.Trip;
import com.hicc.nagne_backend.domain.user.domain.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@RequiredArgsConstructor
@Transactional
public class BookMarkGetUseCase {

    private final UserUtils userUtils;
    private final BookMarkQueryService bookMarkQueryService;

    public SliceResponse<BookMarkResponse.BookMarkInfoResponse> getBookMark(Pageable pageable) {
        final User user = userUtils.getUser();
        final Slice<BookMark> bookMarkList = bookMarkQueryService.findByUserId(user.getId(), pageable);
        final Slice<BookMarkResponse.BookMarkInfoResponse> bookMarkResponseList = bookMarkList.map(bookMark -> {
            final Trip trip = bookMark.getTrip();
            final Long tripId = trip.getId();
            final String tripImageUrl = trip.getTripImageUrl();
            return BookMarkResponse.BookMarkInfoResponse.builder()
                    .tripId(tripId)
                    .tripImageUrl(tripImageUrl)
                    .isBookMark(true)
                    .build();
        });
        return SliceResponse.of(bookMarkResponseList);
    }

    public BookMarkResponse.BookMarkCheckResponse checkBookMark(final Long tripId) {
        final User user = userUtils.getUser();
        final boolean isBookMark = bookMarkQueryService.existsByUserIdAndTripId(user.getId(), tripId);
        return new BookMarkResponse.BookMarkCheckResponse(isBookMark);
    }
}
