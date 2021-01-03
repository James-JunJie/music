package com.junjie.music;
 
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.junjie.music.entity.Collect;
import com.junjie.music.service.CollectService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Description:TODO
 * @author:LiJunJie
 * @Date 2020/12/27
 */
@SpringBootTest
public class CollectTest {
    @Autowired
    CollectService collectService;

    /**
     * 测试 保存
     * */
    @Test
    public void testSave(){
        Collect collect = new Collect();
        collect.setSongId(1);
        collectService.save(collect);
    }

    @Test
    public void testUpdate(){
        Collect collect = new Collect();

        collectService.update(collect);
    }

    @Test
    public void testDelete(){

    }

    @Test
    public void testfind(){
        Collect collect = collectService.get(3);
        System.out.println(collect);
    }

    @Test
    public void test(){

    }
    /**
     * 查询use_id 与 song_id
     */
    @Test
    public void getBySongId(){
        Collect collect = new Collect();
        collect.setUserId(1);
        collect.setSongId(32);
        boolean bySongId = collectService.getBySongId(collect);
        System.out.println(bySongId);
    }
    /**
     * 查询use_id 与 song_list_id
     */
    @Test
    public void getBySongListId(){
        Collect collect = new Collect();
        collect.setUserId(1);
        collect.setSongListId(2);
        System.out.println("===="+collect);
        boolean bySongId = collectService.getBySongListId(collect);
        System.out.println("count:"+bySongId);
    }
}
