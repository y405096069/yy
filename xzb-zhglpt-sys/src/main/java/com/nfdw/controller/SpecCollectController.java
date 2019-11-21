package com.nfdw.controller;


import com.nfdw.base.controller.BaseController;
import com.nfdw.core.annotation.Log;
import com.nfdw.core.annotation.Log.LOG_TYPE;
import com.nfdw.entity.SpecCollect;
import com.nfdw.exception.MyException;
import com.nfdw.service.SpecCollectService;
import com.nfdw.util.BeanUtil;
import com.nfdw.util.JsonUtil;
import com.nfdw.util.ReType;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@RequestMapping("/specCollect")
@Controller
public class SpecCollectController extends BaseController {

    @Autowired
    private SpecCollectService specCollectService;

    /**
     * 2019/1/3
     * 区域显示列表
     */

    @GetMapping("/showSpecCollect")
    public String showSpecCollect(Model model) {
        
        return "/specCollect/specCollectList";
    }

    @ApiOperation(value = "/showSpecCollectList", httpMethod = "GET", notes = "展示学院")
    @GetMapping(value = "showSpecCollectList")
    @ResponseBody
    @RequiresPermissions("specCollect:show")
    public ReType showRoleList(SpecCollect specCollect, Model model, String page, String limit) {
        ReType show = specCollectService.show(specCollect, Integer.valueOf(page), Integer.valueOf(limit));
        return show;
    }

    @GetMapping(value = "showAddSpecCollect")
    public String showAddSpecCollect(Model model) {
//        JSONArray jsonArray =specCollectService.getTreeUtil(null);
//        String s = jsonArray.toString();
//        model.addAttribute("menus", jsonArray.toJSONString());
        return "/specCollect/add-specCollect";
    }


    @ApiOperation(value = "/addSpecCollect", httpMethod = "POST", notes = "添加学院")
    @Log(desc = "添加学院")
    @PostMapping(value = "addSpecCollect")
    @ResponseBody
    public JsonUtil addSpecCollect(SpecCollect specCollect) {
        if (StringUtils.isEmpty(specCollect.getName())) {
            JsonUtil.error("学院名称不能为空");
        }
        JsonUtil j = new JsonUtil();
        try {
            specCollect.setUpdateTime(new Date());
            specCollectService.insertSelective(specCollect);
            //操作role-menu data
            j.setMsg("保存成功");

        } catch (MyException e) {
            j.setMsg("保存失败");
            j.setFlag(false);
            e.printStackTrace();
        }
        return j;
    }


    /**
     * 2019/1/9
     * 部门删除，联合查询用户表
     */
    @PostMapping(value = "del")
    @ResponseBody
    public JsonUtil del(Integer id) {
        if (id == null) {
            return JsonUtil.error("获取数据失败");
        }
        JsonUtil j = new JsonUtil();
        try {

            SpecCollect specCollect = specCollectService.selectByPrimaryKey(id);
            Integer specCollectId = specCollect.getId();
            specCollectService.deleteByPrimaryKey(id);
            j.setMsg("删除成功");
        } catch (MyException e) {
            j.setMsg("删除失败");
            j.setFlag(false);
            e.printStackTrace();
        }
        return j;
    }

    @GetMapping(value = "updateSpecCollect")
    public String updateSpecCollect(Integer id, Model model, boolean detail) {
        if (StringUtils.isNotEmpty(String.valueOf(id))) {
            SpecCollect specCollect = specCollectService.selectByPrimaryKey(id);
            model.addAttribute("specCollect", specCollect);
//            JSONArray jsonArray = menuService.getTreeUtil(id);
//            model.addAttribute("menus", jsonArray.toJSONString());
        }
        model.addAttribute("detail", detail);
        return "specCollect/update-specCollect";
    }


    @ApiOperation(value = "/updateSpecCollect", httpMethod = "POST", notes = "更新学院")
    @Log(desc = "更新学院", type = LOG_TYPE.UPDATE)
    @PostMapping(value = "updateSpecCollect")
    @ResponseBody
    public JsonUtil updatespecCollect(SpecCollect specCollect) {
        JsonUtil jsonUtil = new JsonUtil();
        jsonUtil.setFlag(false);
        if (specCollect == null) {
            jsonUtil.setMsg("获取数据失败");
            return jsonUtil;
        }
        try {
            SpecCollect oldspecCollect = specCollectService.selectByPrimaryKey(specCollect.getId());
            BeanUtil.copyNotNullBean(specCollect, oldspecCollect);
            specCollectService.updateByPrimaryKeySelective(oldspecCollect);
            jsonUtil.setFlag(true);
            jsonUtil.setMsg("修改成功");
        } catch (MyException e) {
            e.printStackTrace();
        }
        return jsonUtil;
    }

    
    /**
     * 获取部门列表
     * @return
     */
    @ApiOperation(value = "/showSpecCollectAllList", httpMethod = "GET", notes = "获取部门列表")
    @Log(desc = "获取部门列表", type = LOG_TYPE.UPDATE)
    @GetMapping(value = "showSpecCollectAllList")
    @ResponseBody
    public JsonUtil showSpecCollectAllList() {
        JsonUtil jsonUtil = new JsonUtil();
        jsonUtil.setFlag(false);
        
        try {
        	//List<SpecCollect> depts = specCollectService.showMenuJsonList();
            
            jsonUtil.setFlag(true);
            jsonUtil.setMsg("查询部门列表成功");
            //jsonUtil.setData(depts);
        } catch (MyException e) {
            e.printStackTrace();
        }
        
        return jsonUtil;
    }

}
