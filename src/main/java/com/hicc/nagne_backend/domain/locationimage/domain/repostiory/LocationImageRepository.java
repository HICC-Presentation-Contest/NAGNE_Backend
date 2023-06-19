package com.hicc.nagne_backend.domain.locationimage.domain.repostiory;

import com.hicc.nagne_backend.domain.locationimage.domain.entity.LocationImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LocationImageRepository extends JpaRepository<LocationImage, Long> {

    Optional<LocationImage> findFirstByLocationInfoId(Long locationInfoId);
}
