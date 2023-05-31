package com.hicc.nagne_backend.domain.locationimage.domain.repostiory;

import com.hicc.nagne_backend.domain.locationimage.domain.entity.LocationImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationImageRepository extends JpaRepository<LocationImage, Long> {
}
