package com.junjie.music.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author junjie
 * @since 2020-12-27
 */
@Data
  @EqualsAndHashCode(callSuper = false)
  @Accessors(chain = true)
public class Ranks implements Serializable {

      private static final long serialVersionUID=1L;
      @TableId(type = IdType.AUTO)
      private Integer id;

      /**
     * 歌单id
     */
      private Integer songListId;

      /**
     * 用户id
     */
      private Integer consumerId;

      /**
     * 评分
     */
      private Integer score;


}
