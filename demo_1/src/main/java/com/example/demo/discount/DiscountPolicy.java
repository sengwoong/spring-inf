package com.example.demo.discount;

import com.example.demo.member.Member;

public interface DiscountPolicy {
    /**
     *  /** 로만
     * @param member
     * @param price
     * @return 할인대상금액
     */
    int discount(Member member,int price);
}
