package com.example.coupon_app.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CouponRequestDto {

    @NotBlank(message = "Код купона не должен быть пустым")
    private String code;

    @NotNull(message = "Процент скидки обязателен")
    @Min(value = 1, message = "Скидка должна быть не менее 1%")
    @Max(value = 100, message = "Скидка не может привышать 100%")
    private Integer discountPercent;

    @NotNull(message = "ID пользователя обязателен")
    private Long userId;
}
