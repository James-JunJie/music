package com.junjie.music;

import com.junjie.music.entity.ListSong;
import com.junjie.music.service.ListSongService;
import com.junjie.music.service.SingerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

/**
 * @Description:TODO
 * @author:LiJunJie
 * @Date 2020/12/29
 */
@SpringBootTest
public class ListSongTest {
    @Autowired
    ListSongService listSongService;

    /**
     * 测试 保存
     * */
    @Test
    public void testSave(){
        ListSong listSong = new ListSong();
        listSong.setSongId(1);
        listSong.setSongListId(1);
        listSongService.save(listSong);
    }

    @Test
    public void testUpdate(){
        ListSong listSong = new ListSong();
        listSongService.update(listSong);
    }

    @Test
    public void testDelete(){
        ListSong listSong  = new ListSong();
        listSong.setSongListId(2);
        listSong.setSongId(1);
        listSongService.delete(listSong);
    }
}
