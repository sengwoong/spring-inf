package com.example.demo;

import com.example.demo.member.Grade;
import com.example.demo.member.Member;
import com.example.demo.member.MemberService;
import com.example.demo.member.MemberserviceImpl;
import com.example.demo.order.Order;
import com.example.demo.order.OrderService;
import com.example.demo.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
//        MemberService memberService =new MemberserviceImpl(memberRepository);
//        OrderService orderService = new OrderServiceImpl(memberRepository, discountPolicy);
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();
        Long memberId =1L;
        Member member =new Member(memberId,"memberA", Grade.VIP);
        memberService.join(member);

        Order order= orderService.createOrder(memberId,"itemA",10000);

        System.out.println("order = " + order);
    }
}
