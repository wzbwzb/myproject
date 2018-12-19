/*
 * Copyright © 2015-2026 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * @since 0.0.1
 */

package com.myproject.demo.services;


import com.alibaba.fastjson.JSON;
import com.dingtalk.chatbot.DingtalkChatbotClient;
import com.dingtalk.chatbot.SendResult;
import com.dingtalk.chatbot.message.TextMessage;
import com.myproject.demo.Dto.TodayThingsResponse;
import com.myproject.demo.dao.TodayThingsDao;
import com.myproject.demo.entity.Schedule;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Service
public class TodayThingsService {

    @Resource
    private TodayThingsDao todayThingsDao;

    private static String HTTP_URL="https://oapi.dingtalk.com/robot/send?access_token=f1de16f6c55246727395a210696f01c08d4795ae0182999b8def82e43eca0212";

    public String sendMessage(){

        String code="";
        DingtalkChatbotClient dingtalkChatbotClient = new DingtalkChatbotClient();
        TextMessage msg = new TextMessage("") ;
        msg.setText("我就是我，是不一样的烟火");
        msg.setIsAtAll(false);
        List list = new ArrayList();
        list.add("15973754415");
        msg.setAtMobiles(list);

        try {
            SendResult sendResult=dingtalkChatbotClient.send(HTTP_URL,msg);
            if(sendResult.isSuccess()){
                code="推送成功";
            }else{
                code="推送失败";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return code;
    }


    public TodayThingsResponse getAllSchedule(){
        TodayThingsResponse response = new TodayThingsResponse();
        List<Schedule> scheduleList = todayThingsDao.getAllSchedule();
        response.setData(JSON.parseArray(JSON.toJSONString(scheduleList)));
        response.setCode("200");
        return response;
    }
}
