package com.lzx.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lzx.entity.DemoEntity;

import java.util.List;

/**
 * @author : lzx
 * created on 2019/6/19
 */
public interface DemoEntityMapper extends BaseMapper<DemoEntity> {

    List<DemoEntity> getAllList();
}
