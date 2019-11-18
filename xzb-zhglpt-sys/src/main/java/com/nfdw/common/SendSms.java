package com.nfdw.common;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;

public class SendSms {
    private static String Url = "http://106.wx96.com/webservice/sms.php?method=Submit";

    public String sendSMS(String phone,String content) throws MalformedURLException, UnsupportedEncodingException {
        HttpClient client = new HttpClient();
        PostMethod method = new PostMethod(Url);
        client.getParams().setContentCharset("UTF-8");
        method.setRequestHeader("ContentType","application/x-www-form-urlencoded;charset=UTF-8");
        NameValuePair[] data = {//提交短信
                new NameValuePair("account", "C21627424"), //用户名请登录用户中心->验证码、通知短信->帐户及签名设置->APIID
                new NameValuePair("password", "72090d6d9b41bafeb1c906c5e94607bc"),  //查看密码请登录用户中心->验证码、通知短信->帐户及签名设置->APIKEY
                new NameValuePair("mobile", phone),
                new NameValuePair("content", "您的验证码是："+ content + "。请不要把验证码泄露给其他人。"),
        };
        method.setRequestBody(data);
        try {
            client.executeMethod(method);
            String SubmitResult =method.getResponseBodyAsString();
            //System.out.println(SubmitResult);
            Document doc = DocumentHelper.parseText(SubmitResult);
            Element root = doc.getRootElement();
            String code = root.elementText("code");
            String msg = root.elementText("msg");
            String smsid = root.elementText("smsid");
            System.out.println(code);
            System.out.println(msg);
            System.out.println(smsid);
            if("2".equals(code)){
                System.out.println("短信提交成功");
            }
        } catch (HttpException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (DocumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return content;
    }
}
