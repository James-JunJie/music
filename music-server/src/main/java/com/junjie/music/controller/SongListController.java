package com.junjie.music.controller;


 

import com.junjie.music.entity.Singer;
import com.junjie.music.entity.Song;
import com.junjie.music.entity.SongList;
import com.junjie.music.result.Code;
import com.junjie.music.result.Result;
import com.junjie.music.service.SongListService;
import com.junjie.music.utils.FastDFSUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.List;

/**
 * <p>
 * 歌单 前端控制器
 * </p>
 *
 * @author junjie
 * @since 2020-12-27
 */
@RestController
@RequestMapping("/songList")
public class SongListController {
    @Autowired
    SongListService songListService;

    /**
     * 添加
     * @param songList
     * @return
     */
    @RequestMapping("/add")
    public Result add(SongList songList){
        boolean flag = songListService.save(songList);
        return new Result(flag ? Code.OK: Code.EEROR,flag ? "添加成功":"添加失败");
    }
    /**
     * 查询所有
     * @return
     */
    @RequestMapping("/allSongList")
    public List<SongList> allSongList(){
        return songListService.findAll();
    }

    /**
     * 更新图片
     * @param file
     * @param id
     * @return
     */
    @RequestMapping(value = "/updateSongListPic", method = RequestMethod.POST)
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
        SongList songList = songListService.getById(id);
        String songListUrl = songList.getPic();
        //2.1 如果有url,则需要删除fastDFS中的数据，以免成为野文件
        if(songListUrl!= null||!"".equals(songListUrl)){
            String groupNameOld = songListUrl.substring(1,songListUrl.indexOf("M")-1);
            String remoteFilePathOld = songListUrl.substring(songListUrl.indexOf("M"));
            FastDFSUtil.delete(groupNameOld,remoteFilePathOld);
        }
        songList.setId(id);
        songList.setPic(url);
        boolean flag = songListService.update(songList);
        return new Result(flag ? Code.OK: Code.EEROR);
    }

    /**
     * 删除歌单的歌曲
     * @param songId
     * @param songListId
     * @return
     */
    @RequestMapping("/deleteSong")
    public Result delete(int songId,int songListId){
        boolean flag = songListService.deleteSong(songId,songListId);
        return new Result(flag ? Code.OK: Code.EEROR,flag ? "删除成功":"删除失败");
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping("/delete")
    public Result delete(int id){
        boolean flag = songListService.delete(id);
        return new Result(flag ? Code.OK: Code.EEROR,flag ? "删除成功":"删除失败");
    }
    /**
     * 更新
     * @param songList
     * @return
     */
    @RequestMapping("/update")
    public Result update(SongList songList){
        boolean flag = songListService.update(songList);
        return new Result(flag ? Code.OK: Code.EEROR);
    }
    /**
     * 根据歌单id查询歌曲列表
    * */
    @RequestMapping("/songOfSongListId")
    public  List<Song> songListId( int songListId){
        List<Song> songList = songListService.getBySongListId(songListId);
        return songList;
    }
    /**
     * 返回标题包含文字的歌单列表
     */
    @RequestMapping("/likeTitle")
    public List<SongList> songListsName(SongList songList){
        List<SongList> SongList = songListService.getByTile(songList);
        return  SongList;
    }
    /**
     * 根据歌单style风格查询
     * */
    @RequestMapping("/likeStyle")
    public List<SongList> getByStyle(String style ){
        List<SongList> listStyle = songListService.getByStyle(style);
        return  listStyle;
    }

}

