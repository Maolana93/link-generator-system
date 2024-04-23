package com.link.generator.system.link.generator.system.utils;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class ApiErrorResponse {
    private Integer errorCode;
    private String errorMessage;
    private Date date;

    public ApiErrorResponse(Integer errorCode, String errorMessage, Date date) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.date = date;
    }

}
