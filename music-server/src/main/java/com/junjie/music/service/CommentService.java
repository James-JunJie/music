package com.junjie.music.service;

 

import com.baomidou.mybatisplus.extension.service.IService;
import com.junjie.music.entity.Comment;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 评论 服务类
 * </p>
 *
 * @author junjie
 * @since 2020-12-27
 */
public interface CommentService extends IService<Comment> {
    /**
     * 增加
     * @param comment
     * @return
     */
    @Transactional(readOnly = false)
    public boolean save(Comment comment);

    /**
     * 更新
     * @param comment
     * @return
     */
    @Transactional(readOnly = false)
    public boolean update(Comment comment);

    /**
     * 删除
     * @param comment
     * @return
     */
    @Transactional(readOnly = false)
    public boolean delete(Comment comment);
    /**
     * 根据id获取
     * @param id
     * @return
     */
    public Comment get(Integer id);
    /**
     * 获取全部
     * @return
     */
    public List<Comment> findAll();
    /**
     * 根据歌单id获取
     * */
    public List<Comment> findBySongListId(int songListId);
    /**
     * 根据歌曲id获取
     * */
    public List<Comment> findBySongId(int songId);
}
