package com.junjie.music.controller;

 
import com.junjie.music.entity.Song;
import com.junjie.music.result.Code;
import com.junjie.music.result.Result;
import com.junjie.music.service.SongService;
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
 *  前端控制器
 * </p>
 *
 * @author junjie
 * @since 2020-12-27
 */
@RestController
@RequestMapping("/song")
public class SongController {

    @Autowired
    SongService songService;

    /**
     * 添加
     * @param song
     * @return
     */
    @RequestMapping("/add")
    public Result add(Song song,@RequestParam("file")MultipartFile file) throws FileNotFoundException {
        System.out.println("歌曲"+song);
        //首先判断是否是空文件，也就是存储空间占用为0的文件
        if(file.isEmpty()){
            return  new Result(Code.EEROR,"上传失败");
        }
        //文件名=当前时间到毫秒+原来的文件名
        String fileName = System.currentTimeMillis()+file.getOriginalFilename();
        //文件路径
        String filePath = ResourceUtils.getURL("classpath:").getPath() + "static/song";
        //如果文件路径不存在，新增该路径
        File file1 = new File(filePath);
        if(!file1.exists()){
            file1.mkdir();
        }
        //实际的文件地址
        File dest = new File(filePath+System.getProperty("file.separator")+fileName);
        //存储到数据库里的相对文件地址
        String storeAvatorPath = "/song/"+fileName;
        try {
            file.transferTo(dest);
            song.setUrl(storeAvatorPath);
            boolean flag = songService.save(song);
            return new Result(flag ? Code.OK: Code.EEROR);
        } catch (IOException e) {
            return  new Result(Code.EEROR,e.getMessage());
        }
    }


    /**
     * 查询所有
     * @return
     */
    @RequestMapping("/allSong")
    public List<Song> allSong(){
        return songService.findAll();
    }

    /**
     * 更新图片
     * @param file
     * @param id
     * @return
     */
    @RequestMapping(value = "/updateSongPic", method = RequestMethod.POST)
    public Result updataPic(@RequestParam("file") MultipartFile file, int id) throws FileNotFoundException {
        //首先判断是否是空文件，也就是存储空间占用为0的文件
        if(file.isEmpty()){
            return  new Result(Code.EEROR,"上传失败");
        }
        //文件名=当前时间到毫秒+原来的文件名
        String fileName = System.currentTimeMillis()+file.getOriginalFilename();
        //文件路径
        String filePath = ResourceUtils.getURL("classpath:").getPath() + "static/img/songPic";
        //如果文件路径不存在，新增该路径
        File file1 = new File(filePath);
        if(!file1.exists()){
            file1.mkdir();
        }
        //实际的文件地址
        File dest = new File(filePath+System.getProperty("file.separator")+fileName);
        //存储到数据库里的相对文件地址
        String storeAvatorPath = "/img/songPic/"+fileName;
        try {
            file.transferTo(dest);
            Song song = new Song();
            song.setId(id);
            song.setPic(storeAvatorPath);
            boolean flag = songService.update(song);
            return new Result(flag ? Code.OK: Code.EEROR);
        } catch (IOException e) {
            return  new Result(Code.EEROR,e.getMessage());
        }
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping("/delete")
    public Result delete(int id){
        System.out.println("delete:  "+id);
        boolean flag = songService.delete(id);
        return new Result(flag ? Code.OK: Code.EEROR,flag ? "删除成功":"删除失败");
    }
    /**
     * 更新
     * @param song
     * @return
     */
    @RequestMapping("/update")
    public Result update(Song song){
        boolean flag = songService.update(song);
        return new Result(flag ? Code.OK: Code.EEROR);
    }
    /**
     * 根据歌手id 查询歌曲id
     * */
    @RequestMapping("/singerId")
    public List<Song> singerId(int singerId){
        return songService.getBySingerId(singerId);
    }

    /**
     * 根据歌曲名获取歌曲id
     * */
    @RequestMapping("/songOfSongName")
    public List<Song> getSongName(String songName ){
        List<Song> songList = songService.getByName(songName);
        return  songList;
    }
    /**
     * 根据歌手名获取歌曲
     * */
    @RequestMapping("/likeSongOfName")
    public List<Song> getSingerName(String singerName ){
        List<Song> songList = songService.getBySingerName(singerName);
        return  songList;
    }
    /**
     * 根据歌曲id获取 歌曲
     * songOfSongId =(id) => get(`song/detail?songId=${id}`);
     * */
    @RequestMapping("/detail")
    public Song getById(int songId ){
        Song song = songService.get(songId);
        return  song;
    }

}

