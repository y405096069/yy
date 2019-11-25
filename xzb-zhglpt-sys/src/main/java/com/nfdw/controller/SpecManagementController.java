package com.nfdw.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.nfdw.core.annotation.Log;
import com.nfdw.entity.SpecCollect;
import com.nfdw.entity.SpecCollectEntity;
import com.nfdw.entity.SpecEntity;
import com.nfdw.entity.SpecManagement;
import com.nfdw.exception.MyException;
import com.nfdw.service.SpecEntityService;
import com.nfdw.service.SpecManagementService;
import com.nfdw.util.JsonUtil;
import com.nfdw.util.ReType;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * @Auther: EagleJunBin
 * @Date: 2019/11/18
 * @Description:
 */
@Controller
@RequestMapping("/spec_manage")
public class SpecManagementController {


    @Autowired
    private SpecManagementService service;

    @Autowired
    private SpecEntityService specEntityService;

    @GetMapping("/goSpec")
    public String showSpecCollect(Model model) {

        return "/system/spec/specManagementList";
    }

    @GetMapping(value = "showSpecList")
    @ResponseBody
    public ReType showSpecList(Model model, SpecManagement specManagement, String page, String limit) {

        return service.show(specManagement,Integer.valueOf(page), Integer.valueOf(limit));
    }


    @GetMapping(value = "showAddSpecManagement")
    public String showAddSpecCollect(Model model) {
//        JSONArray jsonArray =specCollectService.getTreeUtil(null);
//        String s = jsonArray.toString();
//        model.addAttribute("menus", jsonArray.toJSONString());
        List<SpecCollect> specCollectList = service.selectSpecCollect();
        List<SpecManagement> specManagementList = service.selectSpecManagement();
        model.addAttribute("specCollectList",specCollectList);
        model.addAttribute("specManagementList",specManagementList);
        return "/system/spec/add-specManagement";
    }


    @ApiOperation(value = "/addSpecManagement", httpMethod = "POST", notes = "添加专业")
    @Log(desc = "添加专业")
    @PostMapping(value = "addSpecManagement")
    @ResponseBody
    public JsonUtil addSpecCollect(SpecManagement specManagement) {
        if (StringUtils.isEmpty(specManagement.getName())) {
            JsonUtil.error("专业名称不能为空");
        }
        JsonUtil j = new JsonUtil();

        //String path = "http://dapi.gzhu.edu.cn:8012/datacenter/core/cpi/Vwch0Eg0?name=JYGLXTKF&token=FIRIhEAw&page_index=1&page_count=500";
  /*      String path = "http://dapi.gzhu.edu.cn:8012/datacenter/core/cpi/dhM5Fol0?name=JYGLXTKF&token=FIRIhEAw&page_index=1&page_count=500";
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
                com.alibaba.fastjson.JSONObject result=  JSONObject.parseObject(sb.toString());

                List<SpecEntity> specEntities= JSONArray.parseArray(result.getString("result"),SpecEntity.class);

                SpecManagement spec = new SpecManagement();
                for (SpecEntity entity : specEntities) {

                      //specEntityService.add(entity);
                    String zymc = entity.getZYMC();
                    String zyh = entity.getZYH();
                    spec.setCode(zyh);
                    spec.setName(zymc);
                    service.add(spec);
                }

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
        }*/
        try {
            specManagement.setUpdate_time(new Date());
            service.insertSelective(specManagement);
            //操作role-menu data
            j.setMsg("保存成功");

        } catch (MyException e) {
            j.setMsg("保存失败");
            j.setFlag(false);
            e.printStackTrace();
        }
        return j;
    }

    @PostMapping(value = "del")
    @ResponseBody
    public JsonUtil del(Integer id) {
        if (id == null) {
            return JsonUtil.error("获取数据失败");
        }
        JsonUtil j = new JsonUtil();
        try {

            SpecManagement specManagement = service.selectByPrimaryKey(id);
            Integer specCollectId = specManagement.getId();
            service.deleteByPrimaryKey(id);
            j.setMsg("删除成功");
        } catch (MyException e) {
            j.setMsg("删除失败");
            j.setFlag(false);
            e.printStackTrace();
        }
        return j;
    }


    @GetMapping(value = "updateSpecManagement")
    public String updateSpecCollect(Integer id, Model model, boolean detail) {
        if (StringUtils.isNotEmpty(String.valueOf(id))) {
            SpecManagement specManagement = service.selectByPrimaryKey(id);
            model.addAttribute("specManagement", specManagement);
//            JSONArray jsonArray = menuService.getTreeUtil(id);
//            model.addAttribute("menus", jsonArray.toJSONString());
        }
        model.addAttribute("detail", detail);
        return "system/spec/update-specManagement";
    }




}
