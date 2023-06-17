package com.hicc.nagne_backend.domain.tag.domain.service;

import com.hicc.nagne_backend.common.annotation.DomainService;
import com.hicc.nagne_backend.domain.tag.domain.entity.Tag;
import com.hicc.nagne_backend.domain.tag.domain.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@DomainService
@RequiredArgsConstructor
@Transactional
public class TagSaveService {

    private final TagRepository tagRepository;

    public void save(Tag tag){
        tagRepository.save(tag);
    }
}
