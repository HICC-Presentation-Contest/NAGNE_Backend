package com.hicc.nagne_backend.domain.locationimage.domain.repostiory;

import com.hicc.nagne_backend.domain.locationimage.domain.entity.LocationImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationImageRepository extends JpaRepository<LocationImage, Long> {
}
