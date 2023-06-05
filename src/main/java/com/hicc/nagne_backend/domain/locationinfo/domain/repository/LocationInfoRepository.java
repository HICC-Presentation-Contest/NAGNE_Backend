package com.hicc.nagne_backend.domain.locationinfo.domain.repository;

import com.hicc.nagne_backend.domain.locationinfo.domain.entity.LocationInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationInfoRepository extends JpaRepository<LocationInfo, Long> {
}
