package com.hicc.nagne_backend.domain.bookmark.application.service;

import com.hicc.nagne_backend.common.annotation.UseCase;
import com.hicc.nagne_backend.common.slice.SliceResponse;
import com.hicc.nagne_backend.domain.bookmark.application.dto.response.BookMarkResponse;
import com.hicc.nagne_backend.domain.bookmark.domain.entity.BookMark;
import com.hicc.nagne_backend.domain.bookmark.domain.service.BookMarkQueryService;
import com.hicc.nagne_backend.domain.trip.domain.entity.Trip;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@RequiredArgsConstructor
@Transactional
public class BookMarkGetUseCase {

    private final BookMarkQueryService bookMarkQueryService;

    public SliceResponse<BookMarkResponse.BookMarkInfoResponse> getBookMark(final Long userId, Pageable pageable) {
        final Slice<BookMark> bookMarkList = bookMarkQueryService.findByUserId(userId, pageable);
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
}
