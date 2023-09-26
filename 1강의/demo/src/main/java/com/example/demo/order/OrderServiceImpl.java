package com.example.demo.order;

import com.example.demo.discount.DiscountPolicy;
import com.example.demo.member.Member;
import com.example.demo.member.MemberRepository;

public class OrderServiceImpl  implements  OrderService{

   // private  final MemberRepository memberRepository =new MemoryMemberRepository();
//    private  final DiscountPolicy discountPolicy = new FixDiscountPolicey();
//    private  final DiscountPolicy discountPolicy = new RateDiscountPolicy();

    private  final MemberRepository memberRepository ;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override

    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findByID(memberId);
        //단앨책임원칙 애는 할인에대한 정보를 모른다 이렇게하여서 여러방법을 가져와서 사용가능하다.
        int discountPrice = discountPolicy.discount(member, itemPrice);

//올더에넘겨서처리해라
        return new Order(memberId,itemName,itemPrice,discountPrice);

        // 똑같은 함수만들기 커맨드옵션 m
    }
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
