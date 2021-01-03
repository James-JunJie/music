package com.junjie.music.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 歌单
 * </p>
 *
 * @author junjie
 * @since 2020-12-27
 */
@Data
  @EqualsAndHashCode(callSuper = false)
  @Accessors(chain = true)
public class SongList implements Serializable {

     private static final long serialVersionUID=1L;
     @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

      /**
     * 标题
     */
      private String title;

      /**
     * 图片
     */
      private String pic;

      /**
     * 简介
     */
      private String introduction;

      /**
     * 风格
     */
      private String style;


}
