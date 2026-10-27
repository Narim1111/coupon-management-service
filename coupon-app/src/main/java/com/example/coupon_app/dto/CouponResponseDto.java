package com.example.coupon_app.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class CouponResponseDto {
    private Long id;
    private String code;
    private Integer discountPercent;
    private Long userId;

    public CouponResponseDto(Long id, String code, Integer discountPercent, Long userId) {
        this.id = id;
        this.code = code;
        this.discountPercent = discountPercent;
        this.userId = userId;
    }

}
