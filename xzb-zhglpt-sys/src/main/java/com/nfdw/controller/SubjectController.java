package com.nfdw.controller;

import com.nfdw.core.annotation.Log;
import com.nfdw.entity.SpecCollect;
import com.nfdw.entity.SpecManagement;
import com.nfdw.entity.Subject;
import com.nfdw.exception.MyException;
import com.nfdw.service.SubjectService;
import com.nfdw.util.BeanUtil;
import com.nfdw.util.JsonUtil;
import com.nfdw.util.ReType;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletRequest;
import java.util.Date;
import java.util.List;

/**
 * @Auther: EagleJunBin
 * @Date: 2019/11/19 科目表
 * @Description:
 */
@Controller
@RequestMapping(value = "/subject")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @GetMapping(value = "goSubject")
    public String goSubject(Model model, ServletRequest request){
        return "/system/subject/subjectList";
    }

    @GetMapping(value = "showSubjectList")
    @ResponseBody
    public ReType showSpecList(Model model, Subject subject, String page, String limit) {
        return subjectService.show(subject,Integer.valueOf(page), Integer.valueOf(limit));
    }


    @GetMapping(value = "showAddSubjectList")
    public String showAddSpecCollect(Model model) {
//        JSONArray jsonArray =specCollectService.getTreeUtil(null);
//        String s = jsonArray.toString();
//        model.addAttribute("menus", jsonArray.toJSONString());
        //查询所有的专业
        List<SpecManagement> specList = subjectService.selectSpecManagementById();
        model.addAttribute("specList",specList);
        return "/system/subject/add-subject";
    }


    @ApiOperation(value = "/addSubject", httpMethod = "POST", notes = "添加科目")
    @Log(desc = "添加科目")
    @PostMapping(value = "addSubject")
    @ResponseBody
    public JsonUtil addSubject(Subject subject) {
        if (StringUtils.isEmpty(subject.getSubject_name())) {
            JsonUtil.error("专业科目不能为空");
        }
        JsonUtil j = new JsonUtil();
        try {
            subject.setUpdate_time(new Date());
            subjectService.insertSelective(subject);
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

            Subject subject = subjectService.selectByPrimaryKey(id);
            Integer specCollectId = subject.getId();
            subjectService.deleteByPrimaryKey(id);
            j.setMsg("删除成功");
        } catch (MyException e) {
            j.setMsg("删除失败");
            j.setFlag(false);
            e.printStackTrace();
        }
        return j;
    }

    @GetMapping(value = "updateSpecManagement")
    public String updateSubject(Integer id, Model model, boolean detail) {
        if (StringUtils.isNotEmpty(String.valueOf(id))) {
            Subject subject = subjectService.selectByPrimaryKey(id);
            model.addAttribute("subject", subject);
//            JSONArray jsonArray = menuService.getTreeUtil(id);
//            model.addAttribute("menus", jsonArray.toJSONString());
        }
        model.addAttribute("detail", detail);
        return "system/subject/update-subject";
    }


    @ApiOperation(value = "/updateSpecManagement", httpMethod = "POST", notes = "更新科目")
    @Log(desc = "更新科目", type = Log.LOG_TYPE.UPDATE)
    @PostMapping(value = "updateSpecManagement")
    @ResponseBody
    public JsonUtil updateSpecManagement(Subject subject) {
        JsonUtil jsonUtil = new JsonUtil();
        jsonUtil.setFlag(false);
        if (subject == null) {
            jsonUtil.setMsg("获取数据失败");
            return jsonUtil;
        }
        try {
            Subject oldSubject = subjectService.selectByPrimaryKey(subject.getId());
            BeanUtil.copyNotNullBean(subject, oldSubject);
            subjectService.updateByPrimaryKeySelective(oldSubject);
            jsonUtil.setFlag(true);
            jsonUtil.setMsg("修改成功");
        } catch (MyException e) {
            e.printStackTrace();
        }
        return jsonUtil;
    }


}
