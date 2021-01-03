package com.junjie.music.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.junjie.music.entity.Admin;
import com.junjie.music.mapper.AdminMapper;
import com.junjie.music.service.AdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 管理员 服务实现类
 * </p>
 *
 * @author junjie
 * @since 2020-12-27
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {

    @Autowired
    private  AdminMapper adminMapper;

    public boolean login(String username,String password){
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("name",username);
        wrapper.eq("password",password);
        return  adminMapper.selectCount(wrapper)> 0;
    }

}
