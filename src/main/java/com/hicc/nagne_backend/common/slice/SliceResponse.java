package com.hicc.nagne_backend.common.slice;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Slice;

import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SliceResponse<T> {

    private List<T> content;
    private int page;
    private int size;
    private boolean hasNext;

    @Builder
    private SliceResponse(List<T> content, int page, int size, boolean hasNext) {
        this.content = content;
        this.page = page;
        this.size = size;
        this.hasNext = hasNext;
    }

    public static <T> SliceResponse<T> of(Slice<T> slice) {
        return new SliceResponse<>(slice.getContent(), slice.getNumber(), slice.getSize(), slice.hasNext());
    }
}