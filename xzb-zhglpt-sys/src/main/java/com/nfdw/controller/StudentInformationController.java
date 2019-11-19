package com.nfdw.controller;

import com.nfdw.core.annotation.Log;
import com.nfdw.core.shiro.ShiroUtil;
import com.nfdw.entity.CurrentUser;
import com.nfdw.entity.StudentInformation;
import com.nfdw.entity.SysUser;
import com.nfdw.service.StudentInformationService;
import com.nfdw.service.SysUserService;
import com.nfdw.util.JsonUtil;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;
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

    @Log(desc = "跳转到报考查询")
    @GetMapping(value = "/getExamQuary")
    public String getExamQuary(Model model){
        return "examQuary";
    }

    @Log(desc = "跳转到学生报考首页")
    @GetMapping(value = "/getStudentIndex")
    public String getStudentIndex(Model model){
        return "studentIndex";
    }

    @PostMapping(value= "addStudentInformations")
    public String addStudentInformations(StudentInformation studentInformation,Model model,HttpServletRequest request, HttpServletResponse response){
        if("".equals(studentInformation.getCertificate_type())||null!=studentInformation.getCertificate_type()){
            model.addAttribute("1","证件类型不能为空!");
        }
        if("".equals(studentInformation.getPostal_code())||null!=studentInformation.getPostal_code()){
            model.addAttribute("1","邮政编码不能为空!");
        }
        if("".equals(studentInformation.getExaminee_type())||null!=studentInformation.getExaminee_type()){
            model.addAttribute("1","考生类型不能为空!");
        }
        if("".equals(studentInformation.getExaminee_education())||null!=studentInformation.getExaminee_education()){
            model.addAttribute("1","考生学历不能为空!");
        }
        if("".equals(studentInformation.getExaminee_province())||null!=studentInformation.getExaminee_province()){
            model.addAttribute("1","考生省份不能为空!");
        }
        if("".equals(studentInformation.getPolitics_status())||null!=studentInformation.getPolitics_status()){
            model.addAttribute("1","政治面貌不能为空!");
        }
        if("".equals(studentInformation.getGraduate_type())||null!=studentInformation.getGraduate_type()){
            model.addAttribute("1","应往届不能为空!");
        }
        if("".equals(studentInformation.getGraduate_middle())||null!=studentInformation.getGraduate_middle()){
            model.addAttribute("1","毕业中学不能为空!");
        }
        if("".equals(studentInformation.getExaminee_number())||null!=studentInformation.getExaminee_number()){
            model.addAttribute("1","考生号码不能为空!");
        }
        if("".equals(studentInformation.getSubject_type())||null!=studentInformation.getSubject_type()){
            model.addAttribute("1","文理科不能为空!");
        }
        if("".equals(studentInformation.getMember_name())||null!=studentInformation.getMember_name()){
            model.addAttribute("1","家庭联络员姓名不能为空!");
        }
        if("".equals(studentInformation.getMember_relationship())||null!=studentInformation.getMember_relationship()){
            model.addAttribute("1","家庭联络员关系不能为空!");
        }
        if("".equals(studentInformation.getMember_occupation())||null!=studentInformation.getMember_occupation()){
            model.addAttribute("1","家庭联络员职业不能为空!");
        }
        if("".equals(studentInformation.getMember_work())||null!=studentInformation.getMember_work()){
            model.addAttribute("1","家庭联络员工作单位不能为空!");
        }
        if("".equals(studentInformation.getMember_phone())||null!=studentInformation.getMember_phone()){
            model.addAttribute("1","主键不能为空!");
        }
        if("".equals(studentInformation.getPhotograph())||null!=studentInformation.getPhotograph()){
            model.addAttribute("1","正面照不能为空！");
        }
        DiskFileItemFactory factory = new DiskFileItemFactory();// 创建磁盘工厂
        factory.setSizeThreshold(10 * 1096);// 将文件保存在内存还是磁盘临时文件夹的默认临界值，值为10240，即10kb
        ServletFileUpload upload = new ServletFileUpload(factory);// 创建处理工具
        upload.setSizeMax(2048 * 1024 * 1024);// 服务器端可以接收的最大文件大小，-1表示无上限
        //指定文件的保存路径
        String uploadPath = request.getSession().getServletContext().getRealPath("/") + File.separator + "upload";
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
        try {
            // 解析请求的内容提取文件数据
            List<FileItem> formItems = upload.parseRequest(request);
            if (formItems != null && formItems.size() > 0) {
                // 迭代表单数据
                for (FileItem item : formItems) {
                    // 处理不在表单中的字段
                    if (!item.isFormField()) {
                        String fileName = new File(item.getName()).getName();
                        if (fileName!=null&&fileName.length()>0) {
                            String filePath = uploadPath + File.separator + fileName;
                            File storeFile = new File(filePath);
                            // 保存文件到硬盘
                            item.write(storeFile);
                            //同步user的图片信息
                            studentInformation.setPhotograph("upload/" +fileName);
                            System.out.println("upload/" +fileName);
                        }
                    }else {
                        if (item.getFieldName().equals("certificate_type")) {//如果名称是这个
                            String certificate_type = item.getString();//获取名称对应的值
                            studentInformation.setCertificate_type(certificate_type);
                        }else if (item.getFieldName().equals("certificate_number")) {//如果名称是这个
                            String certificate_number = item.getString();//获取名称对应的值
                            studentInformation.setCertificate_number(certificate_number);
                        }else if (item.getFieldName().equals("name")) {//如果名称是这个
                            String name = item.getString();//获取名称对应的值
                            studentInformation.setName(name);
                        }else if (item.getFieldName().equals("sex")) {//如果名称是这个
                            String sex = item.getString();//获取名称对应的值
                            studentInformation.setSex(sex);
                        }else if (item.getFieldName().equals("nation")) {//如果名称是这个
                            String nation = item.getString();//获取名称对应的值
                            studentInformation.setNation(nation);
                        }else if (item.getFieldName().equals("birthdate")) {//如果名称是这个
                            String birthdate = item.getString();//获取名称对应的值
                            studentInformation.setBirthdate(birthdate);
                        }else if (item.getFieldName().equals("street")) {//如果名称是这个
                            String street = item.getString();//获取名称对应的值
                            studentInformation.setStreet(street);
                        }else if (item.getFieldName().equals("recipient")) {//如果名称是这个
                            String recipient = item.getString();//获取名称对应的值
                            studentInformation.setRecipient(recipient);
                        }else if (item.getFieldName().equals("phone")) {//如果名称是这个
                            String phone = item.getString();//获取名称对应的值
                            studentInformation.setPhone(phone);
                        }else if (item.getFieldName().equals("postal_code")) {//如果名称是这个
                            String postal_code = item.getString();//获取名称对应的值
                            studentInformation.setPostal_code(postal_code);
                        }else if (item.getFieldName().equals("email")) {//如果名称是这个
                            String email = item.getString();//获取名称对应的值
                            studentInformation.setEmail(email);
                        }else if (item.getFieldName().equals("examinee_type")) {//如果名称是这个
                            String examinee_type = item.getString();//获取名称对应的值
                            studentInformation.setExaminee_type(examinee_type);
                        }else if (item.getFieldName().equals("examinee_education")) {//如果名称是这个
                            String examinee_education = item.getString();//获取名称对应的值
                            studentInformation.setExaminee_education(examinee_education);
                        }else if (item.getFieldName().equals("examinee_province")) {//如果名称是这个
                            String examinee_province = item.getString();//获取名称对应的值
                            studentInformation.setExaminee_province(examinee_province);
                        }else if (item.getFieldName().equals("politics_status")) {//如果名称是这个
                            String politics_status = item.getString();//获取名称对应的值
                            studentInformation.setPolitics_status(politics_status);
                        }else if (item.getFieldName().equals("graduate_type")) {//如果名称是这个
                            String graduate_type = item.getString();//获取名称对应的值
                            studentInformation.setGraduate_type(graduate_type);
                        }else if (item.getFieldName().equals("graduate_middle")) {//如果名称是这个
                            String graduate_middle = item.getString();//获取名称对应的值
                            studentInformation.setGraduate_middle(graduate_middle);
                        }else if (item.getFieldName().equals("examinee_number")) {//如果名称是这个
                            String examinee_number = item.getString();//获取名称对应的值
                            studentInformation.setExaminee_number(examinee_number);
                        }else if (item.getFieldName().equals("subject_type")) {//如果名称是这个
                            String subject_type = item.getString();//获取名称对应的值
                            studentInformation.setSubject_type(subject_type);
                        }else if (item.getFieldName().equals("member_name")) {//如果名称是这个
                            String member_name = item.getString();//获取名称对应的值
                            studentInformation.setMember_name(member_name);
                        }else if (item.getFieldName().equals("member_relationship")) {//如果名称是这个
                            String member_relationship = item.getString();//获取名称对应的值
                            studentInformation.setMember_relationship(member_relationship);
                        }else if (item.getFieldName().equals("member_occupation")) {//如果名称是这个
                            String member_occupation = item.getString();//获取名称对应的值
                            studentInformation.setMember_occupation(member_occupation);
                        }else if (item.getFieldName().equals("member_work")) {//如果名称是这个
                            String member_work = item.getString();//获取名称对应的值
                            studentInformation.setMember_work(member_work);
                        }else if (item.getFieldName().equals("member_phone")) {//如果名称是这个
                            String member_phone = item.getString();//获取名称对应的值
                            studentInformation.setMember_phone(member_phone);
                        }

                    }

                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        studentInformation.setStudent_id(UUID.randomUUID().toString().replaceAll("\\-", ""));
        CurrentUser user = ShiroUtil.getCurrentUse();
        SysUser sysUser=userService.getSysUserByUsername(user.getUsername());
        studentInformation.setStudent_userid(sysUser.getId());
        return "";
    }
}
