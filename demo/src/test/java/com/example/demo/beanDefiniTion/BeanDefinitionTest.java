package com.example.demo.beanDefiniTion;

import com.example.demo.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanDefinitionTest {
   AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);


   @Test
   @DisplayName("빈설정메타데이터확인")
   void fondApplicationBean()
   {
      String[] bean =  ac.getBeanDefinitionNames();
       for (String s : bean) {
           BeanDefinition beanDefinition = ac.getBeanDefinition(s);
           if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION){
               System.out.println("beanDefinition = " + beanDefinition+ "bean"+bean);
           }
       }
   }
}
