package com.server.demo.growup.global.response;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum BaseStatus {

    /**
     * 200 : 요청 성공
     */
    SUCCESS(true, HttpStatus.OK.value(),"요청에 성공하였습니다."),

    /**
     * 400 : Request, Response 오류
     */
    // 유저 관련
    NOT_FOUND_USER(false, HttpStatus.NOT_FOUND.value(), "유저를 찾을 수 없습니다."),


    // 투두 관련
    NOT_FOUND_TODO(false, HttpStatus.NOT_FOUND.value(), "투두리스트를 찾을 수 없습니다"),


    UNEXPECTED_ERROR(false, HttpStatus.INTERNAL_SERVER_ERROR.value(), "예상치 못한 에러가 발생했습니다."),
    /**
     * 500 :  Database, Server 오류
     */
    DATABASE_ERROR(false, HttpStatus.INTERNAL_SERVER_ERROR.value(), "데이터베이스 연결에 실패하였습니다."),
    SERVER_ERROR(false, HttpStatus.INTERNAL_SERVER_ERROR.value(), "서버에서 요청 처리에 실패하였습니다.");

    private final boolean isSuccess;
    private final int code;
    private final String message;

    private BaseStatus(boolean isSuccess, int code, String message) {
        this.isSuccess = isSuccess; // 성공 여부
        this.code = code;  // 코드
        this.message = message; // 내용
    }
}
