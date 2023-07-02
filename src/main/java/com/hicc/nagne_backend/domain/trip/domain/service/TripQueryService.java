package com.hicc.nagne_backend.domain.trip.domain.service;

import com.hicc.nagne_backend.common.annotation.DomainService;
import com.hicc.nagne_backend.domain.trip.domain.entity.Trip;
import com.hicc.nagne_backend.domain.trip.domain.repository.TripRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.transaction.annotation.Transactional;

@DomainService
@RequiredArgsConstructor
@Transactional
public class TripQueryService {

	private final TripRepository tripRepository;

	public Trip findById(Long tripId){
		Trip trip = tripRepository.findById(tripId)
			.orElseThrow(() -> new IllegalArgumentException("해당 여정이 존재하지 않습니다."));
		return trip;
	}

	public Slice<Trip> findByUserId(Long userId, Pageable pageable){
		Slice<Trip> tripList = tripRepository.findByUserIdOrderByCreatedDateDesc(userId, pageable);
		return tripList;
	}

	public Long countByUserId(Long userId){
		Long count = tripRepository.countByUserId(userId);
		return count;
	}

	public Slice<Trip> findTripListByAddress(String address, Pageable pageable){
		Slice<Trip> tripList = tripRepository.findTripListByAddress(address, pageable);
		return tripList;
	}

	public Long countByAddress(String address){
		Long count = tripRepository.countByAddress(address);
		return count;
	}

	public Slice<Trip> findTripListByTag(String tagName, Pageable pageable){
		Slice<Trip> tripList = tripRepository.findTripListByTag(tagName, pageable);
		return tripList;
	}

	public Slice<Trip> findMainPageTripList(String address, Pageable pageable){
		Slice<Trip> tripList = tripRepository.findMainPageTripList(address, pageable);
		return tripList;
	}

	public Slice<Trip> findMainPageTripListByPopularity(String address, Pageable pageable) {
		Slice<Trip> tripList = tripRepository.findMainPageTripListByPopularity(address, pageable);
		return tripList;
	}
}
