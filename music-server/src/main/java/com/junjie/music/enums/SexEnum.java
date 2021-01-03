package com.junjie.music.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;

/**
 * @Description:TODO
 * @author:LiJunJie
 * @Date 2020/12/28
 */
public enum SexEnum {
    WORK(1,"男"),
    REST(0,"女");

    SexEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @EnumValue
    private Integer code;
    private String msg;
}