package com.example.coupon_app.controller;

import com.example.coupon_app.dto.CouponRequestDto;
import com.example.coupon_app.dto.CouponResponseDto;
import com.example.coupon_app.entity.Coupon;
import com.example.coupon_app.service.CouponService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/coupons")
public class CouponController {
    private final CouponService couponService;

    public CouponController(CouponService couponService){
        this.couponService = couponService;
    }

    @PostMapping
    public ResponseEntity<CouponResponseDto> createCoupon(@RequestBody @Valid CouponRequestDto requestDto){
        CouponResponseDto savedCoupon = couponService.createCoupon(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCoupon);

    }
}
