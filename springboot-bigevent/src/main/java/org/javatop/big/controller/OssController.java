package org.javatop.big.controller;

import lombok.extern.slf4j.Slf4j;
import org.javatop.big.service.FileService;
import org.javatop.big.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author : Leo
 * @version 1.0
 * @date 2023-11-26 0:55
 * @description :
 */
@RestController
@Slf4j
public class OssController {

    @Autowired
    private FileService fileService;

    /**
     * OSS文件上传
     *
     * @param file
     * @param module
     * @return
     */
    @PostMapping("/upload")
    public Result upload(MultipartFile file, @RequestParam(value = "module", required = false, defaultValue = "test")String module) {
        //返回上传到oss的路径
        String url = fileService.upload(file, module);
        log.info("------OSS文件上传成功------" + url);
        return Result.success(url);
    }
}
