package com.example.promotionpage.global.error;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

	// Common

	INVALID_INPUT_VALUE(HttpStatus.BAD_REQUEST, "Request Body를 통해 전달된 값이 유효하지 않습니다."),

	// S3
	INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "서버 문제로 S3 이미지 업로드에 실패하였습니다."),
	NOT_EXIST_IMAGE_FILE(HttpStatus.BAD_REQUEST, "업로드 할 이미지가 존재하지 않습니다."),

	ERROR_S3_DELETE_OBJECT(HttpStatus.INTERNAL_SERVER_ERROR, "서버 문제 S3 이미지 삭제에 실패하였습니다."),
	ERROR_S3_UPDATE_OBJECT(HttpStatus.INTERNAL_SERVER_ERROR, "서버 문제로 S3 이미지 업로드에 실패하였습니다."),


	// notice board
	INVALID_NOTICE_BOARD_ID(HttpStatus.BAD_REQUEST, "유효하지 않은 notice board 식별자입니다."),

	// project
	INVALID_PROJECT_ID(HttpStatus.BAD_REQUEST, "유효하지 않은 project 식별자입니다."),


	// partner information
	INVALID_PARTNER_INFORMATION_ID(HttpStatus.BAD_REQUEST,"유효하지 않은 partner information 식별자입니다."),

	// request
	INVALID_REQUEST_ID(HttpStatus.BAD_REQUEST,"유효하지 않은 request 식별자입니다.");

	private final HttpStatus status;
	private final String message;

}