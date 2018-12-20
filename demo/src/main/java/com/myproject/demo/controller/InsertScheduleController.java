package com.myproject.demo.controller;

import com.myproject.demo.entity.InsertSchedule;
import com.myproject.demo.services.InsertScheduleServices;
import com.myproject.demo.services.UserLoginServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;


@Controller
public class InsertScheduleController {

    @Autowired
    public InsertScheduleServices insertScheduleServices;

    public InsertSchedule insertSchedule;

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
}
