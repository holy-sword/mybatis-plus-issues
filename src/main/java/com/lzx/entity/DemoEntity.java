package com.lzx.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.lzx.entity.core.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Map;

/**
 * @author : lzx
 * created on 2019/4/19
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("sys_xxx")
public class DemoEntity extends BaseEntity {

    @TableField("a_a")
    private String a;
    @TableField("b_b_b")
    private String b;
    private String c;
    @TableField(value = "d", el = "d,typeHandler=com.lzx.dao.core.type.JsonTypeHandler")
    private Location d;
    @TableField(value = "e", el = "e,typeHandler=com.lzx.dao.core.type.JsonTypeHandler")
    //@TableField(value = "e", el = "e,typeHandler=com.lzx.dao.core.type.JsonTypeHandler",typeHandler = JsonTypeHandler.class)
    private Map<String, Object> e;
    @TableField("is_frozen")
    private Boolean frozen;

    @Data
    public static class Location {

        private Integer x;
        private Integer y;

    }
}
