package com.zy.jsy.springboot.controller;

import com.zy.jsy.springboot.service.LanguageService;
import com.zy.jsy.springboot.service.ValidateService;
import com.zy.jsy.springboot.service.file.FileService;
import com.zy.jsy.springbootcommon.exception.AppRuntimeException;
import com.zy.jsy.springbootcommon.utils.DV;
import lombok.val;
import lombok.var;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloControllerTest {

    @Autowired
    private LanguageService languageServiceImpl;

    @Autowired
    private FileService excelPoiServiceImpl;

    @Test
    public void languageCount() {
        System.out.println("测试结果为：" + languageServiceImpl.queryLanguageCount());
    }


    @DV(nullable = false, minLength = 2, maxLength = 10)
    private static String userName = "1";

    @Test
    public void annotation() {


        try {
            ValidateService.validate(userName);
            System.out.println(userName);
        } catch (AppRuntimeException e) {
            System.out.println(e.getErrorMessage());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Test
    //创建一个有数据的excel

    public void WorkTest() throws Exception {

        String filePath = "D:/workTest1.xls";
        excelPoiServiceImpl.createFile(filePath);

        Workbook workbook = (HSSFWorkbook) excelPoiServiceImpl.getFile(filePath);

        HSSFSheet sheet = (HSSFSheet) workbook.getSheetAt(0);

      /*  HSSFRow row = sheet.createRow(0);// 创建行,从0开始

        HSSFCell cell = row.createCell(0);// 创建行的单元格,也是从0开始
        cell.setCellValue("jsy");// 设置单元格内容*/
        Row row = sheet.createRow(0);

        Cell cell = row.createCell(0);

        cell.setCellValue("测试");

        /*row.createCell(1).setCellValue(false);// 设置单元格内容,重载
        row.createCell(2).setCellValue(new Date());// 设置单元格内容,重载
        row.createCell(3).setCellValue(12.345);// 设置单元格内容,重载*/

        FileOutputStream out = new FileOutputStream(filePath);

        workbook.write(out);//保存Excel文件
        out.close();

    }

    @Test
    public void ExcelTest() throws Exception {

        String filePath = "D:/a1.xlsx";

        FileInputStream stream = new FileInputStream(filePath);
        Workbook workbook = null;

        //excel 2007 只能通过XSSFWorkbook读取 2003只能通过HSSFWorkbook读取
        try {
            workbook = new XSSFWorkbook(stream);
        } catch (Exception ex) {
            workbook = new HSSFWorkbook(stream);
        }

        FileOutputStream out = new FileOutputStream(filePath);

        Sheet sheet = workbook.getSheetAt(0);

        /* sheet.setColumnWidth(1, 31 * 256);//设置第一列的宽度是31个字符宽度*/

        Row row = sheet.createRow(0);

        row.setHeightInPoints(50);//设置行的高度是50个点

        Cell cell = row.createCell(0);

        cell.setCellValue("测试");

        workbook.write(out);
        out.close();
    }

    @Test
    public void var() {
        var var = new HashMap<String, String>();
        var.put("key","value");
        System.out.println(var.size());
    }


}