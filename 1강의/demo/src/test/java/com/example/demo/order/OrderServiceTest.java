package com.example.demo.order;

import com.example.demo.AppConfig;
import com.example.demo.member.Grade;
import com.example.demo.member.Member;
import com.example.demo.member.MemberService;
import com.example.demo.member.MemberserviceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {
    MemberService memberService;
    OrderService oderService;

    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig =new AppConfig();
        memberService = appConfig.memberService();

        oderService = appConfig.orderService();
    }

    @Test
    void createOrder(){
        Long memberId =1L;
        Member member = new Member(memberId,"memberA", Grade.VIP);
        memberService.join(member);
        Order order = oderService.createOrder(memberId, "itemA", 1000);

        Assertions.assertEquals(1000, order.getDiscountPrice());
    }
}
