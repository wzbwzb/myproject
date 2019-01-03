package com.myproject.demo.Dto;

import lombok.Data;

@Data
public class InterFaceResponse {
    /*
     * 接口地址
     */
    private String interAddress;

    /*
     * 接口参数：JSON字符串
     */
    private String interData;


}
