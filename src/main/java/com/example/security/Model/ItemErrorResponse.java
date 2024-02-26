package com.example.security.Model;

import lombok.Data;

@Data
public class ItemErrorResponse {
    private int status;
    private String message;
    private long timeStamp;
    public ItemErrorResponse() {

    }
    public ItemErrorResponse(int status, String message, long timeStamp) {
        this.status = status;
        this.message = message;
        this.timeStamp = timeStamp;
    }
}
