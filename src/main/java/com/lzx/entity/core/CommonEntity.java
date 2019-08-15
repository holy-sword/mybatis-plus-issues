package com.lzx.entity.core;

import java.io.Serializable;
import java.util.Date;

/**
 * @author : lzx
 * created on 2019/4/26
 */
public interface CommonEntity<D> extends CreateTimeEntity, UpdateTimeEntity, IDEntity<D>, Serializable {

    /**
     * 设置创建以及更新时间（若创建时间存在则不去设置）
     */
    default void setCreateAndUpdateTime() {
        Date now = new Date();
        if (this.getCreateTime() == null) {
            this.setCreateTime(now);
        }
        this.setUpdateTime(now);
    }

}
