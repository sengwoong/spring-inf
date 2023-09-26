package com.example.demo.discount;

import com.example.demo.member.Grade;
import com.example.demo.member.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
//아삹, 시영빙밥
import static org.junit.jupiter.api.Assertions.*;
//컨트롤 쉬프트 t = 새로운 테스트 작성
class RateDiscountPolicyTest {
    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();
    @Test
    @DisplayName("Vip는 10퍼 할인")
    void vip_O(){
        Member member =new Member(1L,"mewmberVIP", Grade.VIP);

        int discount = discountPolicy.discount(member, 10000);
//아래는 자주사용하는 함수라서 임폴트하면좋다 알트엔터누르면
//        Assertions.assertEquals(1000, discount);
        assertEquals(1000, discount);
    }


    @Test
    @DisplayName("Vip는 10퍼 할인")
    void vip_x(){
        Member member =new Member(1L,"mewmberVIP", Grade.BASIC);

        int discount = discountPolicy.discount(member, 10000);

        assertEquals(0, discount);
    }

}


