package com.quaint.sp.javabase.netpack;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.Objects;

/**
 * @Description: http post 测试
 * @author: qi cong
 * @Date: Created in 2019/11/18 17:28
 */
public class HttpUrlTest {


    /**
     * 第三方实现
     * @param url
     */
    public static String getTest(String url){

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);

        try {
            CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
            int status = httpResponse.getStatusLine().getStatusCode();
            if (status == HttpStatus.SC_OK){
                HttpEntity responseEntity = httpResponse.getEntity();
                String jsonString = EntityUtils.toString(responseEntity);
                return jsonString;
            } else{
                System.err.println("请求返回:"+status+"("+url+")");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String postTest(String url, JSONObject object){

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        httpPost.setHeader("Accept", "application/json");
        httpPost.setHeader("Content-Type", "application/json");

        String charSet = "UTF-8";
        StringEntity entity = new StringEntity(object.toJSONString(), charSet);
        httpPost.setEntity(entity);
        CloseableHttpResponse httpResponse = null;
        try {
            httpResponse = httpClient.execute(httpPost);
            int status = httpResponse.getStatusLine().getStatusCode();
            if (status == HttpStatus.SC_OK){
                HttpEntity responseEntity = httpResponse.getEntity();
                System.out.println(responseEntity.toString());
                String jsonString = EntityUtils.toString(responseEntity);
                System.out.println(jsonString);
                return jsonString;
            } else{
                System.err.println("请求返回:"+status+"("+url+")");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (httpResponse!=null){
                try {
                    httpResponse.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }


    public static void main(String[] args) {

        String url = "https://corpapi.ppdai.com/admin/sendEmail?cardNo=%s";
//        System.out.println(getTest(String.format(url,"500000")));
        String format = getTest(String.format(url, "500000"));
        System.out.println(format);
        JSONObject jsonObject = JSONObject.parseObject(format);
        System.out.println(Objects.isNull(jsonObject.getString("data")));
    }

}
