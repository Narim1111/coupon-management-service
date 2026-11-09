package com.example.coupon_app.exception;

public class CouponAlreadyExistsException extends RuntimeException {
    public CouponAlreadyExistsException(String message) {
        super (message);
    }
}
