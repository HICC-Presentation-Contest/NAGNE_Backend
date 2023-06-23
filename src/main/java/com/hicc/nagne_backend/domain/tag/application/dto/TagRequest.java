package com.hicc.nagne_backend.domain.tag.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class TagRequest {

    @Getter
    @Setter
    @NoArgsConstructor
    public static class TagCreate {
        @Schema(description = "태그 이름", defaultValue = "name")
        private String name;

        @Builder
        public TagCreate(String name) {
            this.name = name;
        }
    }
}
