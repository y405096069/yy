package com.nfdw.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.nfdw.core.annotation.Log;
import com.nfdw.entity.Achievement_Summary;
import com.nfdw.entity.Examination;
import com.nfdw.entity.SignIn;
import com.nfdw.entity.SpecManagement;
import com.nfdw.exception.MyException;
import com.nfdw.service.*;
import com.nfdw.util.JsonUtil;
import com.nfdw.util.ReType;
import com.nfdw.utils.*;
import io.swagger.annotations.ApiOperation;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.DecimalFormat;
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

    @Autowired
    ExaminationService examService;

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

    @PostMapping(value = "selectSpecialty_NameById")
    @ResponseBody
    public Object selectSpecialty_NameById(String id) {
        String name = achieveService.selectSpecialty_NameById(Integer.valueOf(id));
        return JSON.toJSON(name);
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
        String[] list3 = achieveService.selectAllHigh_provinceByEId(Integer.valueOf(id));//高考省份列表
        model.addAttribute("list",list3);
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
        achieveService.updFirst_GradeByEId(Integer.valueOf(ex_id));         //清除所有初试成绩
        //acService.delFirstGradeByEId(Integer.valueOf(ex_id));       //删除所有

        try {
            Examination  exam=examService.queryForById(ex_id);
            String subjectQZ = exam.getSubject_q_fen_child();       //获取初试科目权重
            String[] split = subjectQZ.split(",");           //以逗号分割
            DecimalFormat df = new DecimalFormat("0.0");    //保留1位小数

            for (int i = 0; i<list.size();i++){
                list.get(i).setExam_id(Integer.valueOf(ex_id));
                double total=0;
                double score1=0;
                if (split.length>0 && list.get(i).getFirst_subjects_achieve1()!=0){
                    score1=(Double.valueOf(split[0])/100)*list.get(i).getFirst_subjects_achieve1();
                    score1= Double.valueOf(df.format(score1));
                    total=score1;
                    System.out.println(list.get(i).getName());
                    System.out.println("科目1："+list.get(i).getFirst_subjects_name1()+"  成绩："+list.get(i).getFirst_subjects_achieve1()+"  权重占比:"+split[0]+"  加权得分："+score1);
                }
                double score2=0;
                if (split.length>1 && list.get(i).getFirst_subjects_achieve2()!=0){
                    score2=(Double.valueOf(split[1])/100)*list.get(i).getFirst_subjects_achieve2();
                    score2= Double.valueOf(df.format(score2));
                    total=total+score2;
                    System.out.println("科目2："+list.get(i).getFirst_subjects_name2()+"  成绩："+list.get(i).getFirst_subjects_achieve2()+"  权重占比:"+split[1]+"  加权得分："+score2);
                }
                double score3;
                if (split.length>2 && list.get(i).getFirst_subjects_achieve3()!=0){
                    score3=(Double.valueOf(split[2])/100)*list.get(i).getFirst_subjects_achieve3();
                    score3= Double.valueOf(df.format(score3));
                    total=total+score3;
                    System.out.println("科目3："+list.get(i).getFirst_subjects_name3()+"  成绩："+list.get(i).getFirst_subjects_achieve3()+"  权重占比:"+split[2]+"  加权得分："+score3);
                }
                double score4;
                if (split.length>3 && list.get(i).getFirst_subjects_achieve4()!=0){
                    score4=(Double.valueOf(split[3])/100)*list.get(i).getFirst_subjects_achieve4();
                    score4= Double.valueOf(df.format(score4));
                    total=total+score4;
                    System.out.println("科目4："+list.get(i).getFirst_subjects_name4()+"  成绩："+list.get(i).getFirst_subjects_achieve4()+"  权重占比:"+split[3]+"  加权得分："+score4);
                }
                double score5;
                if (split.length>4 && list.get(i).getFirst_subjects_achieve5()!=0){
                    score5=(Double.valueOf(split[4])/100)*list.get(i).getFirst_subjects_achieve5();
                    score5= Double.valueOf(df.format(score5));
                    total=total+score5;
                    System.out.println("科目5："+list.get(i).getFirst_subjects_name5()+"  成绩："+list.get(i).getFirst_subjects_achieve5()+"  权重占比:"+split[4]+"  加权得分："+score5);
                }
                double score6;
                if (split.length>5 && list.get(i).getFirst_subjects_achieve6()!=0){
                    score6=(Double.valueOf(split[5])/100)*list.get(i).getFirst_subjects_achieve6();
                    score6= Double.valueOf(df.format(score6));
                    total=total+score6;
                    System.out.println("科目6："+list.get(i).getFirst_subjects_name6()+"  成绩："+list.get(i).getFirst_subjects_achieve6()+"  权重占比:"+split[5]+"  加权得分："+score6);
                }
                if (total>0)
                    System.out.println("总分："+total);
                list.get(i).setFirst_subjects_total(total);

                Achievement_Summary achieve = achieveService.getAchieveById_Card(list.get(i).getId_card());
                if (achieve!=null){
                    list.get(i).setId(achieve.getId());
                    achieveService.updAchieve_Grade(list.get(i));
                }
                //acService.addFirstGrade(list.get(i));
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
            //if (acService.delFirstGradeByEId(Integer.valueOf(id))){
            if(achieveService.updFirst_GradeByEId(Integer.valueOf(id))) {  //清除所有初试成绩
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

        List<Achievement_Summary> tList = achieveService.selectListByPage2( Integer.valueOf(id),null);
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
                                              String high_provinces,Integer cut_score,Integer cut_rank,String isOutput,
                                              String page,String limit) {
        List<Achievement_Summary> tList = null;
        Page<Achievement_Summary> tPage = PageHelper.startPage(Integer.valueOf(page), Integer.valueOf(limit));
        try {
            System.out.print("参数{exam_id:"+exam_id);
            System.out.print("_____professional_name:"+professional_name);
            System.out.print("_____cut_num:"+cut_num);
            System.out.print("_____high_provinces:"+high_provinces);
            System.out.print("_____cut_score:"+cut_score);
            System.out.print("_____cut_rank:"+cut_rank+"}");
            if(cut_score!=null || cut_rank!=null)
                cut_num=0;

            if (isOutput!=null && isOutput!=""){          //输出时 生成排名
                //入围分数
                double rwscore = 0;
                tList = achieveService.selectListByTerm(exam_id,professional_name,cut_num,high_provinces,cut_score,cut_rank);
                if (cut_score!=null)
                    rwscore=cut_score;
                else
                    rwscore=tList.get(tList.size()-1).getFirst_subjects_total();

                //全国排名
                List<Achievement_Summary> QGList = achieveService.selectListByTerm(exam_id,professional_name,0,null,0,0);
                for (int i =0;i<QGList.size();i++){
                    Achievement_Summary a_sum = new Achievement_Summary();
                    a_sum.setId(QGList.get(i).getId());
                    a_sum.setNational_rankings(i+1);                                               //全国排名
                    int tmc =achieveService.selectFirstNational_same_name(exam_id,professional_name,
                            null,QGList.get(i).getFirst_subjects_total());          //全国同分人数
                    if (tmc==1)
                        a_sum.setNational_same_name(0);
                    else
                        a_sum.setNational_same_name(tmc-1);
                    achieveService.updAchieve_Grade(a_sum);
                }

                //省排名
                List<Achievement_Summary> SList = achieveService.selectListByTerm(exam_id,professional_name,0,high_provinces,0,0);
                for (int i =0;i<SList.size();i++){
                    Achievement_Summary a_sum = new Achievement_Summary();
                    a_sum.setId(SList.get(i).getId());
                    a_sum.setProvincial_ranking(i+1);                                               //省排名
                    int tmc =achieveService.selectFirstNational_same_name(exam_id,professional_name,
                            high_provinces,SList.get(i).getFirst_subjects_total());          //省同分人数
                    if (tmc==1)
                        a_sum.setProvincial_same_name(0);
                    else
                        a_sum.setProvincial_same_name(tmc-1);
                    achieveService.updAchieve_Grade(a_sum);
                }

                //设置不合格
                List<Achievement_Summary> BhgList = achieveService.selectListByTerm(exam_id,professional_name,0,high_provinces,0,0);
                for (int i =0;i<BhgList.size();i++){
                    Achievement_Summary a_sum = new Achievement_Summary();
                    a_sum.setId(BhgList.get(i).getId());
                    a_sum.setQualified_mark("N");
                    a_sum.setQualified_line(rwscore);           //合格线
                    achieveService.updAchieve_Grade(a_sum);
                }

                //设置合格
                for (int i =0;i<tList.size();i++){
                    Achievement_Summary a_sum = new Achievement_Summary();
                    a_sum.setId(tList.get(i).getId());
                    a_sum.setQualified_mark("Y");
                    a_sum.setQualified_line(rwscore);           //合格线
                    achieveService.updAchieve_Grade(a_sum);
                }

                System.out.println("输出成绩---------入围分数为:"+rwscore);
                tList = achieveService.selectListByTerm(exam_id,professional_name,0,high_provinces,0,0);//输出结果
            }else {
                tList = achieveService.selectListByTerm(exam_id,professional_name,cut_num,high_provinces,cut_score,cut_rank);
            }
        } catch (MyException e) {
            //log.error("class:BaseServiceImpl ->method:show->message:" + e.getMessage());
            e.printStackTrace();
        }
        return new ReType(tPage.getTotal(), tList);
        //return achieveService.show(a_sum,Integer.valueOf(page), Integer.valueOf(limit));
    }


    @RequestMapping(value = "inout_achieveFirstCutGrade")      //入围导出全部
    @ResponseBody
    public JsonUtil inout_achieveFirstCutGrade(Integer exam_id,String professional_name, Integer cut_num,
                                               String high_provinces,Integer cut_score,Integer cut_rank,String isOutput
                                               ,HttpServletResponse response) {

        List<Achievement_Summary> tList = tList = achieveService.selectListByTerm(exam_id,professional_name,cut_num,high_provinces,cut_score,cut_rank);
        JsonUtil jsonUtil = new JsonUtil();
        try{
            CutExportToExcel.exportWhiteList( tList, response);
            jsonUtil.setFlag(true);
            jsonUtil.setMsg("导出成功");
        } catch (Exception e) {
            e.printStackTrace();
            jsonUtil.setMsg("发生错误,导出失败");
        }
        return jsonUtil;
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

    @Log(desc = "修改合格证开关", type = Log.LOG_TYPE.DEL)
    @ApiOperation(value = "/updateGrade_Hgswitch", httpMethod = "POST", notes = "修改合格证开关")
    @PostMapping(value = "/updateGrade_Hgswitch")
    @ResponseBody
    @Transactional
    public JsonUtil updateGrade_Hgswitch(String id, String status) {
        JsonUtil j = new JsonUtil();
        if(id==null || status==null)
            return JsonUtil.error("获取数据失败");
        try {
            if (acService.updateGrade_Hgswitch(Integer.valueOf(id),Integer.valueOf(status))){
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
        String[] list3 = achieveService.selectAllHigh_provinceByEId(Integer.valueOf(id));//高考省份列表
        model.addAttribute("list",list3);
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
            a_sum.setQualified_mark("Y");               //只查已过初试
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
        List<Achievement_Summary> list = excelService.importExcelWithSimple2(file, request, response);
        achieveService.updComplex_GradeByEId(Integer.valueOf(ex_id));    //清除所有复试成绩

        try {
            Examination  exam=examService.queryForById(ex_id);
            String subjectQZ = exam.getFather_q_fen_child();       //获取复试科目权重
            String[] split = subjectQZ.split(",");           //以逗号分割
            DecimalFormat df = new DecimalFormat("0.0");    //保留1位小数

            for (int i = 0; i<list.size();i++){
                list.get(i).setExam_id(Integer.valueOf(ex_id));
                double total=0;
                double score1=0;
                if (split.length>0 && list.get(i).getComplex_subjects_achieve1()!=0){
                    score1=(Double.valueOf(split[0])/100)*list.get(i).getComplex_subjects_achieve1();
                    score1= Double.valueOf(df.format(score1));
                    total=score1;
                    System.out.println(list.get(i).getName());
                    System.out.println("科目1："+list.get(i).getComplex_subjects_name1()+"  成绩："+list.get(i).getComplex_subjects_achieve1()+"  权重占比:"+split[0]+"  加权得分："+score1);
                }
                double score2=0;
                if (split.length>1 && list.get(i).getComplex_subjects_achieve2()!=0){
                    score2=(Double.valueOf(split[1])/100)*list.get(i).getComplex_subjects_achieve2();
                    score2= Double.valueOf(df.format(score2));
                    total=total+score2;
                    System.out.println("科目2："+list.get(i).getComplex_subjects_name2()+"  成绩："+list.get(i).getComplex_subjects_achieve2()+"  权重占比:"+split[1]+"  加权得分："+score2);
                }
                double score3;
                if (split.length>2 && list.get(i).getComplex_subjects_achieve3()!=0){
                    score3=(Double.valueOf(split[2])/100)*list.get(i).getComplex_subjects_achieve3();
                    score3= Double.valueOf(df.format(score3));
                    total=total+score3;
                    System.out.println("科目3："+list.get(i).getComplex_subjects_name3()+"  成绩："+list.get(i).getComplex_subjects_achieve3()+"  权重占比:"+split[2]+"  加权得分："+score3);
                }
                double score4;
                if (split.length>3 && list.get(i).getComplex_subjects_achieve4()!=0){
                    score4=(Double.valueOf(split[3])/100)*list.get(i).getComplex_subjects_achieve4();
                    score4= Double.valueOf(df.format(score4));
                    total=total+score4;
                    System.out.println("科目4："+list.get(i).getComplex_subjects_name4()+"  成绩："+list.get(i).getComplex_subjects_achieve4()+"  权重占比:"+split[3]+"  加权得分："+score4);
                }
                double score5;
                if (split.length>4 && list.get(i).getComplex_subjects_achieve5()!=0){
                    score5=(Double.valueOf(split[4])/100)*list.get(i).getComplex_subjects_achieve5();
                    score5= Double.valueOf(df.format(score5));
                    total=total+score5;
                    System.out.println("科目5："+list.get(i).getComplex_subjects_name5()+"  成绩："+list.get(i).getComplex_subjects_achieve5()+"  权重占比:"+split[4]+"  加权得分："+score5);
                }
                double score6;
                if (split.length>5 && list.get(i).getComplex_subjects_achieve6()!=0){
                    score6=(Double.valueOf(split[5])/100)*list.get(i).getComplex_subjects_achieve6();
                    score6= Double.valueOf(df.format(score6));
                    total=total+score6;
                    System.out.println("科目6："+list.get(i).getComplex_subjects_name6()+"  成绩："+list.get(i).getComplex_subjects_achieve6()+"  权重占比:"+split[5]+"  加权得分："+score6);
                }
                if (total>0)
                    System.out.println("总分："+total);
                list.get(i).setComplex_subjects_total(total);

                int chuQZ = exam.getSubject_q_fen();      //获取初试权重
                int fuQZ = exam.getFather_q_fen();        //获取复试权重

                Achievement_Summary achieve = achieveService.getAchieveById_Card(list.get(i).getId_card());
                if (achieve!=null){
                    double heji = Double.valueOf(fuQZ)/100*total + Double.valueOf(chuQZ)/100*achieve.getFirst_subjects_total();
                    list.get(i).setTotal_score(heji);
                    list.get(i).setId(achieve.getId());
                    System.out.println("初试权重："+chuQZ+"------复试权重:"+fuQZ);
                    System.out.println("初试总分:"+achieve.getFirst_subjects_total()+"     ---复试总分:"+total);
                    System.out.println("合计:"+heji);
                    achieveService.updAchieve_Grade(list.get(i));
                }
                //acService.addFirstGrade(list.get(i));
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
        };    //清除所有复试成绩
        try {
            //acService.delFirstGradeByEId(Integer.valueOf(id))
            if (achieveService.updComplex_GradeByEId(Integer.valueOf(id))){     //删除复试数据
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
        List<Achievement_Summary> tList = achieveService.selectListByPage2( Integer.valueOf(id),"Y");//导出初试通过
        //List<Achievement_Summary> tList = achieveService.selectListByPage(null, Integer.valueOf(id));
        JsonUtil jsonUtil = new JsonUtil();
        try{
            ExportToExcel2.exportWhiteList(name, tList, response);
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
                                              String high_provinces,Integer cut_score,Integer cut_rank,String isOutput,
                                             String page, String limit) {
        List<Achievement_Summary> tList = null;
        Page<Achievement_Summary> tPage = PageHelper.startPage(Integer.valueOf(page), Integer.valueOf(limit));
        try {

            System.out.print("参数{exam_id:"+exam_id);
            System.out.print("_____professional_name:"+professional_name);
            System.out.print("_____cut_num:"+cut_num);
            System.out.print("_____high_provinces:"+high_provinces);
            System.out.print("_____cut_score:"+cut_score);
            System.out.print("_____cut_rank:"+cut_rank+"}");
            if(cut_score!=null || cut_rank!=null)
                cut_num=0;

            if (isOutput!=null && isOutput!=""){          //输出时 生成排名
                //入围分数
                double rwscore = 0;
                tList = achieveService.selectListByTerm2(exam_id,professional_name,cut_num,high_provinces,cut_score,cut_rank);
                if (cut_score!=null)
                    rwscore=cut_score;
                else
                    rwscore=tList.get(tList.size()-1).getTotal_score();

                //全国排名
                List<Achievement_Summary> QGList = achieveService.selectListByTerm2(exam_id,professional_name,0,null,0,0);
                for (int i =0;i<QGList.size();i++){
                    Achievement_Summary a_sum = new Achievement_Summary();
                    a_sum.setId(QGList.get(i).getId());
                    a_sum.setRe_national_rankings(i+1);                                   //全国排名
                    int tmc =achieveService.selectLastNational_same_name(exam_id,professional_name,
                            null,QGList.get(i).getTotal_score());          //全国同分人数
                    if (tmc==1)
                        a_sum.setRe_national_same_name(0);
                    else
                        a_sum.setRe_national_same_name(tmc-1);
                    achieveService.updAchieve_Grade(a_sum);
                }

                //省排名
                List<Achievement_Summary> SList = achieveService.selectListByTerm2(exam_id,professional_name,0,high_provinces,0,0);
                for (int i =0;i<SList.size();i++){
                    Achievement_Summary a_sum = new Achievement_Summary();
                    a_sum.setId(SList.get(i).getId());
                    a_sum.setRe_provincial_ranking(i+1);                                               //省排名
                    int tmc =achieveService.selectLastNational_same_name(exam_id,professional_name,
                            high_provinces,SList.get(i).getTotal_score());          //省同分人数
                    if (tmc==1)
                        a_sum.setRe_provincial_same_name(0);
                    else
                        a_sum.setRe_provincial_same_name(tmc-1);
                    achieveService.updAchieve_Grade(a_sum);
                }

                //设置不合格
                List<Achievement_Summary> BhgList = achieveService.selectListByTerm2(exam_id,professional_name,0,high_provinces,0,0);
                for (int i =0;i<BhgList.size();i++){
                    Achievement_Summary a_sum = new Achievement_Summary();
                    a_sum.setId(BhgList.get(i).getId());
                    a_sum.setRe_qualified_mark("N");
                    a_sum.setRe_qualified_line(rwscore);           //合格线
                    achieveService.updAchieve_Grade(a_sum);
                }

                //设置合格
                for (int i =0;i<tList.size();i++){
                    Achievement_Summary a_sum = new Achievement_Summary();
                    a_sum.setId(tList.get(i).getId());
                    a_sum.setRe_qualified_mark("Y");
                    a_sum.setRe_qualified_line(rwscore);           //合格线
                    achieveService.updAchieve_Grade(a_sum);
                }

                System.out.println("输出成绩---------入围分数为:"+rwscore);
                tList = achieveService.selectListByTerm2(exam_id,professional_name,0,high_provinces,0,0);//输出结果
            }else {
                tList = achieveService.selectListByTerm2(exam_id,professional_name,cut_num,high_provinces,cut_score,cut_rank);
            }
        } catch (MyException e) {
            //log.error("class:BaseServiceImpl ->method:show->message:" + e.getMessage());
            e.printStackTrace();
        }
        return new ReType(tPage.getTotal(), tList);
        //return achieveService.show(a_sum,Integer.valueOf(page), Integer.valueOf(limit));
    }


    @RequestMapping(value = "inout_achieveLastCutGrade")      //入围导出全部
    @ResponseBody
    public JsonUtil inout_achieveLastCutGrade(Integer exam_id,String professional_name, Integer cut_num,
                                               String high_provinces,Integer cut_score,Integer cut_rank,String isOutput
            ,HttpServletResponse response) {

        List<Achievement_Summary> tList = tList = achieveService.selectListByTerm(exam_id,professional_name,cut_num,high_provinces,cut_score,cut_rank);
        JsonUtil jsonUtil = new JsonUtil();
        try{
            CutExportToExcel2.exportWhiteList( tList, response);
            jsonUtil.setFlag(true);
            jsonUtil.setMsg("导出成功");
        } catch (Exception e) {
            e.printStackTrace();
            jsonUtil.setMsg("发生错误,导出失败");
        }
        return jsonUtil;
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
