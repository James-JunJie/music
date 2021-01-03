package com.junjie.music.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.junjie.music.entity.Comment;
import com.junjie.music.mapper.CommentMapper;
import com.junjie.music.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 评论 服务实现类
 * </p>
 *
 * @author junjie
 * @since 2020-12-27
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

    @Autowired
    CommentMapper commentMapper;

    @Override
    public boolean save(Comment commenet) {
        return commentMapper.insert(commenet) > 0;
    }

    @Override
    public boolean update(Comment commenet) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("id", commenet.getId());
        return commentMapper.update(commenet,wrapper) > 0;
    }

    @Override
    public boolean delete(Comment commenet) {
        return commentMapper.deleteById(commenet.getId())> 0;
    }

    @Override
    public Comment get(Integer id) {
        return commentMapper.selectById(id);
    }

    @Override
    public  List<Comment>findAll() {
        return commentMapper.selectList(null);
    }
    /**
     * 根据歌单id获取
     * */
    @Override
    public List<Comment> findBySongListId(int songListId) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("song_list_id",songListId);
        List<Comment>  list = commentMapper.selectList(wrapper);
        return list;
    }
    /**
     * 根据歌曲id获取
     * */
    @Override
    public List<Comment> findBySongId(int songId) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("song_id",songId);
        commentMapper.selectList(wrapper);
        List<Comment>  list = commentMapper.selectList(wrapper);
        return list;
    }
}
