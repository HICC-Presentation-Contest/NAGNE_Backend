package com.hicc.nagne_backend.domain.trip.application.service;

import com.hicc.nagne_backend.domain.trip.application.dto.request.TripRequest;
import com.hicc.nagne_backend.domain.trip.domain.service.TripSaveService;
import com.hicc.nagne_backend.domain.user.domain.entity.User;
import com.hicc.nagne_backend.domain.user.domain.service.UserQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TripCreateService {

    private final TripSaveService tripSavService;
    private final UserQueryService userQueryService;

    public void createTrip(TripRequest.TripCreateRequest tripCreateRequest){
        User user = userQueryService.findById(tripCreateRequest.getUserId());
        tripSavService.save(tripCreateRequest.getAddress(),tripCreateRequest.getTitle(), user);
    }
}
