package com.junjie.music.service;
 
import com.baomidou.mybatisplus.extension.service.IService;
import com.junjie.music.entity.Ranks;
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
public interface RanksService extends IService<Ranks> {
    /**
     * 增加
     * @param ranks
     * @return
     */
    @Transactional(readOnly = false)
    public boolean save(Ranks ranks);

    /**
     * 更新
     * @param ranks
     * @return
     */
    @Transactional(readOnly = false)
    public boolean update(Ranks ranks);

    /**
     * 删除
     * @param ranks
     * @return
     */
    @Transactional(readOnly = false)
    public boolean delete(Ranks ranks);
    /**
     * 根据id获取
     * @param id
     * @return
     */
    public Ranks get(Integer id);
    /**
     * 获取全部U
     * @return
     */
    public List<Ranks> findAll( );

    /**
     *获取指定歌单的平均分
    * */
    public List<Ranks> findBySongListId(int songListId);
}
