package com.nfdw.controller;

import com.nfdw.core.annotation.Log;
import com.nfdw.core.shiro.ShiroUtil;
import com.nfdw.entity.CurrentUser;
import com.nfdw.entity.StudentInformation;
import com.nfdw.exception.MyException;
import com.nfdw.service.StudentInformationService;
import com.nfdw.service.SysUserService;
import com.nfdw.util.JsonUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.UUID;
@Controller
@RequestMapping(value = "/studentInformation")
public class StudentInformationController {
    @Autowired
    StudentInformationService studentInformationService;
    @Autowired
    private SysUserService userService;

    @ApiOperation(value = " addStudentInformation", httpMethod = "POST", notes = "添加学生基本信息")
    @Log(desc = "添加学生基本信息")
    @PostMapping(value = " /addStudentInformation")
    @ResponseBody
    public JsonUtil addStudentInformation(StudentInformation studentInformation, String[] role, HttpServletRequest request){
        JsonUtil j = new JsonUtil();
        if("".equals(studentInformation.getStudent_id())||null!=studentInformation.getStudent_id()){
            return  JsonUtil.error("主键不能为空！");
        }
        if("".equals(studentInformation.getCertificate_type())||null!=studentInformation.getCertificate_type()){
            return  JsonUtil.error("证件类型不能为空！");
        }
        if("".equals(studentInformation.getCertificate_number())||null!=studentInformation.getCertificate_number()){
            return  JsonUtil.error("证件不能为空！");
        }
        if("".equals(studentInformation.getName())||null!=studentInformation.getName()){
            return  JsonUtil.error("姓名不能为空！");
        }
        if("".equals(studentInformation.getSex())||null!=studentInformation.getSex()){
            return  JsonUtil.error("性别不能为空！");
        }
        if("".equals(studentInformation.getNation())||null!=studentInformation.getNation()){
            return  JsonUtil.error("民族不能为空！");
        }
        if("".equals(studentInformation.getStreet())||null!=studentInformation.getStreet()){
            return  JsonUtil.error("街道详情不能为空！");
        }
        if("".equals(studentInformation.getRecipient())||null!=studentInformation.getRecipient()){
            return  JsonUtil.error("收件人不能为空！");
        }
        if("".equals(studentInformation.getPhone())||null!=studentInformation.getPhone()){
            return  JsonUtil.error("手机号码不能为空！");
        }
        if("".equals(studentInformation.getEmail())||null!=studentInformation.getEmail()){
            return  JsonUtil.error("邮箱不能为空！");
        }
        if("".equals(studentInformation.getPostal_code())||null!=studentInformation.getPostal_code()){
            return  JsonUtil.error("邮政编码不能为空！");
        }
        if("".equals(studentInformation.getExaminee_type())||null!=studentInformation.getExaminee_type()){
            return  JsonUtil.error("考生类型不能为空！");
        }
        if("".equals(studentInformation.getExaminee_education())||null!=studentInformation.getExaminee_education()){
            return  JsonUtil.error("考生学历不能为空！");
        }
        if("".equals(studentInformation.getExaminee_province())||null!=studentInformation.getExaminee_province()){
            return  JsonUtil.error("考生省份不能为空！");
        }
        if("".equals(studentInformation.getPolitics_status())||null!=studentInformation.getPolitics_status()){
            return  JsonUtil.error("政治面貌不能为空！");
        }
        if("".equals(studentInformation.getGraduate_type())||null!=studentInformation.getGraduate_type()){
            return  JsonUtil.error("应往届不能为空！");
        }
        if("".equals(studentInformation.getGraduate_middle())||null!=studentInformation.getGraduate_middle()){
            return  JsonUtil.error("毕业中学不能为空！");
        }
        if("".equals(studentInformation.getExaminee_number())||null!=studentInformation.getExaminee_number()){
            return  JsonUtil.error("考生号码不能为空！");
        }
        if("".equals(studentInformation.getSubject_type())||null!=studentInformation.getSubject_type()){
            return  JsonUtil.error("文理科不能为空！");
        }
        if("".equals(studentInformation.getMember_name())||null!=studentInformation.getMember_name()){
            return  JsonUtil.error("家庭联络员姓名不能为空！");
        }
        if("".equals(studentInformation.getMember_relationship())||null!=studentInformation.getMember_relationship()){
            return  JsonUtil.error("家庭联络员关系不能为空！");
        }
        if("".equals(studentInformation.getMember_occupation())||null!=studentInformation.getMember_occupation()){
            return  JsonUtil.error("家庭联络员职业不能为空！");
        }
        if("".equals(studentInformation.getMember_work())||null!=studentInformation.getMember_work()){
            return  JsonUtil.error("家庭联络员工作单位不能为空！");
        }
        if("".equals(studentInformation.getMember_phone())||null!=studentInformation.getMember_phone()){
            return  JsonUtil.error("主键不能为空！");
        }
        if("".equals(studentInformation.getPhotograph())||null!=studentInformation.getPhotograph()){
            return  JsonUtil.error("正面照不能为空！");
        }
        studentInformation.setStudent_id(UUID.randomUUID().toString().replaceAll("\\-", ""));
        if(studentInformationService.addStudentInformation(studentInformation)>0){
            j.setMsg("保存成功");
        }else{
            j.setMsg("保存失败");
            j.setFlag(false);
        }
        return j;
    }
     @Log(desc = "用户退出平台")
     @GetMapping(value = "/out")
     public String out() throws IOException {
         CurrentUser user = ShiroUtil.getCurrentUse();
         if (user != null) {
             userService.updateByIdStatus(user.getId(), 0);
         }
             return "redirect:logout";
    }
    @Log(desc = "查询学生基本信息并显示添加页面")
    @GetMapping(value = "/getBasicInformation")
    public String getBasicInformation(Model model){
        CurrentUser user = ShiroUtil.getCurrentUse();
        StudentInformation studentInformation=studentInformationService.getUserIDByStudentInformation(user.getUsername());
        if(studentInformation!=null){
            model.addAttribute("BasicInformation",studentInformation);
        }
        return "basicInformation";
    }
    @Log(desc = "跳转到网上报考页面")
    @GetMapping(value = "/getOnlineExamination")
    public String getOnlineExamination(Model model){
        return "onlineExamination";
    }

}
