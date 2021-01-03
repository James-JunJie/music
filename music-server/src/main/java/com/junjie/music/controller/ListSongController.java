package com.junjie.music.controller;


import com.junjie.music.entity.ListSong;
import com.junjie.music.entity.Song;
import com.junjie.music.result.Code;
import com.junjie.music.result.Result;
import com.junjie.music.service.ListSongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 歌单包含歌曲列表 前端控制器
 * </p>
 *
 * @author junjie
 * @since 2020-12-27
 */
@RestController
@RequestMapping("/listSong")
public class ListSongController {
    
    @Autowired
    ListSongService listSongService;
    /**
     * 添加
     * @param listSong
     * @return
     */
    @RequestMapping("/add")
    public Result add(ListSong listSong){
        boolean flag = listSongService.save(listSong);
        return new Result(flag ? Code.OK: Code.EEROR,flag ? "添加成功":"添加失败");
    }
    /**
     * 查询所有
     * @return
     */
    @RequestMapping("/allSongList")
    public List<ListSong> allSongList(){
        return listSongService.findAll();
    }

    /**
     * 删除
     * @param listSong
     * @return
     */
    @RequestMapping("/delete")
    public Result delete(ListSong listSong){
        boolean flag = listSongService.delete(listSong);
        return new Result(flag ? Code.OK: Code.EEROR,flag ? "删除成功":"删除失败");
    }
    /**
     * 更新
     * @param listSong
     * @return
     */
    @RequestMapping("/update")
    public Result update(ListSong listSong){
        boolean flag = listSongService.update(listSong);
        return new Result(flag ? Code.OK: Code.EEROR);
    }
}

