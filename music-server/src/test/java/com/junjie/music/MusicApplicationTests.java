package com.junjie.music;



import com.junjie.music.service.AdminService;
import com.junjie.music.service.SingerService;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class MusicApplicationTests {
    @Autowired
    private SingerService  singerService;

    @Autowired
    private AdminService adminService;

    @Test
    public void loginTest(){
        boolean admin = adminService.login("admin", "123");
        System.out.println(admin);
    }
    /**
     *
     * 测试注册
     */
    @Test
    public void insertTest(){

    }

}
