package com.nfdw.service.impl;

import com.nfdw.entity.Achievement_Summary;
import com.nfdw.service.ImportExcelBaseService;
import com.nfdw.service.ImportExcelService;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class ImportExcelServiceImpl extends ImportExcelBaseService implements ImportExcelService {

    @Override
    public List<Achievement_Summary> importExcelWithSimple(MultipartFile file, HttpServletRequest req, HttpServletResponse resp) {
        int rowNum = 0;//已取值的行数
        int colNum = 0;//列号
        int realRowCount = 0;//真正有数据的行数

        //得到工作空间
        Workbook workbook = null;
        try {
            workbook = super.getWorkbookByInputStream(file.getInputStream(), file.getOriginalFilename());
        } catch (IOException e) {
            e.printStackTrace();
        }

        //得到工作表
        Sheet sheet = super.getSheetByWorkbook(workbook, 0);
        if (sheet.getRow(2000) != null){
            throw new RuntimeException("系统已限制单批次导入必须小于或等于2000笔！");
        }

        realRowCount = sheet.getPhysicalNumberOfRows();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<Achievement_Summary> list = new ArrayList<>();
        Achievement_Summary as = null;

        for(Row row:sheet) {
            if(realRowCount == rowNum) {
                break;
            }

            if(super.isBlankRow(row)) {//空行跳过
                continue;
            }

            if(row.getRowNum() == -1) {
                continue;
            }else {
                if(row.getRowNum() == 0) {//第一行表头跳过
                    continue;
                }
            }

            rowNum ++;
            colNum = 0;
            as = new Achievement_Summary();  //34个字段

            //super.validCellValue(sheet, row, colNum, "身份证");  //验证空

            if (super.getCellValue(sheet, row, colNum) !=null && super.getCellValue(sheet, row, colNum) !=""){
                as.setId_card(super.getCellValue(sheet, row, colNum));
            }
            colNum++;
            if (super.getCellValue(sheet, row, colNum) !=null && super.getCellValue(sheet, row, colNum) !=""){
                as.setName(super.getCellValue(sheet, row, colNum));
            }
            colNum++;
            if (super.getCellValue(sheet, row, colNum) !=null && super.getCellValue(sheet, row, colNum) !=""){
                as.setGender(super.getCellValue(sheet, row, colNum));
            }
            colNum++;
            if (super.getCellValue(sheet, row, colNum) !=null && super.getCellValue(sheet, row, colNum) !=""){
                as.setHigh_province(super.getCellValue(sheet, row, colNum));
            }
            colNum++;
            if (super.getCellValue(sheet, row, colNum) !=null && super.getCellValue(sheet, row, colNum) !=""){
                as.setExaminee_num(super.getCellValue(sheet, row, colNum));
            }
            colNum++;
            if (super.getCellValue(sheet, row, colNum) !=null && super.getCellValue(sheet, row, colNum) !=""){
                as.setTicket_num(super.getCellValue(sheet, row, colNum));
            }
            colNum++;
            if (super.getCellValue(sheet, row, colNum) !=null && super.getCellValue(sheet, row, colNum) !=""){
                as.setWl_subject(super.getCellValue(sheet, row, colNum));
            }
            colNum++;
            if (super.getCellValue(sheet, row, colNum) !=null && super.getCellValue(sheet, row, colNum) !=""){
                as.setProfessional_code(super.getCellValue(sheet, row, colNum));
            }
            colNum++;
            if (super.getCellValue(sheet, row, colNum) !=null && super.getCellValue(sheet, row, colNum) !=""){
                as.setProfessional_name(super.getCellValue(sheet, row, colNum));
            }
            colNum++;
            if (super.getCellValue(sheet, row, colNum) !=null && super.getCellValue(sheet, row, colNum) !=""){
                as.setNational_rankings(Integer.valueOf(super.getCellValue(sheet, row, colNum)));
            }
            colNum++;
            if (super.getCellValue(sheet, row, colNum) !=null && super.getCellValue(sheet, row, colNum) !=""){
                as.setNational_same_name(super.getCellValue(sheet, row, colNum));
            }
            colNum++;
            if (super.getCellValue(sheet, row, colNum) !=null && super.getCellValue(sheet, row, colNum) !=""){
                as.setProvincial_ranking(Integer.valueOf(super.getCellValue(sheet, row, colNum)));
            }
            colNum++;
            if (super.getCellValue(sheet, row, colNum) !=null && super.getCellValue(sheet, row, colNum) !=""){
                as.setProvincial_same_name(super.getCellValue(sheet, row, colNum));
            }
            colNum++;
            if (super.getCellValue(sheet, row, colNum) !=null && super.getCellValue(sheet, row, colNum) !=""){
                as.setQualified_mark(super.getCellValue(sheet, row, colNum));
            }
            colNum++;
            if (super.getCellValue(sheet, row, colNum) !=null && super.getCellValue(sheet, row, colNum) !=""){
                as.setQualified_line(super.getCellValue(sheet, row, colNum));
            }
            colNum++;

            //科目1
            if (super.getCellValue(sheet, row, colNum) !=null && super.getCellValue(sheet, row, colNum) !=""){
                as.setFirst_subjects_name1(super.getCellValue(sheet, row, colNum));
            }
            colNum++;
            if (super.getCellValue(sheet, row, colNum) !=null && super.getCellValue(sheet, row, colNum) !=""){
                as.setFirst_subjects_achieve1(Double.valueOf(super.getCellValue(sheet, row, colNum)));
            }
            colNum++;
            if (super.getCellValue(sheet, row, colNum) !=null && super.getCellValue(sheet, row, colNum) !=""){
                as.setFirst_subjects_achieve_ex1(super.getCellValue(sheet, row, colNum));
            }
            colNum++;

            //科目2
            if (super.getCellValue(sheet, row, colNum) !=null && super.getCellValue(sheet, row, colNum) !=""){
                as.setFirst_subjects_name2(super.getCellValue(sheet, row, colNum));
            }
            colNum++;
            if (super.getCellValue(sheet, row, colNum) !=null && super.getCellValue(sheet, row, colNum) !=""){
                as.setFirst_subjects_achieve2(Double.valueOf(super.getCellValue(sheet, row, colNum)));
            }
            colNum++;
            if (super.getCellValue(sheet, row, colNum) !=null && super.getCellValue(sheet, row, colNum) !=""){
                as.setFirst_subjects_achieve_ex2(super.getCellValue(sheet, row, colNum));
            }
            colNum++;

            //科目3
            if (super.getCellValue(sheet, row, colNum) !=null && super.getCellValue(sheet, row, colNum) !=""){
                as.setFirst_subjects_name3(super.getCellValue(sheet, row, colNum));
            }
            colNum++;
            if (super.getCellValue(sheet, row, colNum) !=null && super.getCellValue(sheet, row, colNum) !=""){
                as.setFirst_subjects_achieve3(Double.valueOf(super.getCellValue(sheet, row, colNum)));
            }
            colNum++;
            if (super.getCellValue(sheet, row, colNum) !=null && super.getCellValue(sheet, row, colNum) !=""){
                as.setFirst_subjects_achieve_ex3(super.getCellValue(sheet, row, colNum));
            }
            colNum++;

            //科目4
            if (super.getCellValue(sheet, row, colNum) !=null && super.getCellValue(sheet, row, colNum) !=""){
                as.setFirst_subjects_name4(super.getCellValue(sheet, row, colNum));
            }
            colNum++;
            if (super.getCellValue(sheet, row, colNum) !=null && super.getCellValue(sheet, row, colNum) !=""){
                as.setFirst_subjects_achieve4(Double.valueOf(super.getCellValue(sheet, row, colNum)));
            }
            colNum++;
            if (super.getCellValue(sheet, row, colNum) !=null && super.getCellValue(sheet, row, colNum) !=""){
                as.setFirst_subjects_achieve_ex4(super.getCellValue(sheet, row, colNum));
            }
            colNum++;

            //科目5
            if (super.getCellValue(sheet, row, colNum) !=null && super.getCellValue(sheet, row, colNum) !=""){
                as.setFirst_subjects_name5(super.getCellValue(sheet, row, colNum));
            }
            colNum++;
            if (super.getCellValue(sheet, row, colNum) !=null && super.getCellValue(sheet, row, colNum) !=""){
                as.setFirst_subjects_achieve5(Double.valueOf(super.getCellValue(sheet, row, colNum)));
            }
            colNum++;
            if (super.getCellValue(sheet, row, colNum) !=null && super.getCellValue(sheet, row, colNum) !=""){
                as.setFirst_subjects_achieve_ex5(super.getCellValue(sheet, row, colNum));
            }
            colNum++;

            //科目6
            if (super.getCellValue(sheet, row, colNum) !=null && super.getCellValue(sheet, row, colNum) !=""){
                as.setFirst_subjects_name6(super.getCellValue(sheet, row, colNum));
            }
            colNum++;
            if (super.getCellValue(sheet, row, colNum) !=null && super.getCellValue(sheet, row, colNum) !=""){
                as.setFirst_subjects_achieve6(Double.valueOf(super.getCellValue(sheet, row, colNum)));
            }
            colNum++;
            if (super.getCellValue(sheet, row, colNum) !=null && super.getCellValue(sheet, row, colNum) !=""){
                as.setFirst_subjects_achieve_ex6(super.getCellValue(sheet, row, colNum));
            }
            colNum++;

            if (super.getCellValue(sheet, row, colNum) !=null && super.getCellValue(sheet, row, colNum) !=""){
                as.setFirst_subjects_total(Double.valueOf(super.getCellValue(sheet, row, colNum)));
            }
            colNum++;
            if (super.getCellValue(sheet, row, colNum) !=null && super.getCellValue(sheet, row, colNum) !=""){
                as.setRemarks(super.getCellValue(sheet, row, colNum));
            }

            list.add(as);
            for (int i = 0; i<34;i++){
                if (super.getCellValue(sheet, row, i) !=null && super.getCellValue(sheet, row, i) !="")
                    System.out.println("第"+rowNum+"行,第"+(i+1)+"列:"+super.getCellValue(sheet, row, i));
            }
        }

        return list;
    }
}
