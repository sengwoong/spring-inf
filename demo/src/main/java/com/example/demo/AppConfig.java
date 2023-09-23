package com.example.demo;


import com.example.demo.discount.FixDiscountPolicey;
import com.example.demo.member.MemberService;
import com.example.demo.member.MemberserviceImpl;
import com.example.demo.member.MemoryMemberRepository;
import com.example.demo.order.OrderService;
import com.example.demo.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public MemberService memberService(){

    // 생성자함수로 뺴서들고오기 컨트롤 알트 m
    return  new MemberserviceImpl(getMemberRepository());

        }
    @Bean
    public MemoryMemberRepository getMemberRepository() {
        return new MemoryMemberRepository();
    }
    @Bean
    public  OrderService orderService(){
    return  new OrderServiceImpl(getMemberRepository(), getDiscountPolicy());
}

    @Bean
    public FixDiscountPolicey getDiscountPolicy() {
        return new FixDiscountPolicey();
    }
}
