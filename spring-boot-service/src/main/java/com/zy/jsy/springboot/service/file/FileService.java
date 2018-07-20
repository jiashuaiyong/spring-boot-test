package com.zy.jsy.springboot.service.file;

/**
 * 文档处理
 */
public interface FileService {

    boolean createFile(String fileName);

    Object getFile(String fileName);

}
