package com.example.coupon_app;

import com.example.coupon_app.repository.CouponRepository;
import com.example.coupon_app.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CouponAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(CouponAppApplication.class, args);
	}

    @Bean public CommandLineRunner run(UserRepository userRepository, CouponRepository couponRepository){
        return args ->{
            System.out.println("=== ВСЕ КУПОНЫ ===");
            couponRepository.findAll().forEach(System.out::println);

            System.out.println("\n=== КУПОНЫ ПОЛЬЗОВАТЕЛЯ С ID = 1 ===");
            couponRepository.findByUserId(1).forEach(System.out::println);
        };
    }

}
