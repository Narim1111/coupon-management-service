package com.example.coupon_app.controller;

import com.example.coupon_app.entity.Coupon;
import com.example.coupon_app.service.CouponService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/coupons")
public class CouponController {
    private final CouponService couponService;

    public CouponController(CouponService couponService){
        this.couponService = couponService;
    }

    @GetMapping
    public List<Coupon> getAllCoupons(){
        return couponService.getAllCoupons();
    }

    @GetMapping("/user/{userId}")
    public List<Coupon> getCouponsByUserId(@PathVariable Integer userId){
        return couponService.getCouponsByUserId(userId);
    }

    @PostMapping
    public Coupon createCoupon(@RequestBody Coupon coupon){
        return couponService.createCoupon(coupon);
    }

    @DeleteMapping("/{id}")
    public void deleteCoupon(@PathVariable Integer id){
        couponService.deleteCoupon(id);
    }

    @PutMapping("/{id}")
    public Coupon updateCoupon(@PathVariable Integer id, @RequestBody Coupon coupon){
        return couponService.updateCoupon(id, coupon);
    }
}
