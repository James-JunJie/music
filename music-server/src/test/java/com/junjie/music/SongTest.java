package com.junjie.music;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.junjie.music.entity.Song;
import com.junjie.music.service.SongService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



/**
 * @Description:TODO
 * @author:LiJunJie
 * @Date 2020/12/27
 */
@SpringBootTest
public class SongTest {
    @Autowired
    SongService songService;

    /**
     * 测试 保存
     * */
    @Test
    public void testSave(){
        Song song = new Song();
        song.setName("刘德华");
        songService.save(song);
    }

    @Test
    public void testUpdate(){
        Song song = new Song();
        song.setName("李俊杰");
        song.setId(3);
        songService.update(song);
    }

    @Test
    public void testDelete(){
        songService.delete(2);
    }

    @Test
    public void testfind(){
        Song song = songService.get(3);
        System.out.println(song);
    }

    @Test
    public void test(){
        Page<Song> all = songService.findAllByPage(1, 2);
        System.out.println(all);
    }
    @Test
    public void testFindAll(){
        songService.findAll().forEach(System.out::println);
    }

    @Test
    public void getBySingerId(){
        songService.getBySingerId(9).forEach(System.out::println);
    }

    @Test
    public void getByName(){
        songService.getByName("李俊杰").forEach(System.out::println);
    }

    @Test
    public void getSingerName(){
        songService.getBySingerName("伍佰").forEach(System.out::println);
    }


}
