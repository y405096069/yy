package com.nfdw.service;

import com.nfdw.entity.Achievement_Summary;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface ImportExcelService {

    /**
     * 获取导入的Excel表中数据
     * @param file 文件
     * @param req
     * @param resp
     * @return 返回集合
     */
    public List<Achievement_Summary> importExcelWithSimple(MultipartFile file, HttpServletRequest req, HttpServletResponse resp);
}
