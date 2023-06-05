package com.hicc.nagne_backend.domain.tag.domain.service;

import com.hicc.nagne_backend.common.annotation.DomainService;
import com.hicc.nagne_backend.domain.tag.domain.entity.Tag;
import com.hicc.nagne_backend.domain.tag.domain.repository.TagRepository;
import com.hicc.nagne_backend.domain.trip.domain.entity.Trip;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@DomainService
@RequiredArgsConstructor
@Transactional
public class TagSaveService {

    private final TagRepository tagRepository;

    public void save(List<Tag> tagList, Trip trip){
        tagList.forEach(tag ->
                tagRepository.save(Tag.builder()
                    .name(tag.getName())
                    .trip(trip)
                    .build()));
    }
}
