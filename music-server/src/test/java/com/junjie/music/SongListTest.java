package com.junjie.music;

 
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.junjie.music.entity.SongList;
import com.junjie.music.service.SongListService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

/**
 * @Description:TODO
 * @author:LiJunJie
 * @Date 2020/12/29
 */
@SpringBootTest
public class SongListTest {

    @Autowired
    SongListService songListService;

    /**
     * 测试 保存
     * */
    @Test
    public void testSave(){
        SongList songList = new SongList();
        songList.setTitle("tylor歌单");
        songList.setStyle("流行");
        System.out.println();
        songListService.save(songList);
    }

    @Test
    public void testUpdate(){
        SongList songList = new SongList();
        songList.setStyle("重低音");
        songList.setId(3);
        songListService.update(songList);
    }

    @Test
    public void testDelete(){
        int songId=1;
        int songListId=1;
        songListService.deleteSong(songId,songListId);
    }

    @Test
    public void testfind(){
        SongList songList = songListService.get(2);
        System.out.println(songList);
    }

    @Test
    public void test(){
        Page<SongList> all = songListService.findAllByPage(1, 2);
        System.out.println(all);
    }
    @Test
    public void testFindAll(){
        songListService.findAll().forEach(System.out::println);
    }
    @Test
    public void getBySongListId(){
        songListService.getBySongListId(1);
    }

    /**
     * 根据歌单名获取歌单list
     */
    @Test
    public void getByTile(){
        SongList songList = new SongList();
        songList.setTitle("单");
        songListService.getByTile(songList).forEach(System.out::println);
    }
    /**
     * 根据style 查询歌单
     */
    @Test
    public void getByStyle(){
        songListService.getByStyle("华语").forEach(System.out::println);
    }
}
