package com.example.coupon_app.service;

import com.example.coupon_app.entity.Coupon;
import com.example.coupon_app.repository.CouponRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CouponService{
    private final CouponRepository couponRepository;

    public CouponService(CouponRepository couponRepository){
        this.couponRepository = couponRepository;
    }

    public List<Coupon> getAllCoupons(){
        return couponRepository.findAll();
    }

    public List<Coupon> getCouponsByUserId(Integer userId){
        return couponRepository.findByUserId(userId);
    }

    public Coupon createCoupon(Coupon coupon){
        return couponRepository.save(coupon);
    }

    public void deleteCoupon(Integer id){
        couponRepository.deleteById(id);
    }

    public Coupon updateCoupon(Integer id, Coupon updatedCoupon){
        Coupon existingCoupon = couponRepository.findById(id).orElseThrow(() -> new RuntimeException("Coupon not found with id = " + id));

        existingCoupon.setCode(updatedCoupon.getCode());
        existingCoupon.setDiscountPercent(updatedCoupon.getDiscountPercent());
        existingCoupon.setUserId(updatedCoupon.getUserId());

        return couponRepository.save(existingCoupon);
    }
}
