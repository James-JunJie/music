package com.junjie.music.controller;


 
import com.junjie.music.entity.Collect;
import com.junjie.music.result.Code;
import com.junjie.music.result.Result;
import com.junjie.music.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 收藏 前端控制器
 * </p>
 *
 * @author junjie
 * @since 2020-12-27
 */
@RestController
@RequestMapping("/collect")
public class CollectController {
    @Autowired
    CollectService collectService;
    /**
     * 添加
     * @param collect
     * @return
     */
    @RequestMapping("/add")
    public Result add(Collect collect){
        Boolean type = collect.getType();
        System.out.println("type: "+type);
        boolean flagSong = collectService.getBySongId(collect);
        boolean flagSongList = collectService.getBySongListId(collect);
        //0 歌曲,判断是否含有该歌曲
        if((!type&&flagSong)||(type&&flagSongList)){
            //错误有该歌曲
            return  new Result(2,"已收藏");
        }else{
            //插入
            boolean flag = collectService.save(collect);
            return new Result(flag ? Code.OK: Code.EEROR,flag ? "收藏成功":"收藏失败");
        }
    }
    /**
     * 查询所有
     * @return
     */
    @RequestMapping("/findCollect")
    public List<Collect> findCollect(){
        return collectService.findAll();
    }

    /**
     * 删除
     * @param collect
     * @return
     */
    @RequestMapping("/delete")
    public Result delete(Collect collect){
        boolean flag = collectService.delete(collect);
        return new Result(flag ? Code.OK: Code.EEROR,flag ? "删除成功":"删除失败");
    }
    /**
     * 更新
     * @param collect
     * @return
     */
    @RequestMapping("/update")
    public Result update(Collect collect){
        boolean flag = collectService.update(collect);
        return new Result(flag ? Code.OK: Code.EEROR);
    }
    /**
     * 通过userId 获取收藏歌曲
     * */
    @RequestMapping("/collectOfUserId")
    public List<Collect> like(Collect collect){
        List<Collect> list = collectService.findByUserId(collect);
        return  list;
    }
}

