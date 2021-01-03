package com.junjie.music;

import com.junjie.music.entity.Ranks;
import com.junjie.music.service.RanksService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Description:TODO
 * @author:LiJunJie
 * @Date 2020/12/27
 */
@SpringBootTest
public class RanksTest {
    @Autowired
    RanksService ranksService;

    /**
     * 测试 保存
     * */
    @Test
    public void testSave(){
        Ranks ranks = new Ranks();
        ranks.setConsumerId(1);
        ranks.setSongListId(12);
        ranks.setScore(100);
        ranksService.save(ranks);
    }

    @Test
    public void testUpdate(){
        Ranks ranks = new Ranks();

        ranksService.update(ranks);
    }

    @Test
    public void testDelete(){
        /*ranksService.delete();*/
    }

    @Test
    public void testfind(){
        Ranks ranks = ranksService.get(3);
        System.out.println(ranks);
    }

    @Test
    public void testFindAll(){
        ranksService.findAll().forEach(System.out::println);
    }

}
