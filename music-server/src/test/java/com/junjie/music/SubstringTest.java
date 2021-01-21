package com.junjie.music;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Description:TODO
 * @author:LiJunJie
 * @Date 2021/1/14
 */
@SpringBootTest
public class SubstringTest {
    @Test
    public void test(){
        String url = "/group1/M00/00/00/rBCrkWAAFPKARA2fADdBp5Czkq8242.mp3";
        //截取url 成 group1  和 M00/00/00/rBCrkWAAFPKARA2fADdBp5Czkq8242.mp3
        String groupName = url.substring(1,url.indexOf("M")-1);
        String remoteFilePath = url.substring(url.indexOf("M"));
        System.out.println(remoteFilePath);
        System.out.println(groupName);
        String url1 = "/"+groupName+"/"+remoteFilePath;
        System.out.println(url1);
    }
}
