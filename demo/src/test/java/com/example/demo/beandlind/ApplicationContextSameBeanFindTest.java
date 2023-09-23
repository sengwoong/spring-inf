package com.example.demo.beandlind;

import com.example.demo.AppConfig;
import com.example.demo.member.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class ApplicationContextSameBeanFindTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SameNeamConfig.class);

    @Configuration
    static class SameNeamConfig{

        @Bean
        public MemberRepository memberRepository1(){
            return new MemoryMemberRepository();
        }
        @Bean
        public MemberRepository memberRepository2(){
            return new MemoryMemberRepository();
        }
    }


    @Test
    @DisplayName("빈이름조회")
    void findBeanByTypeDuplicate() {
        // NoSuchBeanDefinitionException을 예상하면 됩니다.
        assertThrows(NoSuchBeanDefinitionException.class, () -> {
            ac.getBean(MemberRepository.class);
        });
    }
    @Test
    @DisplayName("타입으로 조회시 같은 타입이 둘이상있으면 빈 이름을 지정하면 됩니다.")
    void findBeanByName() {
        // 빈 이름을 지정하여 해당 빈을 조회합니다.
        // 빈하나의 값을 들고오면(클래스이름으로) 중복된빈이라도 잘들고옵니다.
        MemberRepository bean = ac.getBean("memberRepository1", MemberRepository.class);
        assertTrue(bean instanceof MemberRepository);
    }

    @Test
    @DisplayName("타입으로모두조회.")
    void findAllBeanByType() {
        // 빈 이름을 지정하여 해당 빈을 조회합니다.
        // 빈하나의 값을 들고오면(클래스이름으로) 중복된빈이라도 잘들고옵니다.
        Map<String,MemberRepository> bean = ac.getBeansOfType( MemberRepository.class);
        for (String key:bean.keySet()){
            System.out.println("key = " + key+"value"+bean.get(key));
        }
        System.out.println("bean = " + bean);
        assertEquals(2, bean.size());

    }
}
