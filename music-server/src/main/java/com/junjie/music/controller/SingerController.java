package com.junjie.music.controller;


import com.junjie.music.entity.Singer;
import com.junjie.music.entity.Song;
import com.junjie.music.result.Code;
import com.junjie.music.result.Result;
import com.junjie.music.service.SingerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author junjie
 * @since 2020-12-27
 */
@RestController
@RequestMapping("/singer")
public class SingerController {

    @Autowired
    SingerService singerService;

    /**
     * 添加
     * @param singer
     * @return
     */
    @RequestMapping("/add")
    public Result add(Singer singer){
        boolean flag = singerService.save(singer);
        return new Result(flag ? Code.OK: Code.EEROR);
    }

    /**
     * 查询所有歌手
     * @return
     */
    @RequestMapping("/allSinger")
    public List<Singer> allSinger(){
       return singerService.findAll();
    }

    /**
     * 更新图片
     * @param file
     * @param id
     * @return
     */
    @RequestMapping(value = "/updateSingerPic", method = RequestMethod.POST)
        public Result updataPic(@RequestParam("file") MultipartFile file,int id) throws FileNotFoundException {
        //首先判断是否是空文件，也就是存储空间占用为0的文件
        if(file.isEmpty()){
           return  new Result(Code.EEROR,"上传失败");
        }
        //文件名=当前时间到毫秒+原来的文件名
        String fileName = System.currentTimeMillis()+file.getOriginalFilename();
        //文件路径
        String filePath = ResourceUtils.getURL("classpath:").getPath() + "static/img/singerPic";
        //如果文件路径不存在，新增该路径
        File file1 = new File(filePath);
        if(!file1.exists()){
            file1.mkdir();
        }
        //实际的文件地址
        File dest = new File(filePath+System.getProperty("file.separator")+fileName);
        //存储到数据库里的相对文件地址
        String storeAvatorPath = "/img/singerPic/"+fileName;
        try {
            file.transferTo(dest);
            Singer singer = new Singer();
            singer.setId(id);
            singer.setPic(storeAvatorPath);
            boolean flag = singerService.update(singer);
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
        boolean flag = singerService.delete(id);
        return new Result(flag ? Code.OK: Code.EEROR,flag ? "删除成功":"删除失败");
    }
    /**
     * 更新
     * @param singer
     * @return
     */
    @RequestMapping("/update")
    public Result update(Singer singer){
        boolean flag = singerService.update(singer);
        return new Result(flag ? Code.OK: Code.EEROR);
    }
    /**
     * 根据id 查询
     * */
    @RequestMapping("/singerId")
    public Singer singerId(int id){
        Singer singer = singerService.get(id);
        return singer;
    }
    /**
     * 根据sex 获取曲
     * */
    @RequestMapping("/singerOfSex")
    public List<Singer>getBySex(Singer singer){
        List<Singer> list = singerService.getBySex(singer);
        return  list;
    }
}

