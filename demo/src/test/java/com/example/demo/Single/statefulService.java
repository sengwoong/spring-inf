package com.example.demo.Single;

public class statefulService {

    private  int price;
    public  void order(String name, int price){
        System.out.println("name = " + name+"price"+price);
        this.price = price;
//        bean1.order("userA",10000);
//        bean2.order("userA",20000);
        //라고하였을떄 중복처리가안됌 그래서 싱글톤은 값을바꾸면안좋
    }
    public int orde2(String name, int price){
        System.out.println("name = " + name+"price"+price);

        return price;
//지역변수로하면 따로 넣으면
    }

    public int getPrice(){
        return price;
    }
}
