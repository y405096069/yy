package com.nfdw.controller;

import com.alibaba.fastjson.JSONObject;
import com.nfdw.core.annotation.Log;
import com.nfdw.entity.*;
import com.nfdw.exception.MyException;
import com.nfdw.service.ExaminationService;
import com.nfdw.service.Infor_CollectionService;
import com.nfdw.service.SubjectService;
import com.nfdw.util.JsonUtil;
import com.nfdw.util.ReType;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.*;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.beans.Transient;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * @Auther: EagleJunBin
 * @Date: 2019/11/12
 * @Description: 考试表
 */
@RequestMapping("/examination")
@Controller
public class ExaminationController {

    @Autowired
    SubjectService subjectService;

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
        List<Infor_collection> list = examinationService.selectcollection();
        //查询所有的科目
        List<Subject> subjectList = examinationService.selectBySubject();
        //查询所有的专业
        List<SpecManagement> specList = examinationService.selectBySpec();

       model.addAttribute("subjectList",subjectList);
        model.addAttribute("info_list",list);
        model.addAttribute("specList",specList);
        return "/system/examination/add-examination";
    }

    //新建考试
    @ApiOperation(value = "/addExamination", httpMethod = " POST")
    @PostMapping(value = "addExamination")
    @ResponseBody
    @Transactional
    public JsonUtil addExamination(Examination examination, HttpServletRequest request,Model model) {
       /* if (StringUtils.isEmpty(examination.getExam())) {
            JsonUtil.error("考试名称不能为空");
        }*/
        JsonUtil j = new JsonUtil();

        try {
           /* if(null==examination.getCreate_end_time()){
                examination.setCreate_end_time(new Date());
            }
            if(null==examination.getCreate_time()){
                examination.setCreate_time(new Date());
            }
            if(null==examination.getUpdate_time()){
                examination.setUpdate_time(new Date());
            } if(null==examination.getExam_time()){
                examination.setExam_time(new Date());
            }
            if(null==examination.getEnd_time()){
                examination.setEnd_time(new Date());
            }
            if(null==examination.getCreate_start_time()){
                examination.setCreate_start_time(new Date());
            }*/


            if(examination.getPrologue().length()<8) {
                int a = 8 - examination.getPrologue().length();
                StringBuilder str = new StringBuilder();
                //定义变长字符串
                Random random = new Random();
                //随机生成数字，并添加到字符串
                for (int i = 0; i < a; i++) {
                    str.append(random.nextInt(10));
                }
                examination.setPrologue(examination.getPrologue()+ str.toString());
            }



              List<Examination> li = examinationService.selectpa();
            for(int i=0;i<li.size();i++){
                if(null!=li.get(i)){
                    if(examination.getPrologue().equals(li.get(i))){
                        j.setMsg("保存失败");
                        return j;
                    }
                }
            }


            if(null!=request.getSession().getAttribute("path1")){
                examination.setCreate_disclaimer(request.getSession().getAttribute("path1").toString());
            }
            if(null!=request.getSession().getAttribute("path2")){
                examination.setQtfj(request.getSession().getAttribute("path2").toString());
            }
            //设置成绩状态默认为 不开启 0:关闭 1：开启
            examinationService.addExamination(examination);
            Kc kc = new Kc();
            Cskmqz cskmqz = new Cskmqz();
            Fskmqz fskm = new Fskmqz();
            String cs = examination.getCskm();
            String stra = examination.getKca();
            String fs = examination.getFskm();
            String result [] = stra.split(",");
            String results [] = cs.split(",");

            String fskmqz[] = fs.split(",");

            for(int i = 0;i<results.length;i++){
                if(null!=results[i]&&""!=results[i]){
                    if(i<3){
                        cskmqz.setKmid(results[0]);
                        cskmqz.setExam_id(examination.getId());
                        cskmqz.setKmzf(results[1]);
                        cskmqz.setKmqz(results[2]);
                        if(i==2){
                            examinationService.addcskm(cskmqz);
                        }
                    }
                    if(i>2&&i<6){
                        cskmqz.setKmid(results[3]);
                        cskmqz.setExam_id(examination.getId());
                        cskmqz.setKmzf(results[4]);
                        cskmqz.setKmqz(results[5]);
                        if(i==5){
                            examinationService.addcskm(cskmqz);
                        }
                    }
                    if(i>5&&i<9){
                        cskmqz.setKmid(results[6]);
                        cskmqz.setExam_id(examination.getId());
                        cskmqz.setKmzf(results[7]);
                        cskmqz.setKmqz(results[8]);
                        if(i==8){
                            examinationService.addcskm(cskmqz);
                        }
                    }
                    if(i>8&&i<12){
                        cskmqz.setKmid(results[9]);
                        cskmqz.setExam_id(examination.getId());
                        cskmqz.setKmzf(results[10]);
                        cskmqz.setKmqz(results[11]);
                        if(i==11){
                            examinationService.addcskm(cskmqz);
                        }
                    }
                }
            }
            for(int x = 0 ; x < result.length ; x++)

            {
                if(null!=result[x]&&""!=result[x]) {
                    if (x < 4) {
                        kc.setKcreate_start_time(result[0]);
                        kc.setKcreate_end_time(result[1]);
                        kc.setExam_id(examination.getId().toString());
                        kc.setSpec_id(examination.getSpecialty_id());
                        kc.setBkrs(result[2]);
                        kc.setKcwz(result[3]);
                        if (x == 3) {
                            examinationService.addkc(kc);
                        }
                    } else if (x > 3 && x < 8) {
                        kc.setKcreate_start_time(result[4]);
                        kc.setKcreate_end_time(result[5]);
                        kc.setExam_id(examination.getId().toString());
                        kc.setSpec_id(examination.getSpecialty_id());
                        kc.setBkrs(result[6]);
                        kc.setKcwz(result[7]);
                        if (x == 7) {
                            examinationService.addkc(kc);
                        }
                    } else if (x > 7 && x < 12) {
                        kc.setKcreate_start_time(result[8]);
                        kc.setKcreate_end_time(result[9]);
                        kc.setExam_id(examination.getId().toString());
                        kc.setSpec_id(examination.getSpecialty_id());
                        kc.setBkrs(result[10]);
                        kc.setKcwz(result[11]);
                        if (x == 11) {
                            examinationService.addkc(kc);
                        }
                    } else if (x > 11 && x < 16) {
                        kc.setKcreate_start_time(result[12]);
                        kc.setKcreate_end_time(result[13]);
                        kc.setExam_id(examination.getId().toString());
                        kc.setSpec_id(examination.getSpecialty_id());
                        kc.setBkrs(result[14]);
                        kc.setKcwz(result[15]);
                        if (x == 15) {
                            examinationService.addkc(kc);
                        }
                    }

                }
            }
            for(int i = 0; i <fskmqz.length;i++){
                if(null!=fskmqz[i]&&""!=fskmqz[i]){
                    if(i<3){
                        fskm.setFskmid(fskmqz[0]);
                        fskm.setExam_id(examination.getId());
                        fskm.setFskmzf(fskmqz[1]);
                        fskm.setFskmqz(fskmqz[2]);
                        if(i==2){
                            examinationService.addfskm(fskm);
                        }
                    }
                    if(i>2&&i<6){
                        fskm.setFskmid(fskmqz[3]);
                        fskm.setExam_id(examination.getId());
                        fskm.setFskmzf(fskmqz[4]);
                        fskm.setFskmqz(fskmqz[5]);
                        if(i==5){
                            examinationService.addfskm(fskm);
                        }
                    }
                    if(i>5&&i<9){
                        fskm.setFskmid(fskmqz[6]);
                        fskm.setExam_id(examination.getId());
                        fskm.setFskmzf(fskmqz[7]);
                        fskm.setFskmqz(fskmqz[8]);
                        if(i==8){
                            examinationService.addfskm(fskm);
                        }
                    }
                    if(i>8&&i<12){
                        fskm.setFskmid(fskmqz[9]);
                        fskm.setExam_id(examination.getId());
                        fskm.setFskmzf(fskmqz[10]);
                        fskm.setFskmqz(fskmqz[11]);
                        if(i==12){
                            examinationService.addfskm(fskm);
                        }
                    }
                }
            }
            //操作role-menu data
            j.setMsg("保存成功");
        } catch (MyException e) {
            j.setMsg("保存失败");
            j.setFlag(false);
            e.printStackTrace();
        }
        return j;
    }




    //修改
   @ApiOperation(value = "/upExamination", httpMethod = "post", notes = "修改")
    @PostMapping(value = "/upExamination")
    @ResponseBody
    public JsonUtil updeteExamination(Examination examination, BindingResult bindingResult,HttpServletRequest request, Model model) {
       /* if (StringUtils.isEmpty(examination.getExam())) {
            JsonUtil.error("考试名称不能为空");
        }*/

        JsonUtil jsonUtil = new JsonUtil();
        jsonUtil.setFlag(false);
        if (examination == null) {
            jsonUtil.setMsg("获取数据失败");
            return jsonUtil;
        }
        try {
            examinationService.uplateById(examination);
            jsonUtil.setFlag(true);
            jsonUtil.setMsg("修改成功");
            //throw  new MyException("错误");
        } catch (MyException e) {
            e.printStackTrace();
        }
        return jsonUtil;
    }
    @PostMapping(value = "addall")
    @ResponseBody
    public JsonUtil addinfor_collectSave( String[] temp_norms_desc, HttpServletRequest request) {
        if (temp_norms_desc == null) {
            return JsonUtil.error("获取数据失败");
        }
        JsonUtil j = new JsonUtil();
        int num = 0;
     /*  try {

            Infor_collection ic = new Infor_collection();
            ic.setTemplate_name(template_name);
            ic.setTemplate_status("开启");
            Date date = new Date();
            ic.setCreate_time(date);

            HttpSession session = request.getSession(); //获取USER
            CurrentUser cuer = (CurrentUser)session.getAttribute("curentUser");

            ic.setFounder(cuer.getId());
            ic.setFounder_name(cuer.getRealName());

            int numId = inforService.addInfor_Collection(ic);
            if (numId>0){
                for (int i=0;i<temp_norms_name.length;i++){
                    Infor_collection_temp_norms ictn = new Infor_collection_temp_norms();
                    ictn.setTemp_norms_name(temp_norms_name[i]);
                    ictn.setTemp_norms_desc(temp_norms_desc[i]);
                    ictn.setInfor_collection_id(inforService.selectLastInfor_CollectionID());
                    inforService.addInfor_Collection_Temp(ictn);
                }
                j.setFlag(true);
                j.setMsg("新建模板成功");
            }
        } catch (MyException e) {
            j.setMsg("新建模板失败");
            j.setFlag(false);
            e.printStackTrace();
        }*/
        return j;
    }
    @GetMapping(value = "selectExamination")
    public String goselectExamination(String id, Model model, boolean detail) {
        if (StringUtils.isNotEmpty(id)) {
            Examination examination = examinationService.queryForById(id);
          Infor_collection mb =  examinationService.selectmb(examination.getGathering_id());
            SpecManagement st = examinationService.selectid(examination.getSpecialty_id());
            SpecManagement zst = examinationService.selectid(examination.getZspecialty_id());
            model.addAttribute("myzst",zst);
            model.addAttribute("myst",st);
            model.addAttribute("mymb",mb);
            model.addAttribute("myexam", examination);
        }
        model.addAttribute("detail", detail);
        return "/system/examination/select-examination";
    }

    @GetMapping(value = "updateExamination")
    public String goUpdateExamination(String id, Model model, boolean detail,HttpServletRequest request) {
        if (StringUtils.isNotEmpty(id)) {
            Examination examination = examinationService.queryForById(id);
            goAddExamination(model);
            model.addAttribute("myexam", examination);
        }
        request.setAttribute("examid",id);
        model.addAttribute("detail", detail);
        return "/system/examination/update-examination";
    }

    //图片上传控制器
    @RequestMapping(value = "/uploadFile" , method = RequestMethod.POST)
    @ResponseBody
    public JSONObject uploadPicture(@RequestParam("file")MultipartFile file, HttpServletRequest servletRequest)
            throws IOException {
        //如果文件内容不为空，则写入上传路径
        JSONObject res = new JSONObject();
        JSONObject resUrl = new JSONObject();
        //或者获取到项目部署的绝对路径
        //String path = servletRequest.getSession().getServletContext().getRealPath("");
        //path = path.replaceAll("xxx", "");          //xxx为项目名称
         //path = path.substring(0, path.length() - 1);
       //path = path + "/webImage/";//为图片文件夹下的图片存放文件夹目录

        //上传文件路径
        String path = new File(".").getCanonicalPath()+"/file/info";
      /*  String path = servletRequest.getServletPath();*/
        System.out.println("文件名称"+file.getOriginalFilename());
        //上传文件名

        String name = file.getOriginalFilename();//上传文件的真实名称
        String suffixName = name.substring(name.lastIndexOf("."));//获取后缀名
        String hash = Integer.toHexString(new Random().nextInt());//自定义随机数（字母+数字）作为文件名
        String fileName = hash + suffixName;
        File filepath = new File(path, fileName);
        System.out.println("随机数文件名称"+filepath.getName());
        //判断路径是否存在，没有就创建一个
        if (!filepath.getParentFile().exists()) {
            filepath.getParentFile().mkdirs();
        }
        //将上传文件保存到一个目标文档中
        File tempFile = new File(path + File.separator + fileName);
        file.transferTo(tempFile);

        resUrl.put("src", tempFile.getPath());
        res.put("code", 0);
        res.put("msg", "");
        res.put("data", resUrl);
        String i = servletRequest.getParameter("id");
        servletRequest.getSession().setAttribute("path"+i,tempFile.getPath());
        //str = "{\"code\": 0,\"msg\": \"上传成功\",\"data\": {\"src\":\""+path+fileName + "\"}}";
        System.out.println("res里面的值：");
        System.out.println(res.toString());
        return res;
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
