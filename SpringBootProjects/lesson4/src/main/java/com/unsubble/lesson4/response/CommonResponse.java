package com.unsubble.lesson4.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public abstract class CommonResponse {
    protected int statusCode;
    protected long timestamp;
    protected String message;

    public CommonResponse(int statusCode, long timestamp, String message) {
        this.statusCode = statusCode;
        this.timestamp = timestamp;
        this.message = message;
    }


}
