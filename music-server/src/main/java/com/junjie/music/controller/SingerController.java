package com.junjie.music.controller;


import com.junjie.music.entity.Singer;
import com.junjie.music.entity.Song;
import com.junjie.music.result.Code;
import com.junjie.music.result.Result;
import com.junjie.music.service.SingerService;
import com.junjie.music.utils.FastDFSUtil;
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
        public Result updataPic(@RequestParam("file") MultipartFile file,int id) throws IOException {
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
        Singer singer  = singerService.getById(id);
        String singerUrl = singer.getPic();
        //2.1 如果有url,则需要删除fastDFS中的数据，以免成为野文件
        if(singerUrl!= null||!"".equals(singerUrl)){
            String groupNameOld = singerUrl.substring(1,singerUrl.indexOf("M")-1);
            String remoteFilePathOld = singerUrl.substring(singerUrl.indexOf("M"));
            FastDFSUtil.delete(groupNameOld,remoteFilePathOld);
        }
        singer.setId(id);
        singer.setPic(url);
        boolean flag = singerService.update(singer);
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

