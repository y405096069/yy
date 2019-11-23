package com.nfdw.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.nfdw.core.annotation.Log;
import com.nfdw.entity.Achievement_Summary;
import com.nfdw.entity.Examination;
import com.nfdw.entity.SpecManagement;
import com.nfdw.exception.MyException;
import com.nfdw.service.AchieveService;
import com.nfdw.service.AchievementService;
import com.nfdw.service.ImportExcelService;
import com.nfdw.service.SpecManagementService;
import com.nfdw.util.JsonUtil;
import com.nfdw.util.ReType;
import com.nfdw.utils.ExcelUtil;
import com.nfdw.utils.ExportToExcel;
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

    @Autowired
    SpecManagementService specService;

    /*
     *初试成绩管理 start          (只查看报名成功)
     */
    @GetMapping(value = "achievementFirstList")
    public String achievementFirstList(Model model) {
        List<Examination> list = acService.selectListByPage(null);
        model.addAttribute("list",list);
        List<SpecManagement> list2 = specService.selectListByPage(null);//专业列表
        model.addAttribute("list2",list2);
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
            a_sum.setExam_id(Integer.valueOf(ex_id));
            tList = achieveService.selectListByPage(a_sum);
        } catch (MyException e) {
            e.printStackTrace();
        }
        return new ReType(tPage.getTotal(), tList);
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
                /*Achievement_Summary aum= achieveService.getIdByExam_num(list.get(i).getExaminee_num());
                list.get(i).setId(aum.getId());*/
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

    //@ApiOperation(value = "/inout_achieveFirstGrade", httpMethod = "POST", notes = "导出")
    @RequestMapping(value = "inout_achieveFirstGrade")      //导出
    @ResponseBody
    public JsonUtil inout_achieveFirstGrade(String id, String name, HttpServletResponse response) {

        List<Achievement_Summary> tList = achieveService.selectListByPage2( Integer.valueOf(id));
        JsonUtil jsonUtil = new JsonUtil();

        try{
            ExportToExcel.exportWhiteList(name, tList, response);
            jsonUtil.setFlag(true);
            jsonUtil.setMsg("导出成功");
        } catch (Exception e) {
            e.printStackTrace();
            jsonUtil.setMsg("发生错误,导出失败");
        }
        return jsonUtil;
    }
    /*
     *初试成绩管理-查看成绩 end
     */


    /*
        初试入围成绩管理 -        start
     */
    @GetMapping(value = "achievementFirstCutList")
    public String achievementFirstCutList(Model model) {
        List<Examination> list = acService.selectListByPage(null);//考试列表
        model.addAttribute("list",list);
        List<SpecManagement> list2 = specService.selectListByPage(null);//专业列表
        model.addAttribute("list2",list2);
        String[] list3 = achieveService.selectAllHigh_province();//高考省份列表
        model.addAttribute("list3",list3);
        return "/system/achieve/achievementFirstCutList";
    }

    @GetMapping(value = "showachievementFirstCutList")
    @ResponseBody
    public ReType showachievementFirstCutList(Model model,Integer exam_id,String professional_name, Integer cut_num,
                                              String high_provinces,Integer cut_score,Integer cut_rank, String page,
                                              String limit) {
        List<Achievement_Summary> tList = null;
        Page<Achievement_Summary> tPage = PageHelper.startPage(Integer.valueOf(page), Integer.valueOf(limit));
        try {
            /*if (exam_id==null || exam_id=="")
                exam_id="0";
            if (cut_score==null || cut_num=="")
                cut_num="0";
            if (cut_score==null || cut_score=="")
                cut_score="0";
            if (cut_rank==null || cut_rank=="")
                cut_rank="0";*/
            System.out.print("参数{exam_id:"+exam_id);
            System.out.print("_____professional_name:"+professional_name);
            System.out.print("_____cut_num:"+cut_num);
            System.out.print("_____high_provinces:"+high_provinces);
            System.out.print("_____cut_score:"+cut_score);
            System.out.print("_____cut_rank:"+cut_rank+"}");
            if(cut_score!=null || cut_rank!=null)
                cut_num=0;
            tList = achieveService.selectListByTerm(exam_id,professional_name,cut_num,high_provinces,cut_score,cut_rank);
        } catch (MyException e) {
            //log.error("class:BaseServiceImpl ->method:show->message:" + e.getMessage());
            e.printStackTrace();
        }
        return new ReType(tPage.getTotal(), tList);
        //return achieveService.show(a_sum,Integer.valueOf(page), Integer.valueOf(limit));
    }




    /*
        初试入围成绩管理 -        end
     */






    /*
     *复试成绩管理 start
     */
    @GetMapping(value = "achievementLastList")
    public String achievementLastList(Model model) {
        List<Examination> list = acService.selectListByPage(null);
        model.addAttribute("list",list);
        List<SpecManagement> list2 = specService.selectListByPage(null);//专业列表
        model.addAttribute("list2",list2);
        return "/system/achieve/achievementLastList";
    }

    @GetMapping(value = "showachievementLastList")
    @ResponseBody
    public ReType showachievementLastList(Model model, Examination exam, String page, String limit) {
        return acService.show(exam,Integer.valueOf(page), Integer.valueOf(limit));
    }

    @Log(desc = "修改成绩查询开关", type = Log.LOG_TYPE.DEL)
    @ApiOperation(value = "/updateGrade_switch2", httpMethod = "POST", notes = "修改成绩查询开关")
    @PostMapping(value = "/updateGrade_switch2")
    @ResponseBody
    @Transactional
    public JsonUtil updateGrade_switch2(String id, String status) {
        JsonUtil j = new JsonUtil();
        if(id==null || status==null)
            return JsonUtil.error("获取数据失败");
        try {
            if (acService.updateGrade_switch2(Integer.valueOf(id),Integer.valueOf(status))){
                j.setFlag(true);
                j.setMsg("修改成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return j;
    }


    /*
     *查看复试成绩
     */
    @GetMapping(value = "achievementLastGradeList")
    public String achievementLastGradeList(String id, Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("achieveGrade_eid",id);        //保存考试id
        return "/system/achieve/achievementLastGradeList";
    }

    @GetMapping(value = "show_achievementLastGradeList")
    @ResponseBody
    public ReType show_achievementLastGradeList(Model model, Achievement_Summary a_sum, String page, String limit, HttpServletRequest request) {
        List<Achievement_Summary> tList = null;
        Page<Achievement_Summary> tPage = PageHelper.startPage(Integer.valueOf(page), Integer.valueOf(limit));
        try {
            HttpSession session = request.getSession();
            String ex_id = (String)session.getAttribute("achieveGrade_eid");        //保存考试id
            a_sum.setExam_id(Integer.valueOf(ex_id));
            a_sum.setQualified_mark("Y");
            tList = achieveService.selectListByPage(a_sum);
        } catch (MyException e) {
            e.printStackTrace();
        }
        return new ReType(tPage.getTotal(), tList);
    }


    @GetMapping(value = "achievementLastInto")         //导入 弹窗
    public String achievementLastInto(String id, Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("achieveGrade_eid",id);        //保存考试id
        return "/system/achieve/achievementLastInto";
    }

    @Log(desc = "导入复试成绩", type = Log.LOG_TYPE.DEL)
    @ApiOperation(value = "/intoLastGrade", httpMethod = "POST", notes = "导入复试成绩")
    @PostMapping(value = "/intoLastGrade")
    @ResponseBody
    @Transactional
    public JsonUtil intoLastGrade(@RequestParam("file") MultipartFile file, HttpServletRequest request,
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

    @ApiOperation(value = "/delLastGradeById", httpMethod = "POST", notes = "删除当前考试所有复试成绩")
    @Log(desc = "删除当前考试所有复试成绩", type = Log.LOG_TYPE.UPDATE)
    @PostMapping(value = "delLastGradeById")
    @ResponseBody
    public JsonUtil delLastGradeById(String id) {
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

    //@ApiOperation(value = "/inout_achieveLastGrade", httpMethod = "POST", notes = "导出")
    @RequestMapping(value = "inout_achieveLastGrade")      //导出
    @ResponseBody
    public JsonUtil inout_achieveLastGrade(String id, String name, HttpServletResponse response) {
        List<Achievement_Summary> tList = achieveService.selectListByPage2( Integer.valueOf(id));
        //List<Achievement_Summary> tList = achieveService.selectListByPage(null, Integer.valueOf(id));
        JsonUtil jsonUtil = new JsonUtil();
        try{
            ExportToExcel.exportWhiteList(name, tList, response);
            jsonUtil.setFlag(true);
            jsonUtil.setMsg("导出成功");
        } catch (Exception e) {
            e.printStackTrace();
            jsonUtil.setMsg("发生错误,导出失败");
        }
        return jsonUtil;
    }
    /*
     *复试成绩管理-查看成绩 end
     */





    /*
        复试入围成绩管理 -        start
     */
    @GetMapping(value = "achievementLastCutList")
    public String achievementLastCutList(Model model) {
        List<Examination> list = acService.selectListByPage(null);//考试列表
        model.addAttribute("list",list);
        List<SpecManagement> list2 = specService.selectListByPage(null);//专业列表
        model.addAttribute("list2",list2);
        String[] list3 = achieveService.selectAllHigh_province();//高考省份列表
        model.addAttribute("list3",list3);
        return "/system/achieve/achievementLastCutList";
    }

    @GetMapping(value = "showachievementLastCutList")
    @ResponseBody
    public ReType showachievementLastCutList(Model model,Integer exam_id,String professional_name, Integer cut_num,
                                              String high_provinces,Integer cut_score,Integer cut_rank, String page,
                                              String limit) {
        List<Achievement_Summary> tList = null;
        Page<Achievement_Summary> tPage = PageHelper.startPage(Integer.valueOf(page), Integer.valueOf(limit));
        try {
            /*if (exam_id==null || exam_id=="")
                exam_id="0";
            if (cut_score==null || cut_num=="")
                cut_num="0";
            if (cut_score==null || cut_score=="")
                cut_score="0";
            if (cut_rank==null || cut_rank=="")
                cut_rank="0";*/
            System.out.print("参数{exam_id:"+exam_id);
            System.out.print("_____professional_name:"+professional_name);
            System.out.print("_____cut_num:"+cut_num);
            System.out.print("_____high_provinces:"+high_provinces);
            System.out.print("_____cut_score:"+cut_score);
            System.out.print("_____cut_rank:"+cut_rank+"}");
            if(cut_score!=null)
                cut_num=0;
            tList = achieveService.selectListByTerm(exam_id,professional_name,cut_num,high_provinces,cut_score,cut_rank);
        } catch (MyException e) {
            //log.error("class:BaseServiceImpl ->method:show->message:" + e.getMessage());
            e.printStackTrace();
        }
        return new ReType(tPage.getTotal(), tList);
        //return achieveService.show(a_sum,Integer.valueOf(page), Integer.valueOf(limit));
    }








    /*
        复试入围成绩管理 -        end
     */


    /*
        签到管理 qiandao
     */
    /*@GetMapping(value = "qiandaoList")
    public String qiandaoList(String id, Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("achieveGrade_eid",id);        //保存考试id

        return "/system/achieve/qiandaoList";
    }

    @GetMapping(value = "showqiandaoList")
    @ResponseBody
    public ReType showqiandaoList(Model model, Achievement_Summary a_sum, String page, String limit, HttpServletRequest request) {
        List<Achievement_Summary> tList = null;
        Page<Achievement_Summary> tPage = PageHelper.startPage(Integer.valueOf(page), Integer.valueOf(limit));
        try {
            HttpSession session = request.getSession();
            String ex_id = (String)session.getAttribute("achieveGrade_eid");        //保存考试id
            tList = achieveService.selectListByPage(null);
        } catch (MyException e) {
            e.printStackTrace();
        }
        return new ReType(tPage.getTotal(), tList);
    }*/
    /*
        end 签到 应付
     */

    @Autowired
    SignInService signInService;
    //signIn/showSignIn
    @GetMapping(value = "/qiandaoList")
    /*@RequiresPermissions("user:show")*/
    public String showNotice(Model model) {
        return "/system/achieve/signInList";//学生签到
    }

    @GetMapping(value = "showSignInList")
    @ResponseBody
    /* @RequiresPermissions("user:show")*/
    public ReType showNotice(Model model, SignIn signIn, String page, String limit) {

        return signInService.show(signIn, Integer.valueOf(page), Integer.valueOf(limit));
    }



    @PostMapping(value = "del")
    @ResponseBody
    @Transactional
    public JsonUtil updateNotice(SignIn signIn) {
        JsonUtil jsonUtil = new JsonUtil();
        jsonUtil.setFlag(false);
        if (signIn == null) {
            jsonUtil.setMsg("获取数据失败");
            return jsonUtil;
        }
        try {
            int count=signInService.updateById(signIn);
            if (count>0){
                jsonUtil.setFlag(true);
                jsonUtil.setMsg("签到成功");
            }
            //throw  new MyException("错误");
        } catch (MyException e) {
            e.printStackTrace();
        }
        return jsonUtil;
    }


}
