package com.hicc.nagne_backend.domain.tag.domain.repository;

import com.hicc.nagne_backend.domain.tag.domain.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {
}
