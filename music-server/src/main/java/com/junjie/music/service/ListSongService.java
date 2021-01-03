package com.junjie.music.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.junjie.music.entity.ListSong;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 歌单包含歌曲列表 服务类
 * </p>
 *
 * @author junjie
 * @since 2020-12-27
 */
public interface ListSongService extends IService<ListSong> {
    /**
     * 保存
     * @param listSong
     * @return
     */
    @Transactional(readOnly = false)
    public boolean save(ListSong listSong);

    /**
     * 更新
     * @param listSong
     * @return
     */
    @Transactional(readOnly = false)
    public boolean update(ListSong listSong);
    /**
     * 删除
     * @param listSong
     * @return
     */
    @Transactional(readOnly = false)
    public boolean delete(ListSong listSong);

    /**
     * 根据id获取
     * @param id
     * @return
     */
    public ListSong get(Integer id);

    /**
     * 获取全部User
     * @return
     */
    public List<ListSong> findAll( );
}
