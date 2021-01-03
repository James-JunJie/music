package com.junjie.music.service;
 
import com.baomidou.mybatisplus.extension.service.IService;
import com.junjie.music.entity.Collect;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 收藏 服务类
 * </p>
 *
 * @author junjie
 * @since 2020-12-27
 */
public interface CollectService extends IService<Collect> {
    /**
     * 增加
     * @param collect
     * @return
     */
    @Transactional(readOnly = false)
    public boolean save(Collect collect);

    /**
     * 更新
     * @param collect
     * @return
     */
    @Transactional(readOnly = false)
    public boolean update(Collect collect);

    /**
     * 删除
     * @param collect
     * @return
     */
    @Transactional(readOnly = false)
    public boolean delete(Collect collect);
    /**
     * 根据id获取
     * @param id
     * @return
     */
    public Collect get(Integer id);
    /**
     * 获取全部U
     * @return
     */
    public List<Collect> findAll( );

    /**
     *根据userId 获取收藏信息
     * @param collect
     * @return
     */
    public List<Collect> findByUserId(Collect collect);

    /**
     *查询use_id 与 song_id
     * @param collect
     * @return
     */
    public boolean getBySongId(Collect collect);
    /**
     *查询use_id 与 song_list_id
     * @param collect
     * @return
     */
    public boolean getBySongListId(Collect collect);
}
