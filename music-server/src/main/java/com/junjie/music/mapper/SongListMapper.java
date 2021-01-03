package com.junjie.music.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.junjie.music.entity.Song;
import com.junjie.music.entity.SongList;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 歌单 Mapper 接口
 * </p>
 *
 * @author junjie
 * @since 2020-12-27
 */
public interface SongListMapper extends BaseMapper<SongList> {

    @Select("select *  from song where id IN (select  song_id from list_song where song_list_id = #{id})")
    List<Song> songBySongListId(Integer id);

    @Delete("DELETE FROM list_song WHERE (song_id = #{songId} AND song_list_id = #{songListId})")
    boolean deleteBySong(int songId, int songListId);
    @Select("SELECT id FROM song_list WHERE title LIKE '%${title}%'")
    List<SongList> selectByTitle(String title);
}
