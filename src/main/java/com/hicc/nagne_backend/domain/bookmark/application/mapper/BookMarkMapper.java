package com.hicc.nagne_backend.domain.bookmark.application.mapper;

import com.hicc.nagne_backend.domain.bookmark.application.dto.response.BookMarkResponse;
import com.hicc.nagne_backend.domain.bookmark.domain.entity.BookMark;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BookMarkMapper {
//    public static Slice<BookMarkResponse.BookMarkInfoResponse> mapToBookMarkList (Slice<BookMark> bookMarkList) {
//        return bookMarkList.stream()
//                .map(bookMark -> BookMarkResponse.BookMarkInfoResponse.builder()
//                        .tripId(bookMark.getTrip().getId())
//                        .build())
//                .collect(Collectors.toCollection(Slice::));
//    }

    public static BookMarkResponse.BookMarkInfoResponse mapToBookMarkInfoResponse (BookMark bookMark) {
        return BookMarkResponse.BookMarkInfoResponse.builder()
                .tripId(bookMark.getTrip().getId())
                .build();
    }
}
