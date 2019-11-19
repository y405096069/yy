package com.nfdw.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.nfdw.core.annotation.Log;
import com.nfdw.entity.Achievement_Summary;
import com.nfdw.entity.Examination;
import com.nfdw.exception.MyException;
import com.nfdw.service.AchieveService;
import com.nfdw.service.AchievementService;
import com.nfdw.service.ImportExcelService;
import com.nfdw.util.JsonUtil;
import com.nfdw.util.ReType;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(value = "/achievement")
public class AchievementController {

    @Autowired
    AchievementService acService;

    @Autowired
    AchieveService achieveService;

    @Autowired
    ImportExcelService excelService;

    /*
     *初试成绩管理 start
     */
    @GetMapping(value = "achievementFirstList")
    public String achievementFirstList(Model model) {
        List<Examination> list = acService.selectListByPage(null);
        model.addAttribute("list",list);
        return "/system/achieve/achievementFirstList";
    }

    @GetMapping(value = "showachievementFirstList")
    @ResponseBody
    public ReType showachievementFirstList(Model model, Examination exam, String page, String limit) {
        return acService.show(exam,Integer.valueOf(page), Integer.valueOf(limit));
    }


    @Log(desc = "修改成绩查询开关", type = Log.LOG_TYPE.DEL)
    @ApiOperation(value = "/updateGrade_switch", httpMethod = "POST", notes = "修改成绩查询开关")
    @PostMapping(value = "/updateGrade_switch")
    @ResponseBody
    @Transactional
    public JsonUtil updateGrade_switch(String id, String status) {
        JsonUtil j = new JsonUtil();
        if(id==null || status==null)
            return JsonUtil.error("获取数据失败");
        try {
            if (acService.updateGrade_switch(Integer.valueOf(id),Integer.valueOf(status))){
                j.setFlag(true);
                j.setMsg("修改成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return j;
    }


    /*
     *查看初试成绩
     */
    @GetMapping(value = "achievementFirstGradeList")
    public String achievementFirstGradeList(String id, Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("achieveGrade_eid",id);        //保存考试id

        return "/system/achieve/achievementFirstGradeList";
    }

    @GetMapping(value = "show_achievementFirstGradeList")
    @ResponseBody
    public ReType show_achievementFirstGradeList(Model model, Achievement_Summary a_sum, String page, String limit, HttpServletRequest request) {
        List<Achievement_Summary> tList = null;
        Page<Achievement_Summary> tPage = PageHelper.startPage(Integer.valueOf(page), Integer.valueOf(limit));
        try {
            HttpSession session = request.getSession();
            String ex_id = (String)session.getAttribute("achieveGrade_eid");        //保存考试id
            tList = achieveService.selectListByPage(a_sum,Integer.valueOf(ex_id));
        } catch (MyException e) {
            e.printStackTrace();
        }
        return new ReType(tPage.getTotal(), tList);
        //return achieveService.show(a_sum,Integer.valueOf(page), Integer.valueOf(limit));
    }


    @GetMapping(value = "achievementFirstInto")         //导入 弹窗
    public String achFirstInto(String id, Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("achieveGrade_eid",id);        //保存考试id
        return "/system/achieve/achievementFirstInto";
    }

    @Log(desc = "导入初试成绩", type = Log.LOG_TYPE.DEL)
    @ApiOperation(value = "/intoFirstGrade", httpMethod = "POST", notes = "导入初试成绩")
    @PostMapping(value = "/intoFirstGrade")
    @ResponseBody
    @Transactional
    public JsonUtil intoFirstGrade(@RequestParam("file") MultipartFile file, HttpServletRequest request,
                                   HttpServletResponse response) {
        JsonUtil j = new JsonUtil();

        HttpSession session = request.getSession();
        String ex_id= (String)session.getAttribute("achieveGrade_eid");

        if(file.isEmpty()){
            return JsonUtil.error("获取数据失败");
        }
        List<Achievement_Summary> list = excelService.importExcelWithSimple(file, request, response);

        try {
            for (int i = 0; i<list.size();i++){
                list.get(i).setExam_id(Integer.valueOf(ex_id));
                acService.addFirstGrade(list.get(i));
            }
            j.setFlag(true);
            j.setMsg("导入成绩成功");
        } catch (Exception e) {
            e.printStackTrace();
            j.setMsg("发生异常,导入失败");
        }
        return j;
    }

    @ApiOperation(value = "/delFirstGradeById", httpMethod = "POST", notes = "删除当前考试所有初试成绩")
    @Log(desc = "删除当前考试所有初试成绩", type = Log.LOG_TYPE.UPDATE)
    @PostMapping(value = "delFirstGradeById")
    @ResponseBody
    public JsonUtil delFirstGradeById(String id) {
        JsonUtil jsonUtil = new JsonUtil();
        jsonUtil.setFlag(false);
        if (id==null) {
            jsonUtil.setMsg("获取数据失败");
            return jsonUtil;
        }
        try {
            if (acService.delFirstGradeByEId(Integer.valueOf(id))){
                jsonUtil.setFlag(true);
                jsonUtil.setMsg("删除成绩成功");
            }
        } catch (MyException e) {
            jsonUtil.setMsg("发生错误,删除失败");
            e.printStackTrace();
        }
        return jsonUtil;
    }


    /*
     *初试成绩管理-查看成绩 end
     */

}
