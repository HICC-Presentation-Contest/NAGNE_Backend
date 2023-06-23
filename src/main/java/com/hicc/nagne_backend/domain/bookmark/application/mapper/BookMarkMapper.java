package com.hicc.nagne_backend.domain.bookmark.application.mapper;

import com.hicc.nagne_backend.domain.bookmark.application.dto.response.BookMarkResponse;
import com.hicc.nagne_backend.domain.bookmark.domain.entity.BookMark;
import com.hicc.nagne_backend.domain.locationinfo.application.dto.response.LocationInfoResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BookMarkMapper {

    public static BookMarkResponse.BookMarkInfoResponse mapToBookMarkInfoResponse (
            BookMark bookMark, List<LocationInfoResponse.LocationInfoBookMarkResponse> locationInfoBookMarkResponseList) {
        return BookMarkResponse.BookMarkInfoResponse.builder()
                .tripId(bookMark.getTrip().getId())
                .locationInfo(locationInfoBookMarkResponseList)
                .build();

    }
}
