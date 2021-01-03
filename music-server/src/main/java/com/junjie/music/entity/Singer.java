package com.junjie.music.entity;


import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;

import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.junjie.music.enums.SexEnum;
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
public class Singer implements Serializable {

    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
      /**
     * 1男 0女
     */
      private int sex;
      @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
      private Date birth;

      /**
     * 地区
     */
      private String location;

      /**
     * 简介
     */
      private String introduction;
      /**
       * 照片路径
       * */
      private String pic;


}
