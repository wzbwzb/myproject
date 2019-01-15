package com.myproject.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.myproject.demo.Dto.InterFaceResponse;
import com.myproject.demo.entity.InterFace;
import com.myproject.demo.services.InterFaceServices;
import com.myproject.demo.utils.InterTestHttpServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Iterator;
import java.util.Map;

@Controller
public class InterFaceTestController {

    @Autowired
    public InterFaceServices interFaceServices;

    @RequestMapping(value = "/interPost",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String interPost(@RequestBody InterFaceResponse flag){

        String returnValue = "";
        InterTestHttpServer interTestHttpServer = new InterTestHttpServer();
        returnValue = interTestHttpServer.HttpPostofJSONString(flag.getInterAddress(),flag.getInterData());
        return returnValue;
    }

    @RequestMapping(value = "/interGet",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String interGet(@RequestBody InterFaceResponse flag){

        String returnValue = "";
        String[] KEY = null;
        String[] VALUE = null;
        JSONArray jsonArray = JSON.parseArray("["+flag.getInterData()+"]");
//        System.out.println("JSON数组内容："+jsonArray.toString());
//        System.out.println("JSON数组长度："+jsonArray.size());
        //解析JSONArray，取出key和value
        for (Object aJsonArray : jsonArray) {
            JSONObject obj = (JSONObject) JSONObject.toJSON(aJsonArray);//传过来的值的size为1，去掉外层循环
            KEY = new String[obj.size()];
            VALUE = new String[obj.size()];
            int i = 0;
            for (Map.Entry<String, Object> entry : obj.entrySet()) {
                KEY[i] = entry.getKey();
                VALUE[i++] = (String) entry.getValue();
            }
        }

        InterTestHttpServer interTestHttpServer = new InterTestHttpServer();
        returnValue = interTestHttpServer.HttpGetofJSONString(flag.getInterAddress(),KEY,VALUE);
        return returnValue;
    }

    @RequestMapping(value = "/interSave",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String interSave(@RequestBody InterFace saveInterFace){
        interFaceServices.insertInterFace(saveInterFace);
        return "保存成功";
    }
}
