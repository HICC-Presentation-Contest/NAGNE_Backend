package com.hicc.nagne_backend.domain.trip.application.service;

import com.hicc.nagne_backend.common.annotation.UseCase;
import com.hicc.nagne_backend.common.util.UserUtils;
import com.hicc.nagne_backend.domain.locationinfo.domain.service.LocationInfoSaveService;
import com.hicc.nagne_backend.domain.tag.domain.service.TagSaveService;
import com.hicc.nagne_backend.domain.trip.application.dto.request.TripRequest;
import com.hicc.nagne_backend.domain.trip.application.mapper.TripMapper;
import com.hicc.nagne_backend.domain.trip.domain.entity.Trip;
import com.hicc.nagne_backend.domain.trip.domain.service.TripSaveService;
import com.hicc.nagne_backend.domain.user.domain.entity.User;
import com.hicc.nagne_backend.domain.user.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@RequiredArgsConstructor
public class TripCreateUseCase {

    private final TripSaveService tripSaveService;
    private final TagSaveService tagSaveService;
    private final LocationInfoSaveService locationInfoSaveService;
    private final UserUtils userUtils;
    private final UserRepository userRepository;

    @Transactional
    public void createTrip(TripRequest.TripCreateRequest tripCreateRequest){

        User user = userUtils.getUser();

        Trip trip = TripMapper.mapToTrip(tripCreateRequest, user);

        tagSaveService.save(tripCreateRequest.getTag(), trip);
        locationInfoSaveService.save(tripCreateRequest.getLocationInfo(), trip);

        tripSaveService.save(trip);
    }
}
