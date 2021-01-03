package com.junjie.music.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.junjie.music.entity.Ranks;
import com.junjie.music.mapper.RankMapper;
import com.junjie.music.service.RanksService;
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
public class RanksServiceImpl extends ServiceImpl<RankMapper, Ranks> implements RanksService {
    @Autowired
    RankMapper rankMapper;

    @Override
    public boolean save(Ranks ranks) {
        return rankMapper.insert(ranks) > 0;
    }

    @Override
    public boolean update(Ranks ranks) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("id", ranks.getId());
        return rankMapper.update(ranks,wrapper) > 0;
    }

    @Override
    public boolean delete(Ranks ranks) {
        return rankMapper.deleteById(ranks.getId())> 0;
    }

    @Override
    public Ranks get(Integer id) {
        return rankMapper.selectById(id);
    }

    @Override
    public  List<Ranks>findAll() {
        return rankMapper.selectList(null);
    }
    /**
     *获取指定歌单的平均分
     * */
    @Override
    public List<Ranks> findBySongListId(int songListId) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("song_list_id",songListId);
        List<Ranks> list = rankMapper.selectList(wrapper);
        return list;
    }
}
