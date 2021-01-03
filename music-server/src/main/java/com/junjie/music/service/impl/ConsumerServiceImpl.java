package com.junjie.music.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.junjie.music.entity.Consumer;
import com.junjie.music.mapper.ConsumerMapper;
import com.junjie.music.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 用户 服务实现类
 * </p>
 *
 * @author junjie
 * @since 2020-12-27
 */
@Service
public class ConsumerServiceImpl extends ServiceImpl<ConsumerMapper, Consumer> implements ConsumerService {

    @Autowired
    ConsumerMapper consumerMapper;

    @Override
    public boolean save(Consumer consumer) {
        return consumerMapper.insert(consumer) > 0;
    }

    @Override
    public boolean update(Consumer consumer) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("id",consumer.getId());
        return consumerMapper.update(consumer,wrapper) > 0;
    }

    @Override
    public boolean delete(int id) {
        return consumerMapper.deleteById(id) > 0;
    }

    @Override
    public Consumer get(Integer id) {
        return consumerMapper.selectById(id);
    }

    @Override
    public Page<Consumer> findAllByPage(int index, int size) {
        Page<Consumer> pages = new Page<>(index,size);
        return  consumerMapper.selectPage(pages,null);
    }

    @Override
    public List<Consumer> findAll() {
        return consumerMapper.selectList(null);
    }

    @Override
    public List<Consumer> getBySingerId(Integer id) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("singer_id",id);
        List<Consumer> list = consumerMapper.selectList(wrapper);
        return list;
    }

    /**
     * 用户名密码登录
     * @param consumer
     * @return
     */
    @Override
    public Consumer login(Consumer consumer) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("username",consumer.getUsername());
        wrapper.eq("password",consumer.getPassword());
        return  consumerMapper.selectOne(wrapper);
    }

    @Override
    public boolean findByName(Consumer consumer) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("username",consumer.getUsername());
        return  consumerMapper.selectCount(wrapper) > 0;
    }
}
