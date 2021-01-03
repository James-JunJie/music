package com.junjie.music.service.impl;

 
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.junjie.music.entity.Song;
import com.junjie.music.entity.SongList;
import com.junjie.music.mapper.SongListMapper;
import com.junjie.music.service.SongListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 歌单 服务实现类
 * </p>
 *
 * @author junjie
 * @since 2020-12-27
 */
@Service
public class SongListServiceImpl extends ServiceImpl<SongListMapper, SongList> implements SongListService {

    @Autowired
    SongListMapper songListMapper;

    @Override
    public boolean save(SongList singer) {
        return songListMapper.insert(singer) > 0;
    }

    @Override
    public boolean update(SongList singer) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("id",singer.getId());
        return songListMapper.update(singer,wrapper) > 0;
    }

    @Override
    public boolean deleteSong(int songId, int songListId) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("song_id",songId);
        wrapper.eq("song_list_id",songListId);
        return songListMapper.deleteBySong(songId,songListId);
    }
    @Override
    public boolean delete(int id) {
        return songListMapper.deleteById(id) >0;

    }

    @Override
    public SongList get(Integer id){
        return songListMapper.selectById(id);
    }
    @Override
    public Page<SongList> findAllByPage(int index, int size) {
        Page<SongList> pages = new Page<>(index,size);
        return  songListMapper.selectPage(pages,null);
    }

    @Override
    public  List<SongList>findAll() {
        return songListMapper.selectList(null);
    }

    /**
     * 根据 song_list_id 获取 song
     * @param id
     * @return
     */
    @Override
    public List<Song> getBySongListId(Integer id) {
        List<Song> list = songListMapper.songBySongListId(id);
        return list;
    }

    /**
     * 根据歌单名获取歌单list
     * @param songList
     * @return
     */
    @Override
    public List<SongList> getByTile(SongList songList) {
        return songListMapper.selectByTitle(songList.getTitle());
    }
    /**
     * 根据style 查询歌单
     * @param style
     * @return
     */
    @Override
    public List<SongList> getByStyle(String style) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("style",style);
        List<SongList> list = songListMapper.selectList(wrapper);
        return list;
    }
}
