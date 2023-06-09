package com.hicc.nagne_backend.domain.trip.application.service;

import com.hicc.nagne_backend.common.annotation.UseCase;
import com.hicc.nagne_backend.domain.trip.application.dto.response.TripResponse;
import com.hicc.nagne_backend.domain.trip.domain.service.TripQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@RequiredArgsConstructor
@Transactional
public class TripCountGetUseCase {

    private final TripQueryService tripQueryService;

    public TripResponse.TripCountResponse getTripCount(Long userId){
        return new TripResponse.TripCountResponse(tripQueryService.countByUserId(userId));
    }

    public TripResponse.TripCountResponse getTripCountByAddress(String address){
        return new TripResponse.TripCountResponse(tripQueryService.countByAddress(address));
    }

}
