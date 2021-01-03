package com.junjie.music.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.junjie.music.entity.Singer;
import com.junjie.music.mapper.SingerMapper;
import com.junjie.music.service.SingerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author junjie
 * @since 2020-12-27
 */
@Service
public class SingerServiceImpl extends ServiceImpl<SingerMapper, Singer> implements SingerService {

    @Autowired
    SingerMapper singerMapper;

    @Override
    public boolean save(Singer singer) {
        return singerMapper.insert(singer) > 0;
    }

    @Override
    public boolean update(Singer singer) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("id",singer.getId());
        return singerMapper.update(singer,wrapper) > 0;
    }

    @Override
    public boolean delete(int id) {
       return singerMapper.deleteById(id) > 0;
    }

    @Override
    public Singer get(Integer id) {
        return singerMapper.selectById(id);
    }

    @Override
    public Page<Singer> findAllByPage(int index, int size) {
        Page<Singer> pages = new Page<>(index,size);
        return  singerMapper.selectPage(pages,null);
    }

    @Override
    public  List<Singer>findAll() {
        return singerMapper.selectList(null);
    }
    /**
     *  根据sex 获取歌曲
     * @param singer
     * @return
     */
    @Override
    public List<Singer> getBySex(Singer singer) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("sex",singer.getSex());
        List<Singer> list = singerMapper.selectList(wrapper);
        return  list;
    }
}
