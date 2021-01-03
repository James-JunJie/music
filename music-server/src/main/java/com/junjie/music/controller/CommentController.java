package com.junjie.music.controller;


import com.junjie.music.entity.Comment;
import com.junjie.music.result.Code;
import com.junjie.music.result.Result;
import com.junjie.music.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 评论 前端控制器
 * </p>
 *
 * @author junjie
 * @since 2020-12-27
 */
@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    CommentService commentService;
    /**
     * 添加
     * @param comment
     * @return
     */
    @RequestMapping("/add")
    public Result add(Comment comment){
        boolean flag = commentService.save(comment);
        return new Result(flag ? Code.OK: Code.EEROR,flag ? "添加成功":"添加失败");
    }
    /**
     * 查询所有
     * @return
     */
    @RequestMapping("/allComment")
    public List<Comment> allComment(){
        return commentService.findAll();
    }

    /**
     * 删除
     * @param comment
     * @return
     */
    @RequestMapping("/delete")
    public Result delete(Comment comment){
        boolean flag = commentService.delete(comment);
        return new Result(flag ? Code.OK: Code.EEROR,flag ? "删除成功":"删除失败");
    }
    /**
     * 更新
     * @param comment
     * @return
     */
    @RequestMapping("/update")
    public Result update(Comment comment){
        boolean flag = commentService.update(comment);
        return new Result(flag ? Code.OK: Code.EEROR);
    }
    /**
    * 点赞
    * */
    @RequestMapping("/like")
    public Result like(Comment comment){
        boolean flag = commentService.update(comment);
        return new Result(flag ? Code.OK: Code.EEROR);
    }
    /**
     * 根据 歌单id
     * 获取当前歌单或歌曲的评论列表
     * */
    @RequestMapping("/commentOfSongListId")
    public List<Comment> commentOfSongListId(int songListId){
        List<Comment> list = commentService.findBySongListId(songListId);
        return  list;
    }
    /**
     * 更加歌曲 id
     * 获取当前歌单或歌曲的评论列表
     * */
    @RequestMapping("/commentOfSongId")
    public List<Comment> commentOfSongId(int songId){
        List<Comment> list =  commentService.findBySongId(songId);
        return  list;
    }

}

