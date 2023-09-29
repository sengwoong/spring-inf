package com.example.demo.beandlind;

import com.example.demo.AppConfig;
import com.example.demo.member.MemberService;
import com.example.demo.member.MemberserviceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextBasicFindTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈이름조회")
    void findBeanByName(){
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        System.out.println("memberService = " + memberService);
        System.out.println("memberService.getClass() = " + memberService.getClass());
        // Use Assertions to check if the memberService is an instance of MemberserviceImpl
        Assertions.assertTrue(memberService instanceof MemberserviceImpl);

    }
    @Test
    @DisplayName("이름없는 타입으로만 조")
    void findBeanByType(){
        MemberService memberService = ac.getBean(MemberService.class);
        System.out.println("memberService = " + memberService);
        System.out.println("memberService.getClass() = " + memberService.getClass());
        // Use Assertions to check if the memberService is an instance of MemberserviceImpl
        Assertions.assertTrue(memberService instanceof MemberserviceImpl);

    }
    @Test
    @DisplayName("구체 타입으로만 조회")
    void findBeanByType2(){
        MemberService memberService = ac.getBean("memberService",MemberserviceImpl.class);
        System.out.println("memberService = " + memberService);
        System.out.println("memberService.getClass() = " + memberService.getClass());
        // Use Assertions to check if the memberService is an instance of MemberserviceImpl
        Assertions.assertTrue(memberService instanceof MemberserviceImpl);

    }

    @Test
    @DisplayName("빈이름조회")
    void findBeanByNameX(){

        // Use Assertions to check if the memberService is an instance of MemberserviceImpl
        Assertions.assertThrows(NoSuchBeanDefinitionException.class, () -> {
            MemberService memberService = ac.getBean("xxx", MemberService.class);
        });

    }

}
