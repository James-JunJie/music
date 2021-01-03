package com.junjie.music.service.impl;

 
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.junjie.music.entity.ListSong;
import com.junjie.music.entity.SongList;
import com.junjie.music.mapper.ListSongMapper;
import com.junjie.music.service.ListSongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 歌单包含歌曲列表 服务实现类
 * </p>
 *
 * @author junjie
 * @since 2020-12-27
 */
@Service
public class ListSongServiceImpl extends ServiceImpl<ListSongMapper, ListSong> implements ListSongService {

    @Autowired
    ListSongMapper listSongMapper;


    @Override
    public boolean save(ListSong listSong) {
       return listSongMapper.insert(listSong) >0 ;
    }

    @Override
    public boolean update(ListSong listSong) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("id",listSong.getId());
        return listSongMapper.update(listSong,wrapper) > 0;
    }
    @Override
    public boolean delete(ListSong listSong) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("song_id",listSong.getSongId());
        wrapper.eq("song_list_id",listSong.getSongListId());
        return listSongMapper.delete(wrapper) >0;
    }

    @Override
    public ListSong get(Integer id) {
        return listSongMapper.selectById(id);
    }

    @Override
    public List<ListSong> findAll() {
        return listSongMapper.selectList(null);
    }
}
