package com.junjie.music;

 
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.junjie.music.entity.Consumer;
import com.junjie.music.service.ConsumerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

/**
 * @Description:TODO
 * @author:LiJunJie
 * @Date 2020/12/27
 */
@SpringBootTest
public class ComsumerTest {
    @Autowired
    ConsumerService consumerService;

    /**
     * 测试登录
     */
    @Test
    public void testLogin(){
        Consumer consumer = new Consumer();
        consumer.setUsername("李俊杰");
        consumer.setPassword("1236");
        boolean byName = consumerService.findByName(consumer);
        System.out.println(byName);
    }

    /**
     * 测试 保存
     * */
    @Test
    public void testSave(){
        Consumer consumer = new Consumer();
        consumer.setUsername("李俊杰");
        consumer.setPassword("123456");
        consumer.setBirth(new Date());
        consumer.setSex(1);
        consumerService.save(consumer);
    }

    @Test
    public void testUpdate(){
        Consumer consumer = new Consumer();
        consumer.setUsername("李俊杰");
        consumer.setBirth(new Date());
        consumer.setId(1);
        consumerService.update(consumer);
    }

    @Test
    public void testDelete(){
        consumerService.delete(2);
    }

    @Test
    public void testfind(){
        Consumer consumer = consumerService.get(1);
        System.out.println(consumer);
    }

    @Test
    public void test(){
        Page<Consumer> all = consumerService.findAllByPage(1, 2);
        System.out.println(all);
    }
    @Test
    public void testFindAll(){
        consumerService.findAll().forEach(System.out::println);
    }
}
