package com.example.exchange.dto.user;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class UserRequestDto {

    @NotBlank(message = "name은 필수 입력 항목입니다.")
    private String name;

    private String email;
}
