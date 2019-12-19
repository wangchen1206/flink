//package com.flink.flinksource;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
///**
// * @Author: cc
// * @Date: 2019/10/31 19:25
// */
//@Component
//public class KafkaSourceTask2 {
//
//    @Autowired
//    private KafkaTemplate<String,Object> kafkaTemplate;
//
//    @Scheduled(initialDelay = 1000,fixedDelay = 5000)
//    public void send1(){
//        System.out.println("------------------------- first");
//        Foo foo = new Foo("send1",1);
//        String message = "this is a kafka source4  ";
//        this.kafkaTemplate.send("topic5",foo);
//    }
//
//    @Scheduled(initialDelay = 2000,fixedDelay = 5000)
//    public void send2(){
//        System.out.println("------------------------- second");
//        Foo foo = new Foo("send2",2);
//        String message = "this is a kafka source4  ";
//        this.kafkaTemplate.send("topic5",foo);
//    }
//
//    @Scheduled(initialDelay = 3000,fixedDelay = 5000)
//    public void send3(){
//        System.out.println("------------------------- third");
//        Foo foo = new Foo("send3",3);
//        String message = "this is a kafka source4  ";
//        this.kafkaTemplate.send("topic5",foo);
//    }
//
//    @Scheduled(initialDelay = 4000,fixedDelay = 5000)
//    public void send4(){
//        System.out.println("------------------------- forth");
//        Foo foo = new Foo("send4",4);
//        String message = "this is a kafka source4  ";
//        this.kafkaTemplate.send("topic5",foo);
//    }
//}
