package org.javatop.jwt.controller;

import org.javatop.jwt.utils.Result;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Leo
 * @version 1.0
 * @date 2023-11-21 22:54
 * @description :
 */
@RestController
@CrossOrigin
public class BlogController {

    @PostMapping("/blog")
    public Result blog() {
        return new Result(200, "success", "博客发布成功");
    }
}
