package com.zy.jsy.springboot.service.file.impl;

import com.zy.jsy.springboot.service.file.POIFileService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

@Service
public class ExcelPoiServiceImpl implements POIFileService {

    private static Logger logger = LoggerFactory.getLogger(ExcelPoiServiceImpl.class);

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
        HSSFWorkbook workbook = null;
        try {
            FileInputStream stream = new FileInputStream(filePath);
            workbook = new HSSFWorkbook(stream);//读取现有的Excel
            stream.close();
        } catch (IOException e) {
            logger.error("获取Excel表失败 失败原因 error={}",e);
           return null;
        } finally {
        }
        return workbook;
    }


}
