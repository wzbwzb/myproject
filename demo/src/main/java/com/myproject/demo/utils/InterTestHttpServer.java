package com.myproject.demo.utils;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class InterTestHttpServer {

    private CloseableHttpClient httpClient = HttpClients.createDefault();
    private String entityStr = null;
    private CloseableHttpResponse response = null;

    /**
     * get请求
     * @param url 接口接收的参数地址
     * @param jsonParams 接口参数
     */
    public String HttpGetofJSONString(String url,String jsonParams) {

        try {
            URIBuilder uriBuilder = new URIBuilder(url);
            List<NameValuePair> params = new LinkedList<>();
            params.add(new BasicNameValuePair("fromProvinceName","湖南省"));
            params.add(new BasicNameValuePair("fromCityName","长沙市"));
            params.add(new BasicNameValuePair("toProvinceName","上海"));
            params.add(new BasicNameValuePair("toCityName","上海市"));
            params.add(new BasicNameValuePair("effectiveTypeCode",""));
            params.add(new BasicNameValuePair("priceTypeCode",""));
            params.add(new BasicNameValuePair("weight","7"));
            params.add(new BasicNameValuePair("auth","eIjvyuhFHrrm9jkLmxwqYw=="));
            uriBuilder.addParameters(params);
            HttpGet httpGet = new HttpGet(uriBuilder.build());

            response = httpClient.execute(httpGet);
            System.out.println("成功");
            HttpEntity entity = response.getEntity();
            // 使用Apache提供的工具类进行转换成字符串
            entityStr = EntityUtils.toString(entity, "UTF-8");
            System.out.println(entityStr);
            httpClient.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  entityStr;
    }

    /**
     * POST请求
     * @param url 接口接收的参数地址
     * @param jsonParams 接口参数,content文本
     */
    public String HttpPostofJSONString(String url,String jsonParams){

        HttpPost httpPost = new HttpPost(url);
        RequestConfig requestConfig = RequestConfig.custom().
                setConnectTimeout(180 * 1000).setConnectionRequestTimeout(180 * 1000)
                .setSocketTimeout(180 * 1000).setRedirectsEnabled(true).build();

        httpPost.setConfig(requestConfig);
        httpPost.setHeader("Content-Type","application/json");  //设置格式

        //请求开始-------------------------
        try {
            httpPost.setEntity(new StringEntity(jsonParams,ContentType.create("application/json", "utf-8")));//设置参数
            //System.out.println("request parameters" + EntityUtils.toString(httpPost.getEntity()));//检验参数是否设置成功
            HttpResponse response = httpClient.execute(httpPost);//请求

//            System.out.println(" code:"+response.getStatusLine().getStatusCode());//返回状态码
//            System.out.println("doPostForInfobipUnsub response"+response.getStatusLine().toString());//返回状态信息

            HttpEntity entity = response.getEntity();
            // 使用Apache提供的工具类进行转换成字符串
            entityStr = EntityUtils.toString(entity, "UTF-8");
//            System.out.println(entityStr);//返回值

//            return String.valueOf(response.getStatusLine().getStatusCode());
            return entityStr;
        } catch (Exception e) {
            e.printStackTrace();
            return "post failure :caused by-->" + e.getMessage().toString();
        }finally {
            try{
                httpPost.releaseConnection();
            }catch (Exception e){
                e.printStackTrace();
            }
            //            if(null != httpClient){
//                try {
//                    httpClient.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
        }
    }
}
