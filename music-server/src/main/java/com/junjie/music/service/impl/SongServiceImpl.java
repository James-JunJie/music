package com.junjie.music.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.junjie.music.entity.Singer;
import com.junjie.music.entity.Song;
import com.junjie.music.mapper.SongMapper;
import com.junjie.music.service.SongService;
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
public class SongServiceImpl extends ServiceImpl<SongMapper, Song> implements SongService {
    @Autowired
    SongMapper songMapper;

    @Override
    public boolean save(Song song) {
        return songMapper.insert(song) > 0;
    }

    @Override
    public boolean update(Song song) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("id",song.getId());
        return songMapper.update(song,wrapper) > 0;
    }

    @Override
    public boolean delete(int id) {
        return songMapper.deleteById(id) > 0;
    }

    @Override
    public Song get(Integer id) {
        return songMapper.selectById(id);
    }

    @Override
    public Page<Song> findAllByPage(int index, int size) {
        Page<Song> pages = new Page<>(index,size);
        return  songMapper.selectPage(pages,null);
    }

    @Override
    public List<Song> findAll() {
        return songMapper.selectList(null);
    }

    @Override
    public List<Song> getBySingerId(Integer id) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("singer_id",id);
        List<Song> list = songMapper.selectList(wrapper);
        return list;
    }

    /**
     * 根据歌曲名 获取歌曲id
     * @param songName
     * @return
     */
    @Override
    public List<Song> getByName(String songName) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("name",songName);
        List<Song> list = songMapper.selectList(wrapper);
        return list;
    }
    /**
     * 根据歌手名模糊 获取歌曲
     * @param singerName
     * @return
     */
    @Override
    public List<Song> getBySingerName(String singerName) {
        List<Song>  list = songMapper.selectBySingerName(singerName);
        return list;
    }
}
