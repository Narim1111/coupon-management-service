package com.example.coupon_app.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestDto {

    @NotBlank(message = "Email не может быть пустым")
    @Email(message = "Некорректный формат Email")
    private String email;
}