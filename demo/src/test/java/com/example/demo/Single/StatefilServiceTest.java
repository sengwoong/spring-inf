package com.example.demo.Single;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

public class StatefilServiceTest {

    static  class TestConfig{
        @Bean
        public statefulService statefulService(){
            return  new statefulService();
        }

    }

    @Test
    void statefulServiceSingleton(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        statefulService bean1 = ac.getBean(statefulService.class);
        statefulService bean2 = ac.getBean(statefulService.class);

        bean1.order("userA",10000);
        bean2.order("userA",20000);
        System.out.println("bean1 = " + bean1.getPrice());


    }
}
