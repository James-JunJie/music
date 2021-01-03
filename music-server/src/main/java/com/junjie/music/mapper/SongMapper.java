package com.junjie.music.mapper;

import com.junjie.music.entity.Song;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author junjie
 * @since 2020-12-27
 */
public interface SongMapper extends BaseMapper<Song> {
    @Select("SELECT * FROM song where singer_id In (SELECT id FROM `singer` WHERE name LIKE '%${singerName}%' )")
    List<Song> selectBySingerName(String singerName);
}
