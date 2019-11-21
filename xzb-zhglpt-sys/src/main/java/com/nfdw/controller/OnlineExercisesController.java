package com.nfdw.controller;

import com.nfdw.core.annotation.Log;
import com.nfdw.entity.OnlineExercises;
import com.nfdw.exception.MyException;
import com.nfdw.service.OnlineExercisesService;
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

@Controller
@RequestMapping(value = "/onlineExercises")
public class OnlineExercisesController {

    @Autowired
    private OnlineExercisesService onlineExercisesService;

    @GetMapping(value = "showOnlineExercises")
    /*@RequiresPermissions("user:show")*/
    public String showNotice(Model model) {
        return "/system/onlineExercises/onlineExercises";//报名公告
    }

    @GetMapping(value = "showOnlineExercisesList")
    @ResponseBody
   /* @RequiresPermissions("user:show")*/
    public ReType showNotice(Model model, OnlineExercises onlineExercises, String page, String limit) {
        return onlineExercisesService.show(onlineExercises, Integer.valueOf(page), Integer.valueOf(limit));
    }

    @GetMapping(value = "showAddOnlineExercisesList")
    public String goAddNotice() {

        return "/system/onlineExercises/add-onlineExercises";
    }


    @ApiOperation(value = "/addOnlineExercisesList", httpMethod = "POST", notes = "添加公告")
    @Log(desc = "添加公告")
    @PostMapping(value = "addOnlineExercisesList")
    @ResponseBody
    public JsonUtil addNotice(OnlineExercises onlineExercises, HttpServletRequest request) {
        JsonUtil j = new JsonUtil();
        try {
            Date date=new Date();
            onlineExercises.setCreateTime(date);
            int count = onlineExercisesService.insert(onlineExercises);
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

    @GetMapping(value = "updateOnlineExercises")
    public String goUpdateNotice(String id, Model model, boolean detail) {
        if (StringUtils.isNotEmpty(id)) {
            OnlineExercises onlineExercises= onlineExercisesService.selectGetByPrimaryKey(id);
            model.addAttribute("u", onlineExercises);
        }
        model.addAttribute("detail", detail);
        return "system/onlineExercises/update-onlineExercises";
    }



    @ApiOperation(value = "/updateOnlineExercises", httpMethod = "POST", notes = "更新公告")
    @Log(desc = "更新公告")
    @PostMapping(value = "updateOnlineExercises")
    @ResponseBody
    @Transactional
    public JsonUtil updateNotice(OnlineExercises onlineExercises) {
        JsonUtil jsonUtil = new JsonUtil();
        jsonUtil.setFlag(false);
        if (onlineExercises == null) {
            jsonUtil.setMsg("获取数据失败");
            return jsonUtil;
        }
        try {
            int count=onlineExercisesService.updateById(onlineExercises);
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
            int count = onlineExercisesService.deleteById(id);
            if (count > 0) {
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
