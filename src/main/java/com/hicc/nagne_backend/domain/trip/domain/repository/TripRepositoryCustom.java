package com.hicc.nagne_backend.domain.trip.domain.repository;

import com.hicc.nagne_backend.domain.trip.domain.entity.Trip;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

public interface TripRepositoryCustom {

    Slice<Trip> findTripListByAddress(String address, Pageable pageable);

    Long countByAddress(String address);

    Slice<Trip> findTripListByTag(String tag, Pageable pageable);

    Long countByTag(String tag);

    Slice<Trip> findMainPageTripList(String address, Pageable pageable);
}
