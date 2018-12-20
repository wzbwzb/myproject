package com.myproject.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.myproject.demo.Dto.BaseResponse;
import com.myproject.demo.entity.DayTask;
import com.myproject.demo.entity.InsertSchedule;
import com.myproject.demo.services.InsertScheduleServices;
import com.myproject.demo.services.UserLoginServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Controller
public class InsertScheduleController {

    @Autowired
    public InsertScheduleServices insertScheduleServices;

    public InsertSchedule insertSchedule;
    public DayTask dayTask;

    @RequestMapping(value = "/schedule",method = {RequestMethod.GET,RequestMethod.POST})
    public String schedule(){
        return "/today/schedule";
    }

    @RequestMapping(value = "/scheduleMake",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String scheduleMake(HttpServletRequest request){

        String time = request.getParameter("time");
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String type = request.getParameter("type");
        String status = "0";

        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String create_time = simpleDateFormat.format(date);

        insertSchedule = new InsertSchedule();
        insertSchedule.setType(Integer.parseInt(type));
        insertSchedule.setTitle(title);
        insertSchedule.setContent(content);
        insertSchedule.setCreate_time(create_time);
        insertSchedule.setFinish_time(time);
        insertSchedule.setStatus(status);

        try {
            insertScheduleServices.insertSchedule(insertSchedule);

        } catch (Exception e) {
            e.printStackTrace();
        }
        insertSchedule = null;
        return "添加成功";
    }

    @RequestMapping(value = "/chooseTask",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public BaseResponse chooseTask(HttpServletRequest request){

        BaseResponse baseResponse = new BaseResponse();
        String title = request.getParameter("title");

        dayTask = new DayTask();
        dayTask.setTitle(title);

        List<DayTask> list = insertScheduleServices.selectDayTask(dayTask);

        baseResponse.setData(JSON.parseArray(JSON.toJSONString(list)));
//        System.out.println(list.toString());
        baseResponse.setMsg("查找成功");
        baseResponse.setCode("200");


        return  baseResponse;
    }
}
