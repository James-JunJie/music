package com.junjie.music.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 收藏
 * </p>
 *
 * @author junjie
 * @since 2020-12-27
 */
@Data
  @EqualsAndHashCode(callSuper = false)
  @Accessors(chain = true)
public class Collect implements Serializable {

    private static final long serialVersionUID=1L;
      @TableId(type = IdType.AUTO)
      private Integer id;

      /**
     * 用户id
     */
      private Integer userId;

      /**
     * 收藏类型   (0歌曲 1歌单）
     */
      private Boolean type;

      /**
     * 歌曲id
     */
      private Integer songId;

      /**
     * 收藏歌单
     */
      private Integer songListId;

      /**
     * 收藏时间
     */
      @TableField(fill = FieldFill.INSERT)
      private Date createTime;


}
