package com.nfdw.controller;

import com.nfdw.core.annotation.Log;
import com.nfdw.core.shiro.ShiroUtil;
import com.nfdw.entity.CurrentUser;
import com.nfdw.entity.Examination;
import com.nfdw.entity.StudentInformation;
import com.nfdw.entity.SysUser;
import com.nfdw.service.StudentInformationService;
import com.nfdw.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
@Controller
@RequestMapping(value = "/studentInformation")
public class StudentInformationController {
    private static final long serialVersionUID = 1L;

    // 上传文件存储目录
    private static final String UPLOAD_DIRECTORY = "app";

    // 上传配置
    private static final int MEMORY_THRESHOLD   = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE      = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE   = 1024 * 1024 * 50; // 50MB
    @Autowired
    StudentInformationService studentInformationService;
    @Autowired
    private SysUserService userService;
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

    @Log(desc = "跳转到报考查询")
    @GetMapping(value = "/getExamQuary")
    public String getExamQuary(Model model){
        return "examQuary";
    }
    @Log(desc = "跳转到准考证")
    @GetMapping(value = "/getAdmissionTicket")
    public String getAdmissionTicket(Model model){
        return "admissionTicket";
    }
    @Log(desc = "跳转到合格证")
    @GetMapping(value = "/getCertificateQualification")
    public String getCertificateQualification(Model model){
        return "certificateQualification";
    }
    @Log(desc = "跳转到学生报考首页")
    @GetMapping(value = "/getStudentIndex")
    public String getStudentIndex(Model model){
        return "studentIndex";
    }
    @Log(desc = "跳转到成功页面")
    @GetMapping(value = "/getSucceed")
    public String getSucceed(Model model){
        return "succeed";
    }
    @Log(desc = "跳转到支付")
    @GetMapping(value = "/getPayment")
    public String getPayment(Model model){
        return "payment";
    }
    @Log(desc = "跳转到缴费页面")
    @GetMapping(value = "/getPayFees")
    public String getPayFees(Model model){
        return "payFees";
    }
    @Log(desc = "跳转到信息采集")
    @GetMapping(value = "/getInformationGather")
    public String getInformationGather(Model model){
        return "informationGather";
    }
    @Log(desc = "跳转到选择报考")
    @GetMapping(value = "/getSelectExam")
    public String getSelectExam(Model model){
//        CurrentUser user = ShiroUtil.getCurrentUse();
//        StudentInformation studentInformation=studentInformationService.getUserIDByStudentInformation(user.getUsername());
//        Date date = new Date();
//        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        List<Examination> examinationList=studentInformationService.getListExamination(studentInformation,sf.format(date));
//        model.addAttribute("examinationList",examinationList);
        return "selectExam";
    }

    @PostMapping(value= "addStudentInformations")
    public String addStudentInformations(HttpSession session, StudentInformation studentInformation, @RequestParam("file")MultipartFile file,Model model, HttpServletRequest request) throws IOException {
        if("".equals(studentInformation.getCertificate_type())||null==studentInformation.getCertificate_type()){
            model.addAttribute("rel","证件类型不能为空!");
            return "basicInformation";
        }
        if("".equals(studentInformation.getCertificate_number())||null==studentInformation.getCertificate_number()){
            model.addAttribute("rel","证件号码不能为空!");
            return "basicInformation";
        }
        if("".equals(studentInformation.getNation())||null==studentInformation.getNation()){
            model.addAttribute("rel","民族不能为空!");
            return "basicInformation";
        }
        if("".equals(studentInformation.getName())||null==studentInformation.getName()){
            model.addAttribute("rel","姓名不能为空!");
            return "basicInformation";
        }
        if("".equals(studentInformation.getBirthdate())||null==studentInformation.getBirthdate()){
            model.addAttribute("rel","出生日期不能为空!");
            return "basicInformation";
        }
        if("".equals(studentInformation.getSex())||null==studentInformation.getSex()){
            model.addAttribute("rel","性别不能为空!");
            return "basicInformation";
        }
        if("".equals(studentInformation.getPostal_code())||null==studentInformation.getPostal_code()){
            model.addAttribute("rel","邮政编码不能为空!");
            return "basicInformation";
        }
        if("".equals(studentInformation.getExaminee_type())||null==studentInformation.getExaminee_type()){
            model.addAttribute("rel","考生类型不能为空!");
            return "basicInformation";
        }
        if("".equals(studentInformation.getExaminee_education())||null==studentInformation.getExaminee_education()){
            model.addAttribute("rel","考生学历不能为空!");
            return "basicInformation";
        }
        if("".equals(studentInformation.getExaminee_province())||null==studentInformation.getExaminee_province()){
            model.addAttribute("rel","考生省份不能为空!");
            return "basicInformation";
        }
        if("".equals(studentInformation.getPolitics_status())||null==studentInformation.getPolitics_status()){
            model.addAttribute("rel","政治面貌不能为空!");
            return "basicInformation";
        }
        if("".equals(studentInformation.getGraduate_type())||null==studentInformation.getGraduate_type()){
            model.addAttribute("1","应往届不能为空!");
            return "basicInformation";
        }
        if("".equals(studentInformation.getGraduate_middle())||null==studentInformation.getGraduate_middle()){
            model.addAttribute("rel","毕业中学不能为空!");
            return "basicInformation";
        }
        if("".equals(studentInformation.getExaminee_number())||null==studentInformation.getExaminee_number()){
            model.addAttribute("rel","考生号码不能为空!");
            return "basicInformation";
        }
        if("".equals(studentInformation.getSubject_type())||null==studentInformation.getSubject_type()){
            model.addAttribute("rel","文理科不能为空!");
            return "basicInformation";
        }
        if("".equals(studentInformation.getMember_name())||null==studentInformation.getMember_name()){
            model.addAttribute("rel","家庭联络员姓名不能为空!");
            return "basicInformation";
        }
        if("".equals(studentInformation.getMember_relationship())||null==studentInformation.getMember_relationship()){
            model.addAttribute("rel","家庭联络员关系不能为空!");
            return "basicInformation";
        }
        if("".equals(studentInformation.getMember_occupation())||null==studentInformation.getMember_occupation()){
            model.addAttribute("rel","家庭联络员职业不能为空!");
            return "basicInformation";
        }
        if("".equals(studentInformation.getMember_work())||null==studentInformation.getMember_work()){
            model.addAttribute("1","家庭联络员工作单位不能为空!");
            return "basicInformation";
        }
        if("".equals(studentInformation.getMember_phone())||null==studentInformation.getMember_phone()){
            model.addAttribute("rel","主键不能为空!");
            return "basicInformation";
        }

        //获取存储app文件夹的路径
        String appPath = session.getServletContext().getRealPath("/app");
        File appRootDir = new File(appPath);
        if (!appRootDir.exists()) {
            System.out.println("存储app的文件夹不存在 appPath= " + appPath);
            appRootDir.mkdirs();
        } else {
            System.out.println("存储app的文件夹存在 appPath= " + appPath);
        }
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());

        if (multipartResolver.isMultipart(request)) {
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;

            Iterator<String> names = multiRequest.getFileNames();
            while (names.hasNext()) {
                MultipartFile file1 = multiRequest.getFile(names.next().toString());
                if (file1 != null) {
                    File appFile = new File(appRootDir, file1.getOriginalFilename());
                    file1.transferTo(appFile);
                    String fileName = file.getOriginalFilename();
                    // 获取文件的后缀名
                    //String suffixName = fileName.substring(fileName.lastIndexOf("."));
                    studentInformation.setPhotograph(appFile.getPath());
                    System.out.println(appFile.getPath());
                }

            }
        }
        studentInformation.setStudent_id(UUID.randomUUID().toString().replaceAll("\\-", ""));
        CurrentUser user = ShiroUtil.getCurrentUse();
        SysUser sysUser=userService.getSysUserByUsername(user.getUsername());
        studentInformation.setStudent_userid(sysUser.getId());
        if(studentInformationService.addStudentInformation(studentInformation)>0){
            model.addAttribute("rel","添加成功！");
            return "onlineExamination";
        }else{
            model.addAttribute("rel","添加失败！");
            return "basicInformation";
        }
    }
}
