package com.junjie.music.controller;


import com.junjie.music.entity.Ranks;
import com.junjie.music.result.Code;
import com.junjie.music.result.Result;
import com.junjie.music.service.RanksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author junjie
 * @since 2020-12-27
 */
@RestController
@RequestMapping("/rank")
public class RanksController {
    @Autowired
    RanksService ranksService;
    /**
     * 添加
     * @param ranks
     * @return
     */
    @RequestMapping("/add")
    public Result add(Ranks ranks){
        boolean flag = ranksService.save(ranks);
        return new Result(flag ? Code.OK: Code.EEROR,flag ? "添加成功":"添加失败");
    }
    /**
     * 查询所有
     * @return
     */
    @RequestMapping("/allRanks")
    public List<Ranks> allRanks(){
        return ranksService.findAll();
    }

    /**
     * 删除
     * @param ranks
     * @return
     */
    @RequestMapping("/delete")
    public Result delete(Ranks ranks){
        boolean flag = ranksService.delete(ranks);
        return new Result(flag ? Code.OK: Code.EEROR,flag ? "删除成功":"删除失败");
    }
    /**
     * 更新
     * @param ranks
     * @return
     */
    @RequestMapping("/update")
    public Result update(Ranks ranks){
        boolean flag = ranksService.update(ranks);
        return new Result(flag ? Code.OK: Code.EEROR);
    }
    /**
    * 获取指定歌单的平均分
    * */
    @RequestMapping("songListId")
    public List<Ranks> allRanks(int songListId){
        List<Ranks> list = ranksService.findBySongListId(songListId);
        return list;
    }
}

