package com.hicc.nagne_backend.domain.bookmark.presentation;

import com.hicc.nagne_backend.common.exception.dto.ErrorResponse;
import com.hicc.nagne_backend.common.slice.SliceResponse;
import com.hicc.nagne_backend.domain.bookmark.application.dto.response.BookMarkResponse;
import com.hicc.nagne_backend.domain.bookmark.application.service.BookMarkCountGetUseCase;
import com.hicc.nagne_backend.domain.bookmark.application.service.BookMarkCreateUseCase;
import com.hicc.nagne_backend.domain.bookmark.application.service.BookMarkGetUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class BookMarkController {

    private final BookMarkGetUseCase bookMarkGetUseCase;
    private final BookMarkCreateUseCase bookMarkCreateUseCase;
    private final BookMarkCountGetUseCase bookMarkCountGetUseCase;

    @Operation(summary = "북마크 조회", tags = {"BookMarkController"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "북마크 조회 성공"),
            @ApiResponse(responseCode = "404", description = "북마크 조회 실패",
            content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping("/bookmark")
    public SliceResponse<BookMarkResponse.BookMarkInfoResponse> getBookMark(Pageable pageable){
        return bookMarkGetUseCase.getBookMark(pageable);
    }

    @Operation(summary = "북마크 생성", tags = {"BookMarkController"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "북마크 생성 성공"),
            @ApiResponse(responseCode = "404", description = "북마크 생성 실패",
            content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    @CacheEvict(value = "bookMarkCount", key = "#tripId")
    @PostMapping("/bookmark")
    public void createBookMark(@RequestParam Long tripId){
        bookMarkCreateUseCase.createBookMark(tripId);
    }

    /**
     * 캐시 적용전 : 3회 warmup, 5회 측정 결과 평균 74.8
     * 캐시 적용후 : 3회 warmup, 5회 측정 결과 평균 23.8
     * 캐시 적용으로 성능 향상 74.8 -> 23.8 (3.14배)
     */
    @Operation(summary = "북마크 총 갯수 조회", tags = {"BookMarkController"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "북마크 총 갯수 조회 성공"),
            @ApiResponse(responseCode = "404", description = "북마크 총 갯수 조회 실패",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    @Cacheable(value = "bookMarkCount", key = "#tripId")
    @GetMapping("/bookmark/count")
    public BookMarkResponse.BookMarkCountResponse getBookMarkCount(@RequestParam Long tripId){
        return bookMarkCountGetUseCase.getBookMarkCount(tripId);
    }

    @Operation(summary = "북마크 여부 조회", tags = {"BookMarkController"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "북마크 여부 조회 성공"),
            @ApiResponse(responseCode = "404", description = "북마크 여부 조회 실패",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping("/bookmark/check")
    public BookMarkResponse.BookMarkCheckResponse checkBookMark(@RequestParam Long tripId){
        return bookMarkGetUseCase.checkBookMark(tripId);
    }
}
