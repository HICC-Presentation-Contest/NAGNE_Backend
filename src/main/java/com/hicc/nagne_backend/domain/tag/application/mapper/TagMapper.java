package com.hicc.nagne_backend.domain.tag.application.mapper;

import com.hicc.nagne_backend.domain.tag.application.dto.TagRequest;
import com.hicc.nagne_backend.domain.tag.domain.entity.Tag;
import com.hicc.nagne_backend.domain.trip.domain.entity.Trip;

public class TagMapper {

    public static Tag mapToTag(Trip trip, TagRequest.TagCreate tagCreate) {
        return Tag.builder()
                .trip(trip)
                .name(tagCreate.getName())
                .build();
    }
}
