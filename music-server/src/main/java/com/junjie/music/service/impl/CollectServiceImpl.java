package com.junjie.music.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.junjie.music.entity.Collect;
import com.junjie.music.entity.Collect;
import com.junjie.music.mapper.CollectMapper;
import com.junjie.music.mapper.CollectMapper;
import com.junjie.music.service.CollectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 收藏 服务实现类
 * </p>
 *
 * @author junjie
 * @since 2020-12-27
 */
@Service
public class CollectServiceImpl extends ServiceImpl<CollectMapper, Collect> implements CollectService {

    @Autowired
    CollectMapper collectMapper;

    /**
     * 保存
     * @param collect
     * @return
     */
    @Override
    public boolean save(Collect collect) {
        return collectMapper.insert(collect) > 0;
    }
    @Override
    public boolean update(Collect collect) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("id", collect.getId());
        return collectMapper.update(collect,wrapper) > 0;
    }

    @Override
    public boolean delete(Collect collect) {
        return collectMapper.deleteById(collect.getId())> 0;
    }

    @Override
    public Collect get(Integer id) {
        return collectMapper.selectById(id);
    }

    @Override
    public  List<Collect>findAll() {
        return collectMapper.selectList(null);
    }

    @Override
    public List<Collect> findByUserId(Collect collect) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("user_id", collect.getUserId());
        List<Collect>  list = collectMapper.selectList(wrapper);
        return list;
    }

    /**
     * 查询use_id 与 song_id 
     * @param collect
     * @return
     */
    @Override
    public boolean getBySongId(Collect collect) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("user_id", collect.getUserId());
        wrapper.eq("song_id", collect.getSongId());
        return  collectMapper.selectCount(wrapper) >0;
    }
    /**
     * 查询use_id 与 song_list_id
     * @param collect
     * @return
     */
    @Override
    public boolean getBySongListId(Collect collect) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("user_id", collect.getUserId());
        wrapper.eq("song_list_id", collect.getSongListId());
        return  collectMapper.selectCount(wrapper) > 0;
    }

}
