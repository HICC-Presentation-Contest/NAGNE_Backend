package com.hicc.nagne_backend.domain.trip.application.service;

import com.hicc.nagne_backend.common.annotation.UseCase;
import com.hicc.nagne_backend.domain.trip.domain.service.TripQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@RequiredArgsConstructor
@Transactional
public class TripCountGetUseCase {

    private final TripQueryService tripQueryService;

    public Long getTripCount(Long userId){
        return tripQueryService.countByUserId(userId);
    }

    public Long getTripCountByAddress(String address){
        return tripQueryService.countByAddress(address);
    }

//    public Long getTripCountByTag(String tagName){
//        return tripQueryService.countByTag(tagName);
//    }
}
