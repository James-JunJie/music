package com.junjie.music.controller;



import com.junjie.music.result.Code;
import com.junjie.music.result.Result;
import com.junjie.music.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 管理员 前端控制器
 * </p>
 *
 * @author junjie
 * @since 2020-12-27
 */
@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminService adminService;
    /**
     * 登录
     * */
    @PostMapping("/login")
    public Result login(String username, String password){
        boolean flag = adminService.login(username, password);
        System.out.println(flag);
        return new Result(flag ? Code.OK : Code.EEROR);
    }


}

