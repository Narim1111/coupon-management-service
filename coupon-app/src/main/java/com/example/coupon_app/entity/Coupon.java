package com.example.coupon_app.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "coupons")
public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "code")
    private String code;

    @Column(name = "discount_percent")
    private Integer discountPercent;

    public Coupon(){}

    public Coupon(Integer userId, String code){
        this.userId = userId;
        this.code = code;
    }

    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public Integer getUserId(){
        return userId;
    }

    public void setUserId(Integer userId){
        this.userId = userId;
    }

    public String getCode(){
        return code;
    }

    public void setCode(String code){
        this.code = code;
    }

    public Integer getDiscountPercent(){
        return discountPercent;
    }

    public void setDiscountPercent(Integer discountPercent){
        this.discountPercent = discountPercent;
    }

    @Override
    public String toString(){
        return "Coupon{id=" + id + ", userId=" + userId + ", code=" + code +"}";
    }

}
