package com.junjie.music.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户
 * </p>
 *
 * @author junjie
 * @since 2020-12-27
 */
@Data
  @EqualsAndHashCode(callSuper = false)
  @Accessors(chain = true)
public class Consumer implements Serializable {

    private static final long serialVersionUID=1L;

      /**
     * 主键
     */
        @TableId(value = "id", type = IdType.AUTO)
      private Integer id;
    /**
     * 性别 1男 0女
     */
    private String username;

    private String password;

      /**
     * 性别 1男 0女
     */
      private int sex;

      /**
     * 电话
     */
      private String phoneNum;

    private String email;

      /**
     * 生日
     */
      private Date birth;

      /**
     * 签名
     */
      private String introduction;

      /**
     * 地址
     */
      private String location;

      /**
     * 头像
     */
      private String avator;

      /**
     * 创建时间
     */
      @TableField(fill = FieldFill.INSERT)
      private Date createTime;
    @TableField(fill = FieldFill.UPDATE)
    private Date updateTime;


}
