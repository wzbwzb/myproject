package com.myproject.demo.controller;

import redis.clients.jedis.Jedis;

import java.util.List;

public class TestRedis {
    public static void main(String[] args){

        Jedis redis = new Jedis("10.129.220.28", 6377, 6000);
        Jedis redis1 = new Jedis("10.129.220.28", 7130, 6000);
        Jedis redis2 = new Jedis("10.129.220.28", 7131, 6000);
        Jedis redis3 = new Jedis("10.129.220.28", 7132, 6000);

//        redis.ltrim("T_STL_TRANSFER_FRONT:NOTICE_0",-1,0);
//        redis.ltrim("T_STL_TRANSFER_FRONT:NOTICE_1",-1,0);
//        redis.ltrim("T_STL_TRANSFER_FRONT:NOTICE_2",-1,0);
//        redis.ltrim("T_STL_TRANSFER_FRONT:NOTICE_3",-1,0);
//        redis.ltrim("T_STL_TRANSFER_FRONT:NOTICE_4",-1,0);
//        redis.ltrim("T_STL_TRANSFER_FRONT:NOTICE_5",-1,0);
//        redis.ltrim("T_STL_TRANSFER_FRONT:NOTICE_6",-1,0);
//        redis.ltrim("T_STL_TRANSFER_FRONT:NOTICE_7",-1,0);
//
//        redis1.ltrim("T_STL_TRANSFER_FRONT:NOTICE_0",-1,0);
//        redis1.ltrim("T_STL_TRANSFER_FRONT:NOTICE_1",-1,0);
//        redis1.ltrim("T_STL_TRANSFER_FRONT:NOTICE_2",-1,0);
//        redis1.ltrim("T_STL_TRANSFER_FRONT:NOTICE_3",-1,0);
//        redis1.ltrim("T_STL_TRANSFER_FRONT:NOTICE_4",-1,0);
//        redis1.ltrim("T_STL_TRANSFER_FRONT:NOTICE_5",-1,0);
//        redis1.ltrim("T_STL_TRANSFER_FRONT:NOTICE_6",-1,0);
//        redis1.ltrim("T_STL_TRANSFER_FRONT:NOTICE_7",-1,0);
//
//        redis2.ltrim("T_STL_TRANSFER_FRONT:NOTICE_0",-1,0);
//        redis2.ltrim("T_STL_TRANSFER_FRONT:NOTICE_1",-1,0);
//        redis2.ltrim("T_STL_TRANSFER_FRONT:NOTICE_2",-1,0);
//        redis2.ltrim("T_STL_TRANSFER_FRONT:NOTICE_3",-1,0);
//        redis2.ltrim("T_STL_TRANSFER_FRONT:NOTICE_4",-1,0);
//        redis2.ltrim("T_STL_TRANSFER_FRONT:NOTICE_5",-1,0);
//        redis2.ltrim("T_STL_TRANSFER_FRONT:NOTICE_6",-1,0);
//        redis2.ltrim("T_STL_TRANSFER_FRONT:NOTICE_7",-1,0);
//
//        redis3.ltrim("T_STL_TRANSFER_FRONT:NOTICE_0",-1,0);
//        redis3.ltrim("T_STL_TRANSFER_FRONT:NOTICE_1",-1,0);
//        redis3.ltrim("T_STL_TRANSFER_FRONT:NOTICE_2",-1,0);
//        redis3.ltrim("T_STL_TRANSFER_FRONT:NOTICE_3",-1,0);
//        redis3.ltrim("T_STL_TRANSFER_FRONT:NOTICE_4",-1,0);
//        redis3.ltrim("T_STL_TRANSFER_FRONT:NOTICE_5",-1,0);
//        redis3.ltrim("T_STL_TRANSFER_FRONT:NOTICE_6",-1,0);
//        redis3.ltrim("T_STL_TRANSFER_FRONT:NOTICE_7",-1,0);

        System.out.println("redis -------------------------------------");
        System.out.println("T_STL_TRANSFER_FRONT:NOTICE_7 SIZE：" + redis.llen("T_STL_TRANSFER_FRONT:NOTICE_1"));
        List<String> list = redis.lrange("T_STL_TRANSFER_FRONT:NOTICE_1",0,80);
        for (String str: list) {
            System.out.println(str);
        }
        System.out.println("redis1 -------------------------------------");
        System.out.println("T_STL_TRANSFER_FRONT:NOTICE_7 SIZE：" + redis1.llen("T_STL_TRANSFER_FRONT:NOTICE_1"));
        List<String> listRedis1 = redis1.lrange("T_STL_TRANSFER_FRONT:NOTICE_1",0,80);
        for (String str: listRedis1) {
            System.out.println(str);
        }
        System.out.println("redis2 -------------------------------------");
        System.out.println("T_STL_TRANSFER_FRONT:NOTICE_7 SIZE：" + redis2.llen("T_STL_TRANSFER_FRONT:NOTICE_1"));
        List<String> listRedis2 = redis2.lrange("T_STL_TRANSFER_FRONT:NOTICE_1",0,80);
        for (String str: listRedis2) {
            System.out.println(str);
        }
        System.out.println("redis3 -------------------------------------");
        System.out.println("T_STL_TRANSFER_FRONT:NOTICE_7 SIZE：" + redis3.llen("T_STL_TRANSFER_FRONT:NOTICE_1"));
        List<String> listRedis3 = redis3.lrange("T_STL_TRANSFER_FRONT:NOTICE_1",0,80);
        for (String str: listRedis3) {
            System.out.println(str);
        }
    }
}
