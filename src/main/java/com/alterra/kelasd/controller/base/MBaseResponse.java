package com.alterra.kelasd.controller.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MBaseResponse<T> {
    private Boolean success;
    private String message;
    private T data;

    public MBaseResponse(Boolean success, String message) {
        this.success = success;
        this.message = message;
    }
}
