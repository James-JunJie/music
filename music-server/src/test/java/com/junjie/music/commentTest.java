package com.junjie.music;
 
import com.junjie.music.entity.Comment;
import com.junjie.music.service.CommentService;
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
public class commentTest {
    @Autowired
    CommentService commentService;

    /**
     * 测试 保存
     * */
    @Test
    public void testSave(){
        Comment comment = new Comment();
        comment.setSongId(1);
        commentService.save(comment);
    }

    @Test
    public void testUpdate(){
        Comment comment = new Comment();

        commentService.update(comment);
    }

    @Test
    public void testDelete(){

    }

    @Test
    public void testfind(){
        Comment comment = commentService.get(3);
        System.out.println(comment);
    }

    @Test
    public void test(){
     Comment comment = new Comment();
     comment.setId(2);
     comment.setUp(3);
     commentService.update(comment);

    }
    @Test
    public void testFindAll(){
        commentService.findAll().forEach(System.out::println);
    }
}
