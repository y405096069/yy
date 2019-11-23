package com.nfdw.utils;

import com.nfdw.entity.Achievement_Summary;
import com.nfdw.entity.Audit;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/*
       导出审核总表
     */
public class ExportAuditToExcel {


    public static void exportWhiteList(String name, List<Audit> list, HttpServletResponse response) {

        HSSFWorkbook wb = new HSSFWorkbook();
        //创建工作表
        HSSFSheet sheet = wb.createSheet();

        //创建行列
        HSSFRow nRow = sheet.createRow(0);
        HSSFCell nCell = nRow.createCell(0);
        sheet.setDefaultColumnWidth(16);
        sheet.setColumnWidth(6,24*256);

        //控制行号列号
        int rowNo = 0;
        int colNo = 0;
        //列标题
        String[] title;
        title = new String[]{"姓名", "生源地", "报考考试名称", "报考专业", "审核资料环节", "信息采集状态",
                "信息提交时间", "报名状态"};

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

        //设置标题到第一行的列中
        nRow = sheet.createRow(rowNo++);
        for (int i = 0; i < title.length; i++) {
            nCell = nRow.createCell(i);
            nCell.setCellValue(title[i]);
            nCell.setCellStyle(style);
        }
        try {
            for (Audit as : list) {
                //控制列号
                colNo = 0;
                //每遍历一次创建一行
                nRow = sheet.createRow(rowNo++);
                //姓名
                nCell = nRow.createCell(colNo++);
                if(as.getName()!=null)
                    nCell.setCellValue(as.getName());nCell.setCellStyle(style2);
                //生源地
                nCell = nRow.createCell(colNo++);
                if(as.getBiog_land()!=null)
                    nCell.setCellValue(as.getBiog_land());nCell.setCellStyle(style2);
                //报考考试名称
                nCell = nRow.createCell(colNo++);
                if(as.getExam_name()!=null)
                    nCell.setCellValue(as.getExam_name());nCell.setCellStyle(style2);
                //报考专业
                nCell = nRow.createCell(colNo++);
                if(as.getMajor()!=null)
                    nCell.setCellValue(as.getMajor());nCell.setCellStyle(style2);
                //审核资料环节
                nCell = nRow.createCell(colNo++);
                if(as.getAudit_link()!=null)
                    nCell.setCellValue(as.getAudit_link());nCell.setCellStyle(style2);
                //信息采集状态
                nCell = nRow.createCell(colNo++);
                if(as.getInfo_collect_status()!=null)
                    nCell.setCellValue(as.getInfo_collect_status());nCell.setCellStyle(style2);
                //信息提交时间
                nCell = nRow.createCell(colNo++);
                if(as.getSub_time()!=null){
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   //转换时间
                    String dateString = formatter.format(as.getSub_time());
                    nCell.setCellValue(dateString);nCell.setCellStyle(style2);
                }
                //报名状态
                nCell = nRow.createCell(colNo++);
                if(as.getAudit_status()!=null)
                    nCell.setCellValue(as.getAudit_status());nCell.setCellStyle(style2);
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
        String outFile = excelName  + dateTime + ".xls";
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
