package com.nfdw;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.nfdw.entity.SpecCollectEntity;
import com.nfdw.entity.SpecEntity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Auther: EagleJunBin
 * @Date: 2019/11/25
 * @Description:
 */
public class JSONToObject {

    public static void main(String[] args) {
       // String path = "http://dapi.gzhu.edu.cn:8012/datacenter/core/cpi/dhM5Fol0?name=JYGLXTKF&token=FIRIhEAw&page_index=1&page_count=500";
        String path = "http://dapi.gzhu.edu.cn:8012/datacenter/core/cpi/Vwch0Eg0?name=JYGLXTKF&token=FIRIhEAw&page_index=1&page_count=500";
        StringBuilder sb = new StringBuilder();
        try {
            URL url = new URL(path);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
            String line;

            while ((line = br.readLine()) != null) {// 循环读取流

                sb.append(line);

            }

            br.close();// 关闭流
            connection.disconnect();// 断开连接

            try {
                JSONObject result=  JSONObject.parseObject(sb.toString());

                List<SpecCollectEntity> specEntities=JSONArray.parseArray(result.getString("result"),SpecCollectEntity.class);

                System.out.println(specEntities);
            }catch (Exception ex){
                ex.printStackTrace();
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
            System.out.println("失败!");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("失败!");
        }

    }
}
