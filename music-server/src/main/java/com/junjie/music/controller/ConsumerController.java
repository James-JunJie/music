package com.junjie.music.controller;


import com.junjie.music.entity.Consumer;
import com.junjie.music.result.Code;
import com.junjie.music.result.Result;
import com.junjie.music.service.ConsumerService;
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
    public Result updataPic(@RequestParam("file") MultipartFile file, int id) throws FileNotFoundException {
        //首先判断是否是空文件，也就是存储空间占用为0的文件
        if(file.isEmpty()){
            return  new Result(Code.EEROR,"上传失败");
        }
        //文件名=当前时间到毫秒+原来的文件名
        String fileName = System.currentTimeMillis()+file.getOriginalFilename();
        //文件路径
        String filePath = ResourceUtils.getURL("classpath:").getPath() + "static/img/userPic";
        //如果文件路径不存在，新增该路径
        File file1 = new File(filePath);
        if(!file1.exists()){
            file1.mkdir();
        }
        //实际的文件地址
        File dest = new File(filePath+System.getProperty("file.separator")+fileName);
        //存储到数据库里的相对文件地址
        String storeAvatorPath = "/img/userPic/"+fileName;
        try {
            file.transferTo(dest);
            Consumer consumer = new Consumer();
            consumer.setId(id);
            consumer.setAvator( storeAvatorPath);
            boolean flag = consumerService.update(consumer);
            return new Result(flag ? Code.OK: Code.EEROR);
        } catch (IOException e) {
            return  new Result(Code.EEROR,e.getMessage());
        }
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

