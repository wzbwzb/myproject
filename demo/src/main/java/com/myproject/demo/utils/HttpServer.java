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

package com.myproject.demo.utils;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.LinkedList;
import java.util.List;


public class HttpServer {

    CloseableHttpClient httpClient = HttpClients.createDefault();

    String entityStr = null;

    CloseableHttpResponse response = null;

    private  static final String SEND_KEY="7523-bce429bd924dde6809c469fb601e740b";

    public String weChatSend(String title, String message){

        try {
            URIBuilder uriBuilder = new URIBuilder("https://pushbear.ftqq.com/sub");
            List<NameValuePair> params = new LinkedList<>();
            params.add(new BasicNameValuePair("sendkey",SEND_KEY));
            params.add(new BasicNameValuePair("text",title));
            params.add(new BasicNameValuePair("desp",message));
            uriBuilder.addParameters(params);
            HttpGet httpGet = new HttpGet(uriBuilder.build());
            response = httpClient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            // 使用Apache提供的工具类进行转换成字符串
            entityStr = EntityUtils.toString(entity, "UTF-8");
        } catch (URISyntaxException e) {
            System.out.println("Url解析出错");
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            System.out.println("http协议出错");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("IO异常");
            e.printStackTrace();
        }finally {
            if (null!=response){
                try {
                    response.close();
                } catch (IOException e) {
                    System.out.println("释放链接出错");
                    e.printStackTrace();
                }
            }
        }

        return entityStr;
    }
}
