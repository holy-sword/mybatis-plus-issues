package com.lzx.entity.core;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

/**
 * 基础实体
 *
 * @author : lzx
 * created on 2018/12/14 10:47
 */
@Data
public class BaseEntity implements CommonEntity<String> {

    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */
    @TableId(type = IdType.UUID)
    protected String id;
    /**
     * 创建时间
     */
    protected Date createTime;
    /**
     * 最近更新时间
     */
    protected Date updateTime;


}
