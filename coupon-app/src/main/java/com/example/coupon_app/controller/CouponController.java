package com.example.coupon_app.controller;

import com.example.coupon_app.dto.CouponRequestDto;
import com.example.coupon_app.entity.Coupon;
import com.example.coupon_app.service.CouponService;
import jakarta.validation.Valid;
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
    public ResponseEntity<Coupon> createCoupon(@RequestBody @Valid CouponRequestDto requestDto){
        Coupon savedCoupon = couponService.createCoupon(requestDto);
        return ResponseEntity.ok(savedCoupon);
    }
}
