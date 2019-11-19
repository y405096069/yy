package com.nfdw.controller;

import com.nfdw.core.annotation.Log;
import com.nfdw.entity.*;
import com.nfdw.exception.MyException;
import com.nfdw.service.ExaminationService;
import com.nfdw.service.Infor_CollectionService;
import com.nfdw.util.JsonUtil;
import com.nfdw.util.ReType;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Auther: EagleJunBin
 * @Date: 2019/11/12
 * @Description: 考试表
 */
@RequestMapping("/examination")
@Controller
public class ExaminationController {

    @Autowired
    ExaminationService examinationService;

    @Autowired
    Infor_CollectionService collectionService;

    @GetMapping(value = "/showExamination")
    public String showExamination(Model model){
       // System.out.println("6666");

        return "/system/examination/examinationList";
    }

    @GetMapping(value = "showExaminationList")
    @ResponseBody
    /*@RequiresPermissions("user:show")*/
    public ReType showExamination(Model model, Examination examination, String page, String limit) {
        ReType show = examinationService.show(examination, Integer.valueOf(page), Integer.valueOf(limit));
        System.out.println("页面显示数据："+show);
        return show;
    }

  /*  @GetMapping(value = "/test")
    public void test(){
        System.out.println("6666");
    }*/


  /*  @ApiOperation(value = "/showExaminationList", httpMethod = "GET", notes = "考试管理")
    @GetMapping(value = "showExaminationList")
    @ResponseBody
    @RequiresPermissions("examinationList:show")
    public ReType showList(Examination examination, Model model, String page, String limit) {
        ReType show = examinationService.show(examination, Integer.valueOf(page), Integer.valueOf(limit));
        return show;
    }*/

    @GetMapping("/showAddExamination")
    public String goAddExamination(Model model) {
        //查询信息采集模板
        List<Infor_collection> list = examinationService.selectInforById();
       /* //查询所有的科目
        List<Subject> subjectList = examinationService.selectBySubject();*/
        //查询所有的专业
        List<SpecManagement> specList = examinationService.selectBySpec();
//        model.addAttribute("subjectList",subjectList);
        model.addAttribute("info_list",list);
        model.addAttribute("specList",specList);
        return "/system/examination/add-examination";
    }

    //新建考试
    @ApiOperation(value = "/addExamination", httpMethod = " POST")
    @PostMapping(value = "addExamination")
    @ResponseBody
    public JsonUtil addExamination(Examination examination, HttpServletRequest request) {
       /* if (StringUtils.isEmpty(examination.getExam())) {
            JsonUtil.error("考试名称不能为空");
        }*/
        JsonUtil j = new JsonUtil();
        try {
            //设置成绩状态默认为 不开启 0:关闭 1：开启
            examinationService.addExamination(examination);
            //操作role-menu data
            j.setMsg("保存成功");
        } catch (MyException e) {
            j.setMsg("保存失败");
            j.setFlag(false);
            e.printStackTrace();
        }
        return j;
    }




    @GetMapping(value = "updateExamination")
    public String goUpdateExamination(String id, Model model, boolean detail) {
        if (StringUtils.isNotEmpty(id)) {
            Examination examination = examinationService.selectByPrimaryKey(id);
            model.addAttribute("exam", examination);
        }
        model.addAttribute("detail", detail);
        return "/system/examination/update-examination";
    }



    @ApiOperation(value = "/updateExamination", httpMethod = "POST", notes = "编辑")
    @PostMapping(value = "updateExamination")
    @ResponseBody
    @Transactional
    public JsonUtil updateExamination(Examination examination, String role[], HttpServletRequest request) {
        JsonUtil jsonUtil = new JsonUtil();
        jsonUtil.setFlag(false);
        if (examination == null) {
            jsonUtil.setMsg("获取数据失败");
            return jsonUtil;
        }
        try {
            examinationService.updateByPrimaryKey(examination);
            jsonUtil.setFlag(true);
            jsonUtil.setMsg("修改成功");
            //throw  new MyException("错误");
        } catch (MyException e) {
            e.printStackTrace();
        }
        return jsonUtil;
    }


    @Log(desc = "删除")
    @ApiOperation(value = "/del", httpMethod = "get", notes = "删除")
    @PostMapping(value = "/del")
    @ResponseBody
   /* @RequiresPermissions("user:del")*/
    public JsonUtil del(String id) {
        JsonUtil j = new JsonUtil();
        try {
            examinationService.deleteById(id);
            j.setFlag(true);
            j.setMsg("删除成功");
        }catch (Exception e){

        }
        return j;
    }




}
