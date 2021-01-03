package com.junjie.music.service;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.junjie.music.entity.Song;
import com.junjie.music.entity.SongList;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 歌单 服务类
 * </p>
 *
 * @author junjie
 * @since 2020-12-27
 */
@Service
public interface SongListService extends IService<SongList> {
    /**
     * 保存
     * @param songList
     * @return
     */
    @Transactional(readOnly = false)
    public boolean save(SongList songList);

    /**
     * 更新
     * @param songList
     * @return
     */
    @Transactional(readOnly = false)
    public boolean update(SongList songList);

    /**
     * 删除
     * @param songId
     * @param songId
     * @return
     */
    @Transactional(readOnly = false)
    public boolean deleteSong(int songId,int songListId);
    /**
     * 删除
     * @param id
     * @return
     */
    @Transactional(readOnly = false)
    public boolean delete(int id);

    /**
     * 根据id获取
     * @param id
     * @return
     */
    public SongList get(Integer id);

    /**
     * 获取全部User 分页
     * @return
     */
    public Page<SongList> findAllByPage(int page, int size);
    /**
     * 获取全部User
     * @return
     */
    public  List<SongList> findAll( );

    /**
     * 根据 songListId 获取 song
     * @param id
     * @return
     */
    public List<Song> getBySongListId(Integer id);

    /**
     * 获取歌单
     * @param songList
     * @return
     */
    public List<SongList> getByTile(SongList songList);

    /**
     * 根据style 查询歌单
     * @param style
     * @return
     */

     public List<SongList> getByStyle(String style);
}
