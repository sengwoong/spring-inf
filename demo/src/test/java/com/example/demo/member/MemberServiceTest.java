package com.example.demo.member;

import com.example.demo.AppConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {
//    MemberService memberService = new MemberserviceImpl(memberRepository);
    MemberService memberService;
    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig =new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    void join(){
        Member member = new Member(1L,"memberA",Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);


        Assertions.assertEquals(member, findMember);
    }
}
