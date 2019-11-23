package com.nfdw.controller;

import com.nfdw.core.annotation.Log;
import com.nfdw.entity.EnrolmentCharter;
import com.nfdw.exception.MyException;
import com.nfdw.service.EnrolmentCharterService;
import com.nfdw.util.JsonUtil;
import com.nfdw.util.ReType;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/enrolmentCharter")
public class EnrolmentCharterController {

    @Autowired
    private EnrolmentCharterService enrolmentCharterService;


    @GetMapping(value = "showEnrolmentCharter")
    /*@RequiresPermissions("user:show")*/
    public String showNotice(Model model) {
        return "/system/enrolmentCharter/enrolmentCharterList";//招生公告
    }



    //跳学生端主页公告
    @GetMapping(value = "showStuEnrolmentCharter")
    /*@RequiresPermissions("user:show")*/
    public String showStuNotice(Model model) {
        List<EnrolmentCharter> enroList = enrolmentCharterService.getAll();
        System.err.println(enroList);
        model.addAttribute("enroList",enroList);
        return "/student/enrolmentCharter";//招生公告
    }


    @GetMapping(value = "showEnrolmentCharterList")
    @ResponseBody
   /* @RequiresPermissions("user:show")*/
    public ReType showNotice(Model model,  EnrolmentCharter enrolmentCharter, String page, String limit) {
        return enrolmentCharterService.show(enrolmentCharter, Integer.valueOf(page), Integer.valueOf(limit));
    }

    @GetMapping(value = "showAddEnrolmentCharterList")
    public String goAddNotice(Model model) {
        List<EnrolmentCharter> enrolmentCharters = enrolmentCharterService.showMenuJsonList();
        model.addAttribute("enrolmentCharters",enrolmentCharters);
        return "/system/enrolmentCharter/add-enrolmentCharter";
    }


    @ApiOperation(value = "/addEnrolmentCharterList", httpMethod = "POST", notes = "添加公告")
    @Log(desc = "添加公告")
    @PostMapping(value = "addEnrolmentCharterList")
    @ResponseBody
    public JsonUtil addNotice(EnrolmentCharter enrolmentCharter, HttpServletRequest request) {
        JsonUtil j = new JsonUtil();
        try {
            Date date=new Date();
            enrolmentCharter.setCreateTime(date);
            int count = enrolmentCharterService.add(enrolmentCharter);
            if(count > 0){
                j.setMsg("保存成功");
            }
        } catch (MyException e) {
            j.setMsg("保存失败");
            j.setFlag(false);
            e.printStackTrace();
        }
        return j;
    }

    @GetMapping(value = "updateEnrolmentCharter")
    public String goUpdateNotice(String id, Model model, boolean detail) {
        if (StringUtils.isNotEmpty(id)) {
            EnrolmentCharter  enrolmentCharter= enrolmentCharterService.selectByPrimaryKey1(id);
            model.addAttribute("u", enrolmentCharter);
        }
        model.addAttribute("detail", detail);
        return "system/enrolmentCharter/update-enrolmentCharter";
    }
    @GetMapping(value = "updateEnrolmentCharter1")
    public String goUpdateNotice1(String id, Model model, boolean detail) {
        if (StringUtils.isNotEmpty(id)) {
            EnrolmentCharter  enrolmentCharter= enrolmentCharterService.selectByPrimaryKey1(id);
            model.addAttribute("u", enrolmentCharter);
        }
        model.addAttribute("detail", detail);
        return "system/enrolmentCharter/update-enrolmentCharter1";
    }


    @ApiOperation(value = "/updateEnrolmentCharter", httpMethod = "POST", notes = "更新公告")
    @Log(desc = "更新公告")
    @PostMapping(value = "updateEnrolmentCharter")
    @ResponseBody
    @Transactional
    public JsonUtil updateNotice( EnrolmentCharter enrolmentCharter) {
        JsonUtil jsonUtil = new JsonUtil();
        jsonUtil.setFlag(false);
        if (enrolmentCharter == null) {
            jsonUtil.setMsg("获取数据失败");
            return jsonUtil;
        }
        try {
            int count=enrolmentCharterService.updateById(enrolmentCharter);
            if (count>0){
                jsonUtil.setFlag(true);
                jsonUtil.setMsg("修改成功");
            }
            //throw  new MyException("错误");
        } catch (MyException e) {
            e.printStackTrace();
        }
        return jsonUtil;
    }


    @ApiOperation(value = "/del", httpMethod = "POST", notes = "删除通告")
    @Log(desc = "删除通告")
    @PostMapping(value = "del")
    @ResponseBody
    /*@RequiresPermissions("role:del")*/
    public JsonUtil del(String id) {
        if (StringUtils.isEmpty(id)) {
            return JsonUtil.error("获取数据失败");
        }
        JsonUtil j = new JsonUtil();
        try {
            int count = enrolmentCharterService.deleteById(id);
            if (count > 0){
                j.setMsg("删除成功");
            }
        } catch (MyException e) {
            j.setMsg("删除失败");
            j.setFlag(false);
            e.printStackTrace();
        }
        return j;
    }



}
