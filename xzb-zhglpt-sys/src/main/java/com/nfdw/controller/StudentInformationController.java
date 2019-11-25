package com.nfdw.controller;

import com.nfdw.ConverVideoTest;
import com.nfdw.core.annotation.Log;
import com.nfdw.core.shiro.ShiroUtil;
import com.nfdw.entity.*;
import com.nfdw.service.AchievementService;
import com.nfdw.service.AuditService;
import com.nfdw.service.StudentInformationService;
import com.nfdw.service.SysUserService;
import com.nfdw.util.UploadUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.io.File;
import java.text.ParseException;
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
    private static final String UPLOAD_DIRECTORY = "temp-rainy";

    // 上传配置
    private static final int MEMORY_THRESHOLD   = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE      = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE   = 1024 * 1024 * 50; // 50MB
    @Autowired
    StudentInformationService studentInformationService;
    @Autowired
    private SysUserService userService;
    @Autowired
    AchievementService acService;
    @Autowired
    AuditService auditService;
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
            model.addAttribute("studentInformation",studentInformation);
        }
        return "basicInformation";
    }
    @Log(desc = "跳转到网上报考页面")
    @GetMapping(value = "/getOnlineExamination")
    public String getOnlineExamination(Model model){
        CurrentUser user = ShiroUtil.getCurrentUse();
        StudentInformation studentInformation=studentInformationService.getUserIDByStudentInformation(user.getUsername());
        if(studentInformation!=null){
            model.addAttribute("studentInformation",studentInformation);
        }
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
        SysUser user= (SysUser) ShiroUtil.getSession().getAttribute("user");
        StudentInformation studentInfo = studentInformationService.getStudentInfoByUserId(user.getId());
        model.addAttribute("student", studentInfo);
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
    @RequestMapping(value="/getSelectExam")
    @PostMapping
    public String getSelectExam(String exam,String name,String create_start_time,Model model) throws ParseException {
        Date date =new Date();
        CurrentUser user = ShiroUtil.getCurrentUse();
        StudentInformation studentInformation=studentInformationService.getUserIDByStudentInformation(user.getUsername());
//        if (null!=studentInformation) {
//            throw new RuntimeException("已经存在当前考生信息");
//        }
//        Date currentTime = new Date();
//改变输出格式（自己想要的格式）
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//得到字符串时间
        String s8 = formatter.format(date);
        studentInformation.setCurrentDate(s8);
        List<Examination> examinationList=studentInformationService.getListExamination(studentInformation.getCurrentDate(),studentInformation.getExaminee_province(),
                studentInformation.getSubject_type(),exam,name,create_start_time);
        for (Examination e:examinationList
        ) {
            //System.out.print(e.getName()+","+e.getCreate_start_time()+"111111111111");
        }
        model.addAttribute("examinationList",examinationList);
        model.addAttribute("exam",exam);
        model.addAttribute("name",name);
        model.addAttribute("create_start_time",create_start_time);
        return "selectExam";
    }

    @Autowired
    UploadUtil uploadUtil;

    @RequestMapping(value="/getSelectExams", produces={"application/json; charset=UTF-8"})
    @ResponseBody
    public List<Examination> getSelectExams(String exam,String name,String create_start_time) {
        Date date =new Date();
        CurrentUser user = ShiroUtil.getCurrentUse();
        StudentInformation studentInformation=studentInformationService.getUserIDByStudentInformation(user.getUsername());
        System.out.print(studentInformation.getExaminee_province()+"111111111111");
//        Date currentTime = new Date();
//改变输出格式（自己想要的格式）
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//得到字符串时间
        String s8 = formatter.format(date);
        studentInformation.setCurrentDate(s8);
        List<Examination> examinationList=studentInformationService.getListExamination(studentInformation.getCurrentDate(),studentInformation.getExaminee_province(),
                studentInformation.getSubject_type(),exam,name,create_start_time);
        return examinationList;
    }
    @PostMapping(value= "addStudentInformations")
    public String addStudentInformations(HttpSession session, StudentInformation studentInformation, @RequestParam("file")MultipartFile file,Model model, HttpServletRequest request) throws IOException {
        studentInformation.setStudent_id(UUID.randomUUID().toString().replaceAll("\\-", ""));
        CurrentUser user = ShiroUtil.getCurrentUse();
        if(studentInformationService.getStudentInfoConunt(user.getUsername())==0){
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


            String upload = uploadUtil.upload(file);
            studentInformation.setPhotograph(upload);

            SysUser sysUser=userService.getSysUserByUsername(user.getUsername());
            studentInformation.setStudent_userid(sysUser.getId());
            if(studentInformationService.addStudentInformation(studentInformation)>0){
                model.addAttribute("rel","添加成功！");
                if(studentInformation!=null){
                    model.addAttribute("studentInformation",studentInformation);
                }
                return "onlineExamination";
            }else{
                model.addAttribute("rel","添加失败！");
                return "basicInformation";
            }
        }else{
            return "redirect:getSelectExam";
        }
    }
    @PostMapping(value= "addStudentInformationss")
    public String addStudentInformationss(HttpSession session, StudentInformation studentInformation, @RequestParam("file")MultipartFile file,Model model, HttpServletRequest request) throws IOException {
        studentInformation.setStudent_id(UUID.randomUUID().toString().replaceAll("\\-", ""));
        CurrentUser user = ShiroUtil.getCurrentUse();
        if(studentInformationService.getStudentInfoConunt(user.getUsername())==0){
            if("".equals(studentInformation.getCertificate_type())||null==studentInformation.getCertificate_type()){
                model.addAttribute("rel","证件类型不能为空!");
                return "onlineExamination";
            }
            if("".equals(studentInformation.getCertificate_number())||null==studentInformation.getCertificate_number()){
                model.addAttribute("rel","证件号码不能为空!");
                return "onlineExamination";
            }
            if("".equals(studentInformation.getNation())||null==studentInformation.getNation()){
                model.addAttribute("rel","民族不能为空!");
                return "onlineExamination";
            }
            if("".equals(studentInformation.getName())||null==studentInformation.getName()){
                model.addAttribute("rel","姓名不能为空!");
                return "onlineExamination";
            }
            if("".equals(studentInformation.getBirthdate())||null==studentInformation.getBirthdate()){
                model.addAttribute("rel","出生日期不能为空!");
                return "onlineExamination";
            }
            if("".equals(studentInformation.getSex())||null==studentInformation.getSex()){
                model.addAttribute("rel","性别不能为空!");
                return "onlineExamination";
            }
            if("".equals(studentInformation.getPostal_code())||null==studentInformation.getPostal_code()){
                model.addAttribute("rel","邮政编码不能为空!");
                return "onlineExamination";
            }
            if("".equals(studentInformation.getExaminee_type())||null==studentInformation.getExaminee_type()){
                model.addAttribute("rel","考生类型不能为空!");
                return "onlineExamination";
            }
            if("".equals(studentInformation.getExaminee_education())||null==studentInformation.getExaminee_education()){
                model.addAttribute("rel","考生学历不能为空!");
                return "onlineExamination";
            }
            if("".equals(studentInformation.getExaminee_province())||null==studentInformation.getExaminee_province()){
                model.addAttribute("rel","考生省份不能为空!");
                return "onlineExamination";
            }
            if("".equals(studentInformation.getPolitics_status())||null==studentInformation.getPolitics_status()){
                model.addAttribute("rel","政治面貌不能为空!");
                return "onlineExamination";
            }
            if("".equals(studentInformation.getGraduate_type())||null==studentInformation.getGraduate_type()){
                model.addAttribute("1","应往届不能为空!");
                return "onlineExamination";
            }
            if("".equals(studentInformation.getGraduate_middle())||null==studentInformation.getGraduate_middle()){
                model.addAttribute("rel","毕业中学不能为空!");
                return "onlineExamination";
            }
            if("".equals(studentInformation.getExaminee_number())||null==studentInformation.getExaminee_number()){
                model.addAttribute("rel","考生号码不能为空!");
                return "onlineExamination";
            }
            if("".equals(studentInformation.getSubject_type())||null==studentInformation.getSubject_type()){
                model.addAttribute("rel","文理科不能为空!");
                return "onlineExamination";
            }
            if("".equals(studentInformation.getMember_name())||null==studentInformation.getMember_name()){
                model.addAttribute("rel","家庭联络员姓名不能为空!");
                return "onlineExamination";
            }
            if("".equals(studentInformation.getMember_relationship())||null==studentInformation.getMember_relationship()){
                model.addAttribute("rel","家庭联络员关系不能为空!");
                return "onlineExamination";
            }
            if("".equals(studentInformation.getMember_occupation())||null==studentInformation.getMember_occupation()){
                model.addAttribute("rel","家庭联络员职业不能为空!");
                return "onlineExamination";
            }
            if("".equals(studentInformation.getMember_work())||null==studentInformation.getMember_work()){
                model.addAttribute("1","家庭联络员工作单位不能为空!");
                return "onlineExamination";
            }
            if("".equals(studentInformation.getMember_phone())||null==studentInformation.getMember_phone()){
                model.addAttribute("rel","主键不能为空!");
                return "onlineExamination";
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

//        if (file.isEmpty()) {
//            System.out.println("文件为空空");
//        }
//        String fileName = file.getOriginalFilename();  // 文件名
//        String suffixName = fileName.substring(fileName.lastIndexOf("."));  // 后缀名
//        String filePath = "D://temp-rainy//"; // 上传后的路径
//        fileName = UUID.randomUUID() + suffixName; // 新文件名
//        File dest = new File(filePath + fileName);
//        if (!dest.getParentFile().exists()) {
//            dest.getParentFile().mkdirs();
//        }
//        try {
//            file.transferTo(dest);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        String filename = "/temp-rainy/" + fileName;
//        studentInformation.setPhotograph(filename);



            SysUser sysUser=userService.getSysUserByUsername(user.getUsername());
            studentInformation.setStudent_userid(sysUser.getId());
            if(studentInformationService.addStudentInformation(studentInformation)>0){
                model.addAttribute("rel","添加成功！");
                if(studentInformation!=null){
                    model.addAttribute("studentInformation",studentInformation);
                }
                return "onlineExamination";
            }else{
                model.addAttribute("rel","添加失败！");
                return "basicInformation";
            }
        }else{
            return "redirect:getSelectExam";
        }
    }
    @RequestMapping(value = "/addVideo")
    public String uploadflie_Video(@RequestParam("file") CommonsMultipartFile file,
                                   HttpServletRequest req, HttpServletRequest request,Model model) {
        System.out.println("进入addVideo视频上传控制层");

        if (file.getSize() != 0) {
            //上传的多格式的视频文件-作为临时路径保存，转码以后删除-路径不能写//
            String path = "E:/Projectpicture/websiteimages/temp/";

            File TempFile = new File(path);
            if (TempFile.exists()) {
                if (TempFile.isDirectory()) {
                    System.out.println("该文件夹存在。");
                }else {
                    System.out.println("同名的文件存在，不能创建文件夹。");
                }
            }else {
                System.out.println("文件夹不存在，创建该文件夹。");
                TempFile.mkdir();
            }

            // 获取上传时候的文件名
            String filename = file.getOriginalFilename();

            // 获取文件后缀名
            String filename_extension = filename.substring(filename
                    .lastIndexOf(".") + 1);
            System.out.println("视频的后缀名:"+filename_extension);

            //时间戳做新的文件名，避免中文乱码-重新生成filename
            long filename1 = new Date().getTime();
            filename = Long.toString(filename1)+"."+filename_extension;

            //去掉后缀的文件名
            String filename2 = filename.substring(0, filename.lastIndexOf("."));
            System.out.println("视频名为:"+filename2);

            //源视频地址+重命名后的视频名+视频后缀
            String yuanPATH =(path+filename);

            System.out.println("视频的完整文件名1:"+filename);
            System.out.println("源视频路径为:"+yuanPATH);

            //上传到本地磁盘/服务器
            try {
                System.out.println("写入本地磁盘/服务器");
                InputStream is = file.getInputStream();
                OutputStream os = new FileOutputStream(new File(path, filename));
                int len = 0;
                byte[] buffer = new byte[2048];

                while ((len = is.read(buffer)) != -1) {
                    os.write(buffer, 0, len);
                }
                os.close();
                os.flush();
                is.close();
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            System.out.println("========上传完成，开始调用转码工具类=======");
            //调用转码机制flv mp4 f4v m3u8 webm ogg放行直接播放，
            //asx，asf，mpg，wmv，3gp，mov，avi，wmv9，rm，rmvb等进行其他转码为mp4

            if (filename_extension.equals("avi") || filename_extension.equals("rm")
                    || filename_extension.equals("rmvb") || filename_extension.equals("wmv")
                    || filename_extension.equals("3gp")  || filename_extension.equals("mov")
                    ||filename_extension.equals("flv")   || filename_extension.equals("ogg")

            ) {

                ConverVideoTest c = new ConverVideoTest();
                c.run(yuanPATH);   //调用转码
                System.out.println("=================转码过程彻底结束=====================");
            }

            //获取转码后的mp4文件名
            String Mp4path = "E://Projectpicture/websiteimages/finshvideo/";
            filename2 = filename2+".mp4";
            String NewVideopath =Mp4path +filename2;
            System.out.println("新视频的url:"+NewVideopath);

            //删除临时文件
            File file2 = new File(path);
            if (!file2.exists()) {
                System.out.println("没有该文件");
            }
            if (!file2.isDirectory()) {
                System.out.println("没有该文件夹");
            }
            String[] tempList = file2.list();
            File temp = null;
            for (int i = 0; i < tempList.length; i++) {
                if (path.endsWith(File.separator)) {
                    temp = new File(path + tempList[i]);
                } else {
                    temp = new File(path + File.separator + tempList[i]);
                }
                if (temp.isFile() || temp.isDirectory()) {
                    temp.delete();		//删除文件夹里面的文件
                }
            }
            System.out.println("所有的临时视频文件删除成功");


//            // 实例化用户类
//            tb_resource resource = new tb_resource();
//
//            //获取填写的相关信息
//            String title = request.getParameter("title");
//            String writer = request.getParameter("writer");
//            int state = Integer.parseInt(request.getParameter("state"));
//            String time = request.getParameter("time");
//            int clicks = Integer.parseInt(request.getParameter("clicks"));
//            int grade = Integer.parseInt(request.getParameter("grade"));
//            String subclass = request.getParameter("subclass");
//            int uid = Integer.parseInt(request.getParameter("uid"));
//
//            //数据库存储信息
//            resource.setTitle(title);
//            resource.setWriter(writer);
//            resource.setTime(time);
//            resource.setClicks(clicks);
//            resource.setGrade(grade);
//            resource.setSubclass(subclass);
//            resource.setState(state);
//            resource.setUid(uid);
//            resource.setSuffix(filename2);
//            resource.setUrl(NewVideopath); 			//已转码后的视频存放地址

            // 实现对数据的更新
//            int n = 0;
//            n = tb_resourceService.insertResource(resource);
//
//            if (n != 0) {
//                return new ModelAndView("back/public/success").addObject(
//                        "notice", "resourceList?uid=" + uid
//                                + "&grade=-1&state=-1&subclass=" + subclass);
//            } else {
//                return new ModelAndView("back/public/fail").addObject("notice",
//                        "resourceList?uid=" + uid
//                                + "&grade=-1&state=-1&subclass=" + subclass);
//            }
        }
        return null;
    }
    @PostMapping(value = "/addStudent_examAudit")
    public String addStudent_examAudit(String exam,String aname,String build,String create_start_time,Model model){
        CurrentUser user = ShiroUtil.getCurrentUse();
        StudentInformation studentInformation=studentInformationService.getUserIDByStudentInformation(user.getUsername());
        if("".equals(exam)||null==exam){
            model.addAttribute("rel","考试名称不能为空!");
            return "selectExams";
        }
//        if("".equals(name)||null==name){
//            model.addAttribute("rel","专业不能为空！");
//            return "selectExams";
//        }
        if("".equals(build)||null==build){
            model.addAttribute("rel","考试地点不能为空!");
            return "selectExams";
        }
        if("".equals(create_start_time)||null==create_start_time){
            model.addAttribute("rel","家庭联络员工作单位不能为空!");
            return "selectExams";
        }
        StudentExamAudit studentExamAudit=new StudentExamAudit();
        Date date =new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//得到字符串时间
        String s8 = formatter.format(date);
        studentExamAudit.setInformationId(studentInformation.getStudent_id());
        studentExamAudit.setExamId(exam);
        studentExamAudit.setManagementId(aname);
        studentExamAudit.setExamTime(create_start_time);
        studentExamAudit.setKaoChangId(build);
        studentExamAudit.setAgreement(0);
        studentExamAudit.setTime(s8);
        studentInformationService.addStudentExamAudit(studentExamAudit);

        Audit audit = new Audit();
        audit.setU_id(studentInformation.getStudent_userid());
        audit.setName(studentInformation.getName());
        audit.setBiog_land(studentInformation.getExaminee_province());
        audit.setExaminee_number(studentInformation.getExaminee_number());
        Examination eax2 = acService.selectExamination(exam,aname);
        audit.setExam_id(Integer.valueOf(eax2.getId()));
        audit.setExam_name(exam);
        audit.setMajor_id(Integer.valueOf(eax2.getSpecialty_id()));
        audit.setMajor(aname);
        audit.setSub_time(date);
        audit.setEnd_time(date);
        audit.setInfo_collect_status("待审核");
        if(eax2.getCheck_pay()==0)
            audit.setAudit_link("交费前");
        else
            audit.setAudit_link("交费后");
        audit.setPay_status("已缴费");
        audit.setAudit_status("待审核");
        if (auditService.addAudit(audit))
            System.out.println("向审核送出一条数据-----------");
        return "informationGather";
    }
}