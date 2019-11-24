package com.nfdw.utils;

import com.nfdw.entity.Achievement_Summary;
import com.nfdw.util.JsonUtil;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/*
       导出初试成绩
     */
public class ExportToExcel {


    public static void exportWhiteList( String name,List<Achievement_Summary> list, HttpServletResponse response) {

        HSSFWorkbook wb = new HSSFWorkbook();
        //创建工作表
        HSSFSheet sheet = wb.createSheet();
        //创建行列
        HSSFRow nRow = sheet.createRow(0);
        HSSFCell nCell = nRow.createCell(0);
        sheet.setDefaultColumnWidth(12);
        sheet.setColumnWidth(0,24*256);
        sheet.setColumnWidth(17,18*256);
        sheet.setColumnWidth(20,18*256);
        sheet.setColumnWidth(23,18*256);
        sheet.setColumnWidth(26,18*256);
        sheet.setColumnWidth(29,18*256);
        sheet.setColumnWidth(32,18*256);

        //控制行号列号
        int rowNo = 0;
        int colNo = 0;

        HSSFCellStyle style = wb.createCellStyle();//设置列样式
        Font font =  wb.createFont();
        font.setColor(HSSFColor.WHITE.index);
        font.setFontHeightInPoints((short)13);
        style.setFont(font);
        style.setAlignment(HorizontalAlignment.CENTER);// 水平居中
        style.setVerticalAlignment(VerticalAlignment.CENTER);// 垂直居中
        style.setFillForegroundColor(IndexedColors.AUTOMATIC.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        HSSFCellStyle style2 = wb.createCellStyle();//设置列样式
        Font font2 =  wb.createFont();
        font2.setFontHeightInPoints((short)12);
        style2.setFont(font2);


        //列标题
        String[] title;
        title = new String[]{"身份证号", "姓名", "性别", "高考省份", "考生号", "准考证号",
                "文理科", "专业代码", "专业名称", "全国排名", "全国同名次", "省排名", "省同名次",
                "合格标志Y/N", "合格线", "科目1名称", "科目1成绩", "科目1成绩说明","科目2名称"
                , "科目2成绩", "科目2成绩说明", "科目3名称", "科目3成绩", "科目3成绩说明", "科目4名称",
                "科目4成绩", "科目4成绩说明", "科目5名称", "科目5成绩", "科目5成绩说明", "科目6名称",
                "科目6成绩", "科目6成绩说明", "总分", "备注"};

        //设置标题到第一行的列中
        nRow = sheet.createRow(rowNo++);
        for (int i = 0; i < title.length; i++) {
            nCell = nRow.createCell(i);
            nCell.setCellValue(title[i]);
            nCell.setCellStyle(style);
        }
        try {
            //List<Achievement_Summary> tList = achieveService.selectListByPage(null,Integer.valueOf(id));
            //遍历并且创建行列
            for (Achievement_Summary as : list) {
                //控制列号
                colNo = 0;
                //每遍历一次创建一行
                nRow = sheet.createRow(rowNo++);
                //身份证
                nCell = nRow.createCell(colNo++);
                if(as.getId_card()!=null)
                    nCell.setCellValue(as.getId_card());nCell.setCellStyle(style2);
                //姓名
                nCell = nRow.createCell(colNo++);
                if(as.getName()!=null)
                    nCell.setCellValue(as.getName());nCell.setCellStyle(style2);
                //性别
                nCell = nRow.createCell(colNo++);
                if(as.getGender()!=null)
                    nCell.setCellValue(as.getGender());nCell.setCellStyle(style2);
                //高考省份
                nCell = nRow.createCell(colNo++);
                if(as.getHigh_province()!=null)
                    nCell.setCellValue(as.getHigh_province());nCell.setCellStyle(style2);
                //考生号
                nCell = nRow.createCell(colNo++);
                if(as.getExaminee_num()!=null)
                    nCell.setCellValue(as.getExaminee_num());nCell.setCellStyle(style2);
                //准考证号
                nCell = nRow.createCell(colNo++);
                if(as.getTicket_num()!=null)
                    nCell.setCellValue(as.getTicket_num());nCell.setCellStyle(style2);
                //文理科
                nCell = nRow.createCell(colNo++);
                if(as.getWl_subject()!=null)
                    nCell.setCellValue(as.getWl_subject());nCell.setCellStyle(style2);
                //专业代码
                nCell = nRow.createCell(colNo++);
                if(as.getProfessional_code()!=null)
                    nCell.setCellValue(as.getProfessional_code());nCell.setCellStyle(style2);
                //专业名称
                nCell = nRow.createCell(colNo++);
                if(as.getProfessional_name()!=null)
                    nCell.setCellValue(as.getProfessional_name());nCell.setCellStyle(style2);
                //全国排名
                nCell = nRow.createCell(colNo++);
                if(as.getNational_rankings()!=0)
                    nCell.setCellValue(as.getNational_rankings());nCell.setCellStyle(style2);
                nCell = nRow.createCell(colNo++);nCell.setCellStyle(style2);
                nCell = nRow.createCell(colNo++);nCell.setCellStyle(style2);
                nCell = nRow.createCell(colNo++);nCell.setCellStyle(style2);
                nCell = nRow.createCell(colNo++);nCell.setCellStyle(style2);
                nCell = nRow.createCell(colNo++);nCell.setCellStyle(style2);
                /*//全国同名次
                nCell = nRow.createCell(colNo++);
                if(as.getNational_same_name()!=null)
                    nCell.setCellValue(as.getNational_same_name());
                //省排名
                nCell = nRow.createCell(colNo++);
                if(as.getProvincial_ranking()!=0)
                    nCell.setCellValue(as.getProvincial_ranking());
                //省同名次
                nCell = nRow.createCell(colNo++);
                if(as.getProvincial_same_name()!=null)
                    nCell.setCellValue(as.getProvincial_same_name());
                //合格标志Y/N
                nCell = nRow.createCell(colNo++);
                if(as.getQualified_mark()!=null)
                    nCell.setCellValue(as.getQualified_mark());
                //合格线
                nCell = nRow.createCell(colNo++);
                if(as.getQualified_line()!=null)
                    nCell.setCellValue(as.getQualified_line());*/

                //科目1名称
                nCell = nRow.createCell(colNo++);
                if (as.getFirst_subjects_name1()!=null)
                    nCell.setCellValue(as.getFirst_subjects_name1());nCell.setCellStyle(style2);
                //科目1成绩
                nCell = nRow.createCell(colNo++);nCell.setCellStyle(style2);
                /*if (as.getFirst_subjects_achieve1()!=0)
                    nCell.setCellValue(as.getFirst_subjects_achieve1());*/
                //科目1成绩说明
                nCell = nRow.createCell(colNo++);nCell.setCellStyle(style2);
                /*if (as.getFirst_subjects_achieve_ex1()!=null)
                    nCell.setCellValue(as.getFirst_subjects_achieve_ex1());*/

                //科目2名称
                nCell = nRow.createCell(colNo++);
                if (as.getFirst_subjects_name2()!=null)
                    nCell.setCellValue(as.getFirst_subjects_name2());nCell.setCellStyle(style2);
                //科目2成绩
                nCell = nRow.createCell(colNo++);nCell.setCellStyle(style2);
                /*if (as.getFirst_subjects_achieve2()!=0)
                    nCell.setCellValue(as.getFirst_subjects_achieve2());*/
                //科目2成绩说明
                nCell = nRow.createCell(colNo++);nCell.setCellStyle(style2);
                /*if (as.getFirst_subjects_achieve_ex2()!=null)
                    nCell.setCellValue(as.getFirst_subjects_achieve_ex2());*/

                //科目3名称
                nCell = nRow.createCell(colNo++);
                if (as.getFirst_subjects_name3()!=null)
                    nCell.setCellValue(as.getFirst_subjects_name3());nCell.setCellStyle(style2);
                //科目3成绩
                nCell = nRow.createCell(colNo++);nCell.setCellStyle(style2);
                /*if (as.getFirst_subjects_achieve3()!=0)
                    nCell.setCellValue(as.getFirst_subjects_achieve3());*/
                //科目3成绩说明
                nCell = nRow.createCell(colNo++);nCell.setCellStyle(style2);
                /*if (as.getFirst_subjects_achieve_ex3()!=null)
                    nCell.setCellValue(as.getFirst_subjects_achieve_ex3());*/

                //科目4名称
                nCell = nRow.createCell(colNo++);
                if (as.getFirst_subjects_name4()!=null)
                    nCell.setCellValue(as.getFirst_subjects_name4());nCell.setCellStyle(style2);
                //科目4成绩
                nCell = nRow.createCell(colNo++);nCell.setCellStyle(style2);
                /*if (as.getFirst_subjects_achieve4()!=0)
                    nCell.setCellValue(as.getFirst_subjects_achieve4());*/
                //科目4成绩说明
                nCell = nRow.createCell(colNo++);nCell.setCellStyle(style2);
                /*if (as.getFirst_subjects_achieve_ex4()!=null)
                    nCell.setCellValue(as.getFirst_subjects_achieve_ex4());*/

                //科目5名称
                nCell = nRow.createCell(colNo++);
                if (as.getFirst_subjects_name5()!=null)
                    nCell.setCellValue(as.getFirst_subjects_name5());nCell.setCellStyle(style2);
                //科目5成绩
                nCell = nRow.createCell(colNo++);nCell.setCellStyle(style2);
                /*if (as.getFirst_subjects_achieve5()!=0)
                    nCell.setCellValue(as.getFirst_subjects_achieve5());*/
                //科目5成绩说明
                nCell = nRow.createCell(colNo++);nCell.setCellStyle(style2);
                /*if (as.getFirst_subjects_achieve_ex5()!=null)
                    nCell.setCellValue(as.getFirst_subjects_achieve_ex5());*/

                //科目6名称
                nCell = nRow.createCell(colNo++);nCell.setCellStyle(style2);
                if (as.getFirst_subjects_name6()!=null)
                    nCell.setCellValue(as.getFirst_subjects_name6());
                //科目6成绩
                nCell = nRow.createCell(colNo++);nCell.setCellStyle(style2);
                /*if (as.getFirst_subjects_achieve6()!=0)
                    nCell.setCellValue(as.getFirst_subjects_achieve6());*/
                //科目6成绩说明
                nCell = nRow.createCell(colNo++);nCell.setCellStyle(style2);
                /*if (as.getFirst_subjects_achieve_ex6()!=null)
                    nCell.setCellValue(as.getFirst_subjects_achieve_ex6());*/

                //初试总分
                nCell = nRow.createCell(colNo++);nCell.setCellStyle(style2);
                /*if (as.getFirst_subjects_total()!=0)
                    nCell.setCellValue(as.getFirst_subjects_total());*/

                //备注
                nCell = nRow.createCell(colNo++);nCell.setCellStyle(style2);
                /*if (as.getRemarks()!=null)
                    nCell.setCellValue(as.getRemarks());*/
            }
            loadResponse(name, response, wb);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 设置Excel相关参数
     *
     * @param excelName
     * @param response
     * @param wb
     * @throws IOException
     */
    private static void loadResponse(String excelName, HttpServletResponse response, HSSFWorkbook wb) throws IOException {
        //到这里，excel就已经生成了，然后就需要通过流来写出去
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        //将excel写入流
        wb.write(byteArrayOutputStream);
        //设置文件标题
        String dateTime = DateFormatUtils.format(new Date(), "yyyyMMdd");
        String outFile = excelName + "-初试成绩表" + dateTime + ".xls";
        //设置返回的文件类型
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        //对文件编码
        outFile = response.encodeURL(new String(outFile.getBytes("gb2312"), "iso8859-1"));
        //使用Servlet实现文件下载的时候，避免浏览器自动打开文件
        response.addHeader("Content-Disposition", "attachment;filename=" + outFile);
        //设置文件大小
        response.setContentLength(byteArrayOutputStream.size());
        //创建Cookie并添加到response中
        Cookie cookie = new Cookie("fileDownload", "true");
        cookie.setPath("/");
        response.addCookie(cookie);
        //将流写进response输出流中
        ServletOutputStream outputstream = response.getOutputStream();
        byteArrayOutputStream.writeTo(outputstream);

        byteArrayOutputStream.close();
        outputstream.flush();
    }


}
