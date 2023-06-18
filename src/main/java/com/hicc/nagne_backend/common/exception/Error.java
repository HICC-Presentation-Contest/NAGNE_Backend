package com.hicc.nagne_backend.common.exception;

import lombok.Getter;

@Getter
public enum Error {

	// user
	USER_NOT_FOUND("존재하지 않는 사용자 입니다.", 1000),

	// JWT
	INVALID_TOKEN("잘못된 토큰 요청", 7000),
	EXPIRED_TOKEN("토큰 만료", 7001),

	//S3
	FILE_UPLOAD_ERROR("파일 업로드에 실패하였습니다.", 2000),

	// kakao map
	KAKAO_MAP_ERROR("카카오 맵 API 요청에 실패하였습니다.", 3000);

	private final String message;
	private final int errorCode;

	Error(String message, int errorCode) {
		this.message = message;
		this.errorCode = errorCode;
	}
}
