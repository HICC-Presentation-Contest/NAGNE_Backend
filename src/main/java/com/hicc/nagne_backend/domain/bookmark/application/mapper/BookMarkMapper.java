package com.hicc.nagne_backend.domain.bookmark.application.mapper;

import com.hicc.nagne_backend.domain.bookmark.application.dto.response.BookMarkResponse;
import com.hicc.nagne_backend.domain.bookmark.domain.entity.BookMark;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BookMarkMapper {
    public static List<BookMarkResponse.BookMarkInfoResponse> mapToBookMarkList (List<BookMark> bookMarkList) {
        return bookMarkList.stream()
                .map(bookMark -> BookMarkResponse.BookMarkInfoResponse.builder()
                        .tripId(bookMark.getTrip().getId())
                        .build())
                .collect(Collectors.toList());
    }
}
