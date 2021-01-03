package com.junjie.music.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.junjie.music.entity.Song;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author junjie
 * @since 2020-12-27
 */
public interface SongService extends IService<Song> {
    /**
     * 保存
     * @param song
     * @return
     */
    @Transactional(readOnly = false)
    public boolean save(Song song);

    /**
     * 更新
     * @param song
     * @return
     */
    @Transactional(readOnly = false)
    public boolean update(Song song);

    /**
     * 删除
     * @param id
     * @return
     */
    @Transactional(readOnly = false)
    public boolean delete(int id);

    /**
     * 根据id获取user
     * @param id
     * @return
     */
    public Song get(Integer id);

    /**
     * 获取全部User 分页
     * @return
     */
    public Page<Song> findAllByPage(int page, int size);
    /**
     * 获取全部User
     * @return
     */
    public List<Song> findAll( );


    /**
     * 根据 singerId 获取 song
     * @param id
     * @return
     */
    public List<Song> getBySingerId(Integer id);

    /**
     * 根据歌曲名获取歌曲id
     * @param songName
     */
    public List<Song> getByName(String songName);
    /**
     * 根据歌手名获取歌曲
     * @param singerName
     */
    List<Song> getBySingerName(String singerName);
}
