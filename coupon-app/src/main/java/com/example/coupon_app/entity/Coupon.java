package com.example.coupon_app.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "coupons")
public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Код купона не может быть пустым")
    @Column(name = "code", unique = true, nullable = false)
    private String code;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @NotNull(message = "Скидка должна быть указана")
    @Min(value = 1, message = "Скидка не должна быть меньше 1%")
    @Max(value = 100, message = "Скидка не должна быть больше 100%")
    @Column(name = "discount_percent")
    private Integer discountPercent;

    public Coupon(){}

    public Coupon(User user, String code){
        this.user = user;
        this.code = code;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public User getUser(){
        return user;
    }

    public void setUser(User user){
        this.user = user;
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
        return "Coupon{id=" + id + ", code=" + code + ",discountPercent" + discountPercent + "}";
    }

}
