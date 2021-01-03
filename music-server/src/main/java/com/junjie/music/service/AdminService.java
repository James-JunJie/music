package com.junjie.music.service;

import com.junjie.music.entity.Admin;
import com.baomidou.mybatisplus.extension.service.IService;
import com.junjie.music.entity.Singer;
import com.junjie.music.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 管理员 服务类
 * </p>
 *
 * @author junjie
 * @since 2020-12-27
 */
public interface AdminService extends IService<Admin> {
    /**
     *  根据用户名与密码登录
     * @param userName
     * @param password
     * @return
     */
    public boolean login(String userName, String password);
}
