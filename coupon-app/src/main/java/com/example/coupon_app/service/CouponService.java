package com.example.coupon_app.service;

import com.example.coupon_app.dto.CouponRequestDto;
import com.example.coupon_app.dto.CouponResponseDto;
import com.example.coupon_app.entity.Coupon;
import com.example.coupon_app.entity.User;
import com.example.coupon_app.exception.CouponAlreadyExistsException;
import com.example.coupon_app.exception.UserNotFoundException;
import com.example.coupon_app.repository.UserRepository;
import com.example.coupon_app.repository.CouponRepository;
import org.springframework.stereotype.Service;

@Service
public class CouponService{

    private final CouponRepository couponRepository;
    private final UserRepository userRepository;

    public CouponService(CouponRepository couponRepository, UserRepository userRepository){
        this.couponRepository = couponRepository;
        this.userRepository = userRepository;
    }

    public CouponResponseDto createCoupon(CouponRequestDto dto){
        User user = userRepository.findById(dto.getUserId()).orElseThrow(() -> new UserNotFoundException(dto.getUserId()));

        Coupon coupon = new Coupon();
        coupon.setCode(dto.getCode());
        coupon.setDiscountPercent(dto.getDiscountPercent());

        coupon.setUser(user);

        if (couponRepository.existsByCode(dto.getCode())){
            throw new CouponAlreadyExistsException("Купон с кодом " + dto.getCode() + "уже существует");
        }

        Coupon save = couponRepository.save(coupon);
        return new CouponResponseDto(coupon.getId(), coupon.getCode(), coupon.getDiscountPercent(), coupon.getUser().getId());
    }
}
