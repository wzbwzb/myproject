package com.myproject.demo.controller;

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

@Controller
public class InterFaceTestController {

    @Autowired
    public InterFaceServices interFaceServices;

    @RequestMapping(value = "/interTest",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String schedule(@RequestBody InterFaceResponse flag){

        String returnValue = "";
        InterTestHttpServer interTestHttpServer = new InterTestHttpServer();
        returnValue = interTestHttpServer.HttpPostofJSONString(flag.getInterAddress(),flag.getInterData());
        return returnValue;
    }

    @RequestMapping(value = "/interSave",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String interSave(@RequestBody InterFace saveInterFace){
        interFaceServices.insertInterFace(saveInterFace);
        return "保存成功";
    }
}
