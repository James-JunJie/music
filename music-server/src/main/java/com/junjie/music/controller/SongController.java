package com.junjie.music.controller;

 
import com.junjie.music.entity.Consumer;
import com.junjie.music.entity.Song;
import com.junjie.music.result.Code;
import com.junjie.music.result.Result;
import com.junjie.music.service.SongService;
import com.junjie.music.utils.FastDFSUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;

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
     * 添加歌曲
     * @param song
     * @return
     */
    @RequestMapping("/add")
    public Result add(Song song,@RequestParam("file")MultipartFile file) throws IOException {
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

        //2.加入url,添加song
        song.setUrl(url);
        boolean flag = songService.save(song);
        return new Result(flag ? Code.OK: Code.EEROR);
    }
    /**
     * 更新歌曲
     * */
    @RequestMapping("/updateSongUrl")
    public Result updateSong(int id,@RequestParam("file")MultipartFile file) throws IOException {
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
        Song song  = songService.getById(id);
        String songUrl = song.getUrl();
        //2.1 如果有url,则需要删除fastDFS中的数据，以免成为野文件
        if(songUrl!= null||!"".equals(songUrl)){
            String groupNameOld = songUrl.substring(1,songUrl.indexOf("M")-1);
            String remoteFilePathOld = songUrl.substring(songUrl.indexOf("M"));
            FastDFSUtil.delete(groupNameOld,remoteFilePathOld);
        }
        song.setId(id);
        song.setUrl(url);
        boolean flag = songService.update(song);
        return new Result(flag ? Code.OK: Code.EEROR);
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
        Song song  = songService.getById(id);
        String songUrl = song.getUrl();
        //2.1 如果有url,则需要删除fastDFS中的数据，以免成为野文件
        if(songUrl!= null||!"".equals(songUrl)){
            String groupNameOld = songUrl.substring(1,songUrl.indexOf("M")-1);
            String remoteFilePathOld = songUrl.substring(songUrl.indexOf("M"));
            FastDFSUtil.delete(groupNameOld,remoteFilePathOld);
        }

        song.setId(id);
        song.setPic(url);
        boolean flag = songService.update(song);
        return new Result(flag ? Code.OK: Code.EEROR);
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

    @RequestMapping("/downloadSong")
    public ResponseEntity<byte[]> download(int id){
        Song song= songService.getById(id);
        String url = song.getUrl();
        String groupName = url.substring(1,url.indexOf("M")-1);
        String remoteFilePath = url.substring(url.indexOf("M"));
        byte [] buffFile=FastDFSUtil.download(groupName,remoteFilePath);
        HttpHeaders headers=new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);//设置响应类型为文件类型
        //设置下载时的默认文件名
        headers.setContentDispositionFormData("attachment",song.getName());
        /**
         * 创建响应实体对象，Spring会将这个对象返回给浏览器，作为响应数据
         * 参数 1 为响应时的具体数据
         * 参数 2 为响应时的头文件信息
         * 参数 3 为响应时的状态码
         */
        ResponseEntity<byte[]> responseEntity=new ResponseEntity<byte[]>(buffFile,headers, HttpStatus.OK);
        return responseEntity;
    }

}

