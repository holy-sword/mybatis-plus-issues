package com.lzx.entity.core;

/**
 * 主键ID
 *
 * @author : lzx
 * created on 2019/1/9
 */
public interface IDEntity<D> {

    D getId();

    void setId(D id);
}
