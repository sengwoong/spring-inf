package com.example.demo.Single;

import com.example.demo.AppConfig;
import com.example.demo.member.MemberRepository;
import com.example.demo.member.MemberserviceImpl;
import com.example.demo.order.OrderServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import static org.junit.jupiter.api.Assertions.assertSame;

public class ConfigurationSingletonTest {
    @Test
    void configurationTest() {
        ApplicationContext ac = new
                AnnotationConfigApplicationContext(AppConfig.class);
        MemberserviceImpl memberService = ac.getBean("memberService",
                MemberserviceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService",
                OrderServiceImpl.class);
        MemberRepository memberRepository = ac.getBean("memberRepository",
                MemberRepository.class);
//모두 같은 인스턴스를 참고하고 있다.
        System.out.println(" =========================== " );
        System.out.println("memberService -> memberRepository = " +
                memberService.getMemberRepository());
        System.out.println("orderService -> memberRepository= " +
                orderService.getMemberRepository());
        System.out.println("memberRepository = " + memberRepository);
//모두 같은 인스턴스를 참고하고 있다.

        assertSame(memberService.getMemberRepository(),memberRepository);
        assertSame(orderService.getMemberRepository(),memberRepository);

    }
}