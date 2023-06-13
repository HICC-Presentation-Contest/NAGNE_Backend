package com.hicc.nagne_backend.domain.tag.application.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class TagRequest {

    @Getter
    @NoArgsConstructor
    public static class TagCreate {
        private String name;

        @Builder
        public TagCreate(String name, String color) {
            this.name = name;
        }
    }
}
