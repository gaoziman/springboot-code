package org.javatop.big.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author : Leo
 * @version 1.0
 * @date 2023-11-26 0:53
 * @description :
 */
public interface FileService {

    /**
     * 文件上传
     *
     * @param file   文件上传对象
     * @param module 文件夹名称
     * @return {@link String}
     */
    String upload(MultipartFile file, String module);

    /**
     * 删除文件
     *
     * @param url url
     */
    void deleteFile(String url);
}
