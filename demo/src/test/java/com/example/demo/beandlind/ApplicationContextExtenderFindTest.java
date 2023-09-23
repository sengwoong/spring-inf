package com.example.demo.beandlind;

import com.example.demo.discount.DiscountPolicy;
import com.example.demo.discount.FixDiscountPolicey;
import com.example.demo.discount.RateDiscountPolicy;
import com.example.demo.member.MemberRepository;
import com.example.demo.member.MemoryMemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class ApplicationContextExtenderFindTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SameNeamConfig.class);

    @Configuration
    static class SameNeamConfig{

        @Bean
        public DiscountPolicy rateDiscountPolicy(){
            return new RateDiscountPolicy();
        }
        @Bean
        public DiscountPolicy fixDiscountPolicy(){
            return new FixDiscountPolicey();
        }
    }


    @Test
    @DisplayName("부모타입으로 조회시 자식이 둘이상 있으면 중복오류발생함")
    void findBeanByTypeDuplicate() {
        // Attempt to retrieve a bean of type DiscountPolicy
        assertThrows(NoSuchBeanDefinitionException.class, () -> {
            //ac 가 부모고 부모기준애서 검색했을떄 DiscountPolicy가 두개라서 에러
            ac.getBean(DiscountPolicy.class);
        });
    }
    @Test
    @DisplayName("부모타입으로 조회시 자식이 둘이상 있으면 자식이름지정")
    void findBeanByTypeBeanName() {
        // Attempt to retrieve a bean of type DiscountPolicy
        DiscountPolicy rateDiscountPolicy = ac.getBean("rateDiscountPolicy", DiscountPolicy.class);
        assertTrue(rateDiscountPolicy instanceof RateDiscountPolicy);
    }
    @Test
    @DisplayName("특정 하위 타입으로 조회 안좋은방")
    void findBeanBySubtype() {
        // Attempt to retrieve a bean of type DiscountPolicy
        DiscountPolicy rateDiscountPolicy = ac.getBean( RateDiscountPolicy.class);
        assertTrue(rateDiscountPolicy instanceof RateDiscountPolicy);
    }

    @Test
    @DisplayName("부모타입으로 모두조회하기")
    void  findAllBeanbyParentType(){
        Map<String, DiscountPolicy> beansOfType = ac.getBeansOfType(DiscountPolicy.class);
        assertEquals(2,beansOfType.size());
        for(String key :beansOfType.keySet()){
            System.out.println("key = " + key+"value"+beansOfType.get(key));
        }
    }

    @Test
    @DisplayName("부모타입 모두 조회하기")
    void findAllBeanByObejectType(){
        Map<String, Object> beansOfType = ac.getBeansOfType(Object.class);
        //iter
        for (String key : beansOfType.keySet()) {

            System.out.println("key = " + key+"value"+beansOfType.get(key));
        }

    }
}
