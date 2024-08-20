package com.server.demo.growup.global.exception;

import com.server.demo.growup.global.response.BaseStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseException extends RuntimeException{

    private BaseStatus status;

    public BaseException(BaseStatus status){
        super(status.getMessage());
        this.status = status;
    }
}
