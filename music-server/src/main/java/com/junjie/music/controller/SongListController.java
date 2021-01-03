package com.junjie.music.controller;


 

import com.junjie.music.entity.Song;
import com.junjie.music.entity.SongList;
import com.junjie.music.result.Code;
import com.junjie.music.result.Result;
import com.junjie.music.service.SongListService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Result updataPic(@RequestParam("file") MultipartFile file, int id) throws FileNotFoundException {
        //首先判断是否是空文件，也就是存储空间占用为0的文件
        if(file.isEmpty()){
            return  new Result(Code.EEROR,"上传失败");
        }
        //文件名=当前时间到毫秒+原来的文件名
        String newFileName = System.currentTimeMillis()+file.getOriginalFilename();
        System.out.println("新文件名称:" + newFileName);
        //获取服务器发布路径
        String filePath = ResourceUtils.getURL("classpath:").getPath() + "static/img/songListPic";
        System.out.println(filePath);
        //如果文件路径不存在，新增该路径
        File file1 = new File(filePath);
        if(!file1.exists()){
            file1.mkdir();
        }
        //实际的文件地址
        File dest = new File(filePath+System.getProperty("file.separator")+newFileName);
        //存储到数据库里的相对文件地址
        String storeAvatorPath = "/img/songListPic/"+newFileName;
        try {
            file.transferTo(dest);
            SongList songList = new SongList();
            songList.setId(id);
            songList.setPic(storeAvatorPath);
            boolean flag = songListService.update(songList);
            return new Result(flag ? Code.OK: Code.EEROR);
        } catch (IOException e) {
            return  new Result(Code.EEROR,e.getMessage());
        }
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

