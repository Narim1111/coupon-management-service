package com.example.coupon_app.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Email;

import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Coupon> coupons = new ArrayList<>();

    @NotBlank(message = "Email не может быть пустым")
    @Email(message = "Некорректный формат Email")
    private String email;

    public User(){}

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public List<Coupon> getCoupons(){
        return coupons;
    }

    public void setCoupons(List<Coupon> coupons){
        this.coupons = coupons;
    }

    @Override
    public String toString(){
        return "User{id=" + id + ", email" + email + "}";
    }
}
