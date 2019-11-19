package com.nfdw.controller;

import com.nfdw.core.annotation.Log;
import com.nfdw.entity.CurrentUser;
import com.nfdw.entity.Notice;
import com.nfdw.entity.SysRoleUser;
import com.nfdw.exception.MyException;
import com.nfdw.service.NoticeService;
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
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * @Auther: EagleJunBin
 * @Date: 2019/11/16
 * @Description:
 */
@Controller
@RequestMapping(value = "/notice")
public class NoticeController {


    @Autowired
    private NoticeService noticeService;

    @GetMapping(value = "showNotice")
    /*@RequiresPermissions("user:show")*/
    public String showNotice(Model model) {
        return "/system/notice/noticeList";//报名公告
    }

    @GetMapping(value = "showNoticeList")
    @ResponseBody
   /* @RequiresPermissions("user:show")*/
    public ReType showNotice(Model model, Notice notice, String page, String limit) {
        return noticeService.show(notice, Integer.valueOf(page), Integer.valueOf(limit));
    }

    @GetMapping(value = "showAddNotice")
    public String goAddNotice(Model model) {
        List<Notice> notices = noticeService.showMenuJsonList();
        model.addAttribute("notices",notices);
        return "/system/notice/add-notice";
    }

    @ApiOperation(value = "/addNotice", httpMethod = "POST", notes = "添加公告")
    @Log(desc = "添加公告")
    @PostMapping(value = "addNotice")
    @ResponseBody
    public JsonUtil addNotice(Notice notice, String[] role, HttpServletRequest request) {
        JsonUtil j = new JsonUtil();
        try {
            Notice ic = new Notice();
            Date date = new Date();
            ic.setCreate_time(date);
            String caption = notice.getCaption();
            String content = notice.getContent();
            HttpSession session = request.getSession(); //获取USER
            CurrentUser cuer = (CurrentUser)session.getAttribute("curentUser");
            ic.setCaption(caption);
            ic.setContent(content);
            ic.setUser_name(cuer.getRealName());
           int count = noticeService.insertSelective(ic);
           if(count > 0){
               j.setMsg("保存成功");
           }
        } catch (MyException e) {
            j.setMsg("保存失败");
            j.setFlag(false);
            e.printStackTrace();
        }
        return j;
    }

    @GetMapping(value = "updateNotice")
    public String goUpdateNotice(String id, Model model, boolean detail) {
        if (StringUtils.isNotEmpty(id)) {
            Notice notice = noticeService.selectByPrimaryKey(id);
            model.addAttribute("u", notice);
        }
        model.addAttribute("detail", detail);
        return "system/notice/update-notice";
    }


    @ApiOperation(value = "/updateNotice", httpMethod = "POST", notes = "更新公告")
    @Log(desc = "更新公告")
    @PostMapping(value = "updateNotice")
    @ResponseBody
    @Transactional
    public JsonUtil updateNotice(Notice notice, String role[], HttpServletRequest request) {
        JsonUtil jsonUtil = new JsonUtil();
        jsonUtil.setFlag(false);
        if (notice == null) {
            jsonUtil.setMsg("获取数据失败");
            return jsonUtil;
        }
        try {
            jsonUtil.setFlag(true);
            jsonUtil.setMsg("修改成功");
            //throw  new MyException("错误");
        } catch (MyException e) {
            e.printStackTrace();
        }
        return jsonUtil;
    }


    @ApiOperation(value = "/del", httpMethod = "POST", notes = "删除通告")
    @Log(desc = "删除通告")
    @PostMapping(value = "del")
    @ResponseBody
    /*@RequiresPermissions("role:del")*/
    public JsonUtil del(String id) {
        if (StringUtils.isEmpty(id)) {
            return JsonUtil.error("获取数据失败");
        }
        JsonUtil j = new JsonUtil();
        try {
            int count = noticeService.deleteById(id);
            if (count > 0){

                j.setMsg("删除成功");
            }
        } catch (MyException e) {
            j.setMsg("删除失败");
            j.setFlag(false);
            e.printStackTrace();
        }
        return j;
    }




}
