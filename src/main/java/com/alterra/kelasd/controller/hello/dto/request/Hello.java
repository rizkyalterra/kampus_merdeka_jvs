package com.alterra.kelasd.controller.hello.dto.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class Hello {

    @NotEmpty(message = "Hello tidak boleh kosong")
    private String hello;
}
