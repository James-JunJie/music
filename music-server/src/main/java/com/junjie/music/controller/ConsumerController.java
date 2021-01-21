package com.junjie.music.controller;


import com.junjie.music.entity.Consumer;
import com.junjie.music.entity.SongList;
import com.junjie.music.result.Code;
import com.junjie.music.result.Result;
import com.junjie.music.service.ConsumerService;
import com.junjie.music.utils.FastDFSUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 * <p>
 * 用户 前端控制器
 * </p>
 *
 * @author junjie
 * @since 2020-12-27
 */
@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    @Autowired
    ConsumerService consumerService;

    /**
     * 登录
     * */
    @RequestMapping("/login")
    public Result login(Consumer consumer){
        Consumer login = consumerService.login(consumer);
        return new Result(login != null ? Code.OK:Code.EEROR,login)  ;
    }

    /**
     * 添加 注册
     * @param consumer
     * @return
     */
    @RequestMapping("/add")
    public Result add(Consumer consumer){

        //查询用户名是否已经注册
        boolean isname = consumerService.findByName(consumer);
        if(isname){
            //已经注册
            return new Result(Code.EEROR,"该用户名已经注册");
        }else {
            boolean flag = consumerService.save(consumer);
            //已经注册
            return new Result(Code.OK,"注册成功");
        }
    }
    /**
     * 查询所有歌手
     * @return
     */
    @RequestMapping("/allConsumer")
    public List<Consumer> allConsumer(){
        return consumerService.findAll();
    }

    /**
     * 更新图片
     * @param file
     * @param id
     * @return
     */
    @RequestMapping(value = "/updateConsumerPic", method = RequestMethod.POST)
    public Result updataPic(@RequestParam("file") MultipartFile file, int id) throws IOException {
        //首先判断是否是空文件，也就是存储空间占用为0的文件
        if(file.isEmpty()){
            return  new Result(Code.EEROR,"上传失败");
        }
        //1.先将文件保存fastdfs
        //获取文件对应的字节数组
        byte[] buffFile=file.getBytes();
        //获取文件名
        String fileName=file.getOriginalFilename();
        Long fileSize=file.getSize();
        String fileType=file.getContentType();
        //可能会出现问题因为有些文件可能没有扩展名，因此必要时需要做逻辑控制
        String fileExtName=fileName.substring(fileName.lastIndexOf(".")+1);
        /**
         * 调用util工具类进行上传
         * */
        String[] result= FastDFSUtil.upload(buffFile,fileExtName);
        String groupName = result[0];
        String remoteFilePath =  result[1];
        String url = "/"+groupName+"/"+remoteFilePath;

        //2.加入url,添加
        //获取id对应的实体
        Consumer consumer = consumerService.getById(id);
        String avator = consumer.getAvator();
        //2.1 如果有url,则需要删除fastDFS中的数据，以免成为野文件
        if(avator!= null||!"".equals(avator)){
            String groupNameOld = avator.substring(1,avator.indexOf("M")-1);
            String remoteFilePathOld = avator.substring(avator.indexOf("M"));
            FastDFSUtil.delete(groupNameOld,remoteFilePathOld);
        }
        consumer.setAvator(url);
        boolean flag = consumerService.update(consumer);
        return new Result(flag ? Code.OK: Code.EEROR);
    }

    /**
     * 删除歌手
     * @param id
     * @return
     */
    @RequestMapping("/delete")
    public Result delete(int id){
        System.out.println("delete:  "+id);
        boolean flag = consumerService.delete(id);
        return new Result(flag ? Code.OK: Code.EEROR,flag ? "删除成功":"删除失败");
    }
    /**
     * 更新
     * @param consumer
     * @return
     */
    @RequestMapping("/update")
    public Result update(Consumer consumer){
        boolean flag = consumerService.update(consumer);
        return new Result(flag ? Code.OK: Code.EEROR);
    }
    /**
     * 根据id 查询
     * */
    @RequestMapping("/consumerId")
    public Consumer consumerId(int id){
        Consumer consumer = consumerService.get(id);
        return consumer;
    }
}

