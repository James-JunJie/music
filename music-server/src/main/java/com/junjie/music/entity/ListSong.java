package com.junjie.music.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 歌单包含歌曲列表
 * </p>
 *
 * @author junjie
 * @since 2020-12-27
 */
@Data
  @EqualsAndHashCode(callSuper = false)
  @Accessors(chain = true)
public class ListSong implements Serializable {

    private static final long serialVersionUID=1L;

     @TableId(type = IdType.AUTO)
      private Integer id;

      /**
     * 歌曲id
     */
      private Integer songId;

      /**
     * 歌单id
     */
      private Integer songListId;


}
