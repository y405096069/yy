package com.nfdw.controller;

import com.nfdw.core.annotation.Log;
import com.nfdw.entity.*;
import com.nfdw.exception.MyException;
import com.nfdw.service.AuditService;
import com.nfdw.service.Infor_CollectionService;
import com.nfdw.util.JsonUtil;
import com.nfdw.util.ReType;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/audit")
public class AuditController {          ////审核管理

    @Autowired
    AuditService auditService;

    @Autowired
    Infor_CollectionService inforService;

    @GetMapping(value = "auditList")
    public String showUser(Model model) {
        return "/system/audit/auditList";
    }

    @GetMapping(value = "showAuditList")
    @ResponseBody
    public ReType showAudit(Model model, Audit aud, String page, String limit) {
        return auditService.show(aud,Integer.valueOf(page), Integer.valueOf(limit));
    }

    @GetMapping(value = "updateAudit")
    public String updateAudit(String id, Model model) {
        if (StringUtils.isNotEmpty(id)) {
            Audit audit = auditService.getAuditById(id);
            Examinee_User e_user = auditService.getExaminee_UserById(audit.getU_id());
            model.addAttribute("audit", audit);
            model.addAttribute("e_user", e_user);
        }
        return "system/audit/update-audit";
    }

    @ApiOperation(value = "/updateAuditSave", httpMethod = "POST", notes = "审核考生")
    @Log(desc = "审核考生", type = Log.LOG_TYPE.UPDATE)
    @PostMapping(value = "updateAuditSave")
    @ResponseBody
    public JsonUtil updateAuditSave(Audit audit) {
        JsonUtil jsonUtil = new JsonUtil();
        jsonUtil.setFlag(false);
        if (audit == null) {
            jsonUtil.setMsg("获取数据失败");
            return jsonUtil;
        }

        try {
            Date date = new Date();
            audit.setAudit_status("已审核");
            audit.setAudit_time(date);
            if (audit.getAudit_link().equals("交费前")){                     //资料环节
                if (audit.getInfo_collect_status().equals("审核通过")){     //信息采集
                    if(audit.getEnroll_status().equals("审核通过")){
                        audit.setPay_status("待支付");
                        audit.setEnroll_status("等待缴费");
                    }else{
                        audit.setEnroll_status("审核不通过");
                    }
                    auditService.updAudit(audit);
                }
            }else if (audit.getAudit_link().equals("交费后")){
                if (audit.getPay_status().equals("已支付")){
                    if(audit.getEnroll_status().equals("审核通过")){
                        audit.setEnroll_status("报名成功");

                    }else{
                        audit.setEnroll_status("报名不成功");
                    }
                    auditService.updAudit(audit);
                }
            }
            if (auditService.updAudit(audit)){
                if(audit.getEnroll_status().equals("报名状态")){
                    //向成绩表插入
                }
                jsonUtil.setFlag(true);
                jsonUtil.setMsg("审核成功");
            }
        } catch (MyException e) {
            e.printStackTrace();
        }
        return jsonUtil;
    }

    @ApiOperation(value = "/batchUpdateAudit", notes = "批量审核考生")
    @Log(desc = "批量审核考生", type = Log.LOG_TYPE.UPDATE)
    @PostMapping(value = "batchUpdateAudit")
    @ResponseBody
    public JsonUtil batchUpdateAudit(String[] id, String[] status) {
        if (id == null) {
            return JsonUtil.error("获取数据失败");
        }
        JsonUtil j = new JsonUtil();
        int num = 0;
        try {
            for (int i=0; i<id.length;i++){
                if (status[i].equals("1")){
                    Audit audit = new Audit();
                    audit.setId(Integer.valueOf(id[i]));
                    Date date = new Date();
                    audit.setAudit_time(date);
                    audit.setAudit_status("已审核");
                    audit.setEnroll_status("报名成功");
                    audit.setAudit_reason("无");
                    auditService.updAudit(audit);
                    num++;
                }
            }
            j.setFlag(true);
            if (num>0){
                j.setMsg("批量审批成功");
            }
        } catch (MyException e) {
            j.setMsg("批量审批失败");
            j.setFlag(false);
            e.printStackTrace();
        }
        return j;
    }


    /*
     *信息采集模板
     */
    @GetMapping(value = "infor_collectList")
    public String infor_collectList(Model model) {
        return "/system/audit/infor_colList";
    }

    @GetMapping(value = "showinfor_collectList")
    @ResponseBody
    public ReType showinfor_collectList(Model model, Infor_collection ic, String page, String limit) {
        return inforService.show(ic,Integer.valueOf(page), Integer.valueOf(limit));
    }

    //新建信息模板
    @GetMapping(value = "addinfor_collect")
    public String addinfor_collect() {
        return "system/audit/addinfor_collect";
    }

    @ApiOperation(value = "/addinfor_collectSave", notes = "新建信息模板")
    @Log(desc = "新建信息模板", type = Log.LOG_TYPE.UPDATE)
    @PostMapping(value = "addinfor_collectSave")
    @ResponseBody
    public JsonUtil addinfor_collectSave(String template_name, String[] temp_norms_name, String[] temp_norms_desc, HttpServletRequest request) {
        if (temp_norms_name == null) {
            return JsonUtil.error("获取数据失败");
        }
        JsonUtil j = new JsonUtil();
        int num = 0;
        try {

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
        }
        return j;
    }

    @Log(desc = "修改模板状态", type = Log.LOG_TYPE.DEL)
    @ApiOperation(value = "/updateTemplate_status", httpMethod = "POST", notes = "修改模板状态")
    @PostMapping(value = "/updateTemplate_status")
    @ResponseBody
    @Transactional
    public JsonUtil del(String id, String status) {
        JsonUtil j = new JsonUtil();

        try {
            if (inforService.updateTemplate_status(Integer.valueOf(id),status)){
                j.setFlag(true);
                if (status.equals("开启")){
                    j.setMsg("开启成功");
                }else{
                    j.setMsg("关闭成功");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return j;
    }

    //查看——修改 信息模板
    @GetMapping(value = "updinfor_collect")
    public String updinfor_collect(String id, Model model) {

        if (StringUtils.isNotEmpty(id)) {
            Infor_collection ic = inforService.selectInforById(Integer.valueOf(id));
            model.addAttribute("infor_collection", ic);
            List<Infor_collection_temp_norms> ictnList1= inforService.selectTemp_NormsByInforId(Integer.valueOf(id),"上传图片");
            model.addAttribute("ictnList1", ictnList1);

            List<Infor_collection_temp_norms> ictnList2= inforService.selectTemp_NormsByInforId(Integer.valueOf(id),"上传视频");
            model.addAttribute("ictnList2", ictnList2);

            List<Infor_collection_temp_norms> ictnList3= inforService.selectTemp_NormsByInforId(Integer.valueOf(id),"上传文件");
            model.addAttribute("ictnList3", ictnList3);

            List<Infor_collection_temp_norms> ictnList4= inforService.selectTemp_NormsByInforId(Integer.valueOf(id),"上传音乐");
            model.addAttribute("ictnList4", ictnList4);
        }
        return "system/audit/updinfor_collect";
    }

    @ApiOperation(value = "/updinfor_collectSave", notes = "修改信息模板")
    @Log(desc = "修改信息模板", type = Log.LOG_TYPE.UPDATE)
    @PostMapping(value = "updinfor_collectSave")
    @ResponseBody
    public JsonUtil updinfor_collectSave(String id, String template_name, String[] temp_norms_name, String[] temp_norms_desc, HttpServletRequest request) {
        if (temp_norms_name == null) {
            return JsonUtil.error("获取数据失败");
        }
        JsonUtil j = new JsonUtil();
        int num = 0;
        try {

            Infor_collection ic = new Infor_collection();
            ic.setTemplate_name(template_name);
            ic.setId(Integer.valueOf(id));
            Date date = new Date();
            ic.setCreate_time(date);

            HttpSession session = request.getSession(); //获取USER
            CurrentUser cuer = (CurrentUser)session.getAttribute("curentUser");

            ic.setFounder(cuer.getId());
            ic.setFounder_name(cuer.getRealName());
            if (inforService.updInfor_Collection(ic)){
                inforService.delTemp_NormsByInforId(Integer.valueOf(id));   //删除模板规格表数据
                for (int i=0;i<temp_norms_name.length;i++){
                    Infor_collection_temp_norms ictn = new Infor_collection_temp_norms();
                    ictn.setTemp_norms_name(temp_norms_name[i]);
                    ictn.setTemp_norms_desc(temp_norms_desc[i]);
                    ictn.setInfor_collection_id(Integer.valueOf(id));
                    inforService.addInfor_Collection_Temp(ictn);
                }
                j.setFlag(true);
                j.setMsg("修改模板成功");
            }
        } catch (MyException e) {
            j.setMsg("修改模板失败");
            j.setFlag(false);
            e.printStackTrace();
        }
        return j;
    }


    @ApiOperation(value = "/delinfor_collect", httpMethod = "POST", notes = "删除信息模板")
    @Log(desc = "删除信息模板", type = Log.LOG_TYPE.UPDATE)
    @PostMapping(value = "delinfor_collect")
    @ResponseBody
    public JsonUtil delinfor_collect(String id) {
        JsonUtil jsonUtil = new JsonUtil();
        jsonUtil.setFlag(false);
        if (id==null) {
            jsonUtil.setMsg("获取数据失败");
            return jsonUtil;
        }
        try {
            if (inforService.delInfor_CollectionById(Integer.valueOf(id))){
                inforService.delTemp_NormsByInforId(Integer.valueOf(id));
                jsonUtil.setFlag(true);
                jsonUtil.setMsg("删除模板成功");
            }
        } catch (MyException e) {
            jsonUtil.setMsg("发生错误");
            e.printStackTrace();
        }
        return jsonUtil;
    }

}
