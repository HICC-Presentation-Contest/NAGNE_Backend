package com.hicc.nagne_backend.domain.bookmark.application.service;

import com.hicc.nagne_backend.common.annotation.UseCase;
import com.hicc.nagne_backend.common.slice.SliceResponse;
import com.hicc.nagne_backend.domain.bookmark.application.dto.response.BookMarkResponse;
import com.hicc.nagne_backend.domain.bookmark.application.mapper.BookMarkMapper;
import com.hicc.nagne_backend.domain.bookmark.domain.entity.BookMark;
import com.hicc.nagne_backend.domain.bookmark.domain.service.BookMarkQueryService;
import com.hicc.nagne_backend.domain.locationinfo.application.dto.response.LocationInfoResponse;
import com.hicc.nagne_backend.domain.locationinfo.application.mapper.LocationInfoMapper;
import com.hicc.nagne_backend.domain.locationinfo.domain.entity.LocationInfo;
import com.hicc.nagne_backend.domain.locationinfo.domain.service.LocationInfoQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@UseCase
@RequiredArgsConstructor
@Transactional
public class BookMarkGetUseCase {

    private final BookMarkQueryService bookMarkQueryService;
    private final LocationInfoQueryService locationInfoQueryService;

    public SliceResponse<BookMarkResponse.BookMarkInfoResponse> getBookMark(Long userId, Pageable pageable){
        Slice<BookMark> bookMarkList = bookMarkQueryService.findByUserId(userId, pageable);

        Slice<BookMarkResponse.BookMarkInfoResponse> bookMarkResponseList
                = bookMarkList.map(bookMark -> {
                    Long tripId = bookMark.getTrip().getId();
                    List<LocationInfo> locationInfoList = locationInfoQueryService.findByTripId(tripId);

                    List<LocationInfoResponse.LocationInfoBookMarkResponse> locationInfoBookMarkResponseList
                            = locationInfoList.stream().map(locationInfo -> {
                                return LocationInfoMapper.mapToLocationInfoBookMarkResponse(locationInfo);
                            }).collect(Collectors.toList());

                    return BookMarkMapper.mapToBookMarkInfoResponse(bookMark, locationInfoBookMarkResponseList);
                });

        return SliceResponse.of(bookMarkResponseList);
    }
}
