package com.nfdw.controller;

import com.nfdw.core.annotation.Log;
import com.nfdw.entity.ApplicationAnnoun;
import com.nfdw.exception.MyException;
import com.nfdw.service.ApplicationAnnounService;
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
@RequestMapping(value = "/applicationAnnoun")
public class ApplicationAnnounController {


    @Autowired
    private ApplicationAnnounService applicationAnnounService;


    @GetMapping(value = "showApplicationAnnoun")
    /*@RequiresPermissions("user:show")*/
    public String showNotice(Model model) {
        return "/system/applicationAnnoun/applicationAnnoun";//报名公告
    }

    @GetMapping(value = "showApplicationAnnounList")
    @ResponseBody
   /* @RequiresPermissions("user:show")*/
    public ReType showNotice(Model model, ApplicationAnnoun applicationAnnoun, String page, String limit) {
        return applicationAnnounService.show(applicationAnnoun, Integer.valueOf(page), Integer.valueOf(limit));
    }

    @GetMapping(value = "showAddApplicationAnnounList")
    public String goAddNotice(Model model) {
        List<ApplicationAnnoun> applicationAnnouns =applicationAnnounService.showMenuJsonList();
        model.addAttribute("ApplicationAnnouns",applicationAnnouns);
        return "/system/applicationAnnoun/add-applicationAnnoun";
    }


    @ApiOperation(value = "/addApplicationAnnounList", httpMethod = "POST", notes = "添加公告")
    @Log(desc = "添加公告")
    @PostMapping(value = "addApplicationAnnounList")
    @ResponseBody
    public JsonUtil addNotice(ApplicationAnnoun applicationAnnoun, HttpServletRequest request) {
        JsonUtil j = new JsonUtil();
        try {
            Date date=new Date();
            applicationAnnoun.setCreateTime(date);
            int count = applicationAnnounService.insert(applicationAnnoun);
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

    @GetMapping(value = "updateApplicationAnnoun")
    public String goUpdateNotice(String id, Model model, boolean detail) {
        if (StringUtils.isNotEmpty(id)) {
            ApplicationAnnoun applicationAnnoun= applicationAnnounService.selectGetByPrimaryKey(id);
            model.addAttribute("u", applicationAnnoun);
        }
        model.addAttribute("detail", detail);
        return "system/applicationAnnoun/update-applicationAnnoun";
    }



    @ApiOperation(value = "/updateApplicationAnnoun", httpMethod = "POST", notes = "更新公告")
    @Log(desc = "更新公告")
    @PostMapping(value = "updateApplicationAnnoun")
    @ResponseBody
    @Transactional
    public JsonUtil updateNotice(ApplicationAnnoun applicationAnnoun) {
        JsonUtil jsonUtil = new JsonUtil();
        jsonUtil.setFlag(false);
        if (applicationAnnoun == null) {
            jsonUtil.setMsg("获取数据失败");
            return jsonUtil;
        }
        try {
            int count=applicationAnnounService.updateById(applicationAnnoun);
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
            int count = applicationAnnounService.deleteById(id);
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
