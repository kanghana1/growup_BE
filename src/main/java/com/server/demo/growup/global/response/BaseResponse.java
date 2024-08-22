package com.server.demo.growup.global.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonPropertyOrder // 직렬화 순서 지정
public class BaseResponse<T> {

    private final Boolean isSuccess;
    private final String message;
    private final int code;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T result;

    // 요청 성공
    public BaseResponse(T result){
        this.isSuccess = BaseStatus.SUCCESS.isSuccess();
        this.message = BaseStatus.SUCCESS.getMessage();
        this.code = BaseStatus.SUCCESS.getCode();
        this.result = result;
    }

    // 요청 실패
    public BaseResponse(BaseStatus status) {
        this.isSuccess = status.isSuccess();
        this.message = status.getMessage();
        this.code = status.getCode();
    }
}