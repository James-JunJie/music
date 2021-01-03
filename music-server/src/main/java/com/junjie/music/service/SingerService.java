package com.junjie.music.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.junjie.music.entity.Singer;
import com.baomidou.mybatisplus.extension.service.IService;
import com.junjie.music.entity.Song;
import com.junjie.music.mapper.SingerMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
public interface SingerService extends IService<Singer> {
    /**
     * 增加
     * @param singer
     * @return
     */
    @Transactional(readOnly = false)
    public boolean save(Singer singer);

    /**
     * 更新
     * @param singer
     * @return
     */
    @Transactional(readOnly = false)
    public boolean update(Singer singer);

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
    public Singer get(Integer id);

    /**
     * 获取全部User 分页
     * @return
     */
    public Page<Singer> findAllByPage(int page, int size);
    /**
     * 获取全部User
     * @return
     */
    public  List<Singer> findAll( );

    /**
     *  根据sex 获取曲
     * @param singer
     * @return
     */
     public List<Singer> getBySex(Singer singer);
}
