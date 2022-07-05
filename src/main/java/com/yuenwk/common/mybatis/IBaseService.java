package com.yuenwk.common.mybatis;

import com.baomidou.mybatisplus.extension.service.IService;

public interface IBaseService<T extends BaseDomain> extends IService<T> {

    /**
     * 新增
     */
    boolean create(T domain);

    /**
     * 删除
     */
    boolean remove(Long id);

    /**
     * 更新
     */
    boolean update(T domain);

    /**
     * 获取
     */
    T get(Long id);

    boolean checkId(Long id);

    boolean checkUnique(String column, Object value);

}
