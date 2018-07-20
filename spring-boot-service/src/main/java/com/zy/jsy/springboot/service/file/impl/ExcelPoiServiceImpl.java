package com.zy.jsy.springboot.service.file.impl;

import com.zy.jsy.springboot.service.file.POIFileService;
import org.apache.poi.hpsf.DocumentSummaryInformation;
import org.apache.poi.hpsf.SummaryInformation;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

@Service
public class ExcelPoiServiceImpl implements POIFileService {

    private static Logger logger = LoggerFactory.getLogger(ExcelPoiServiceImpl.class);

    private static void addExcelInfo(HSSFWorkbook workbook){
        workbook.createInformationProperties();//创建文档信息
        DocumentSummaryInformation dsi=workbook.getDocumentSummaryInformation();//摘要信息
        dsi.setCategory("类别:Excel文件");//类别
        dsi.setManager("管理者:JSY");//管理者
        dsi.setCompany("公司:YY");//公司
        SummaryInformation si = workbook.getSummaryInformation();//摘要信息
        si.setSubject("主题:com.zy.jsy");//主题
        si.setTitle("标题:workbook");//标题
        si.setAuthor("作者:JSY");//作者
        si.setComments("备注:com.zy.jsy");//备注
    }

    @Override
    public boolean createFile(String fileName) {

        HSSFWorkbook workbook = new HSSFWorkbook();
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(fileName);
            workbook.createSheet("sheet1");// 创建工作表(Sheet)
            workbook.createSheet("sheet2");// 创建工作表(Sheet)
            workbook.createSheet("sheet3");// 创建工作表(Sheet)
            workbook.createSheet("sheet4");// 创建工作表(Sheet)
            workbook.setActiveSheet(1);//设置默认工作表
            addExcelInfo(workbook);
            workbook.write(out);//保存Excel文件
        } catch (Exception e) {
            logger.error("创建Excel文件失败，失败原因 error={}",e);
            return false;
        }finally {
            try {
                out.close();//关闭文件流
            } catch (IOException e) {
            }
        }
        return true;
    }

    @Override
    public Object getFile(String filePath) {
        Workbook workbook = null;
        try {
            FileInputStream stream = new FileInputStream(filePath);
            //excel 2007 只能通过XSSFWorkbook读取 2003只能通过HSSFWorkbook读取
            try {
                workbook = new XSSFWorkbook(stream);
            } catch (Exception ex) {
                workbook = new HSSFWorkbook(stream);
            }
            stream.close();
        } catch (IOException e) {
            logger.error("获取Excel表失败 失败原因 error={}",e);
           return null;
        } finally {
        }
        return workbook;
    }


}
