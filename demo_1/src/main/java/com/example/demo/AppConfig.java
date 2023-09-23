package com.example.demo;


import com.example.demo.discount.FixDiscountPolicey;
import com.example.demo.member.MemberService;
import com.example.demo.member.MemberserviceImpl;
import com.example.demo.member.MemoryMemberRepository;
import com.example.demo.order.OrderService;
import com.example.demo.order.OrderServiceImpl;

public class AppConfig {
public MemberService memberService(){

    // 생성자함수로 뺴서들고오기 컨트롤 알트 m
    return  new MemberserviceImpl(getMemberRepository());

}

    private MemoryMemberRepository getMemberRepository() {
        return new MemoryMemberRepository();
    }

    public  OrderService orderService(){
    return  new OrderServiceImpl(getMemberRepository(), getDiscountPolicy());
}

    private FixDiscountPolicey getDiscountPolicy() {
        return new FixDiscountPolicey();
    }
}
