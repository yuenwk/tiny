package com.yuenwk.common.mybatis;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

public abstract class BaseServiceImpl<M extends BaseMapper<T>, T extends BaseDomain> extends ServiceImpl<M, T> implements IBaseService<T> {

    /**
     * 通过反射调用 getId()
     */
    private static final String INVOKE_ID = "getId";

    /**
     * 检查字段：ID
     */
    protected static final String ID = "id";

    @Override
    public boolean create(T domain) {
        return super.save(domain);
    }

    @Override
    public boolean remove(Long id) {
        if (checkId(id)) {
            return super.removeById(id);
        }
        return false;
    }

    @Override
    public boolean update(T domain) {
        try {
            if (checkId(Long.parseLong(String.valueOf(domain.getClass().getMethod(INVOKE_ID).invoke(domain))))) {
                return super.updateById(domain);
            }
            return false;
        } catch (Exception e) {
            log.error(e.getMessage());
//            throw new RuntimeException(ResultCode.FAILED);
            return false;
        }
    }

    @Override
    public T get(Long id) {
        T domain = super.getById(id);
//        if (null == domain) {
//            throw new AppException(ResultCode.RESULT_DATA_NONE);
//        }
        return domain;
    }

    /**
     * 检查 ID 是否存在
     *
     * @param id {@code Long} ID
     * @return {@code boolean} ID 不存在则抛出异常
     */
    @Override
    public boolean checkId(Long id) {
        QueryWrapper<T> wrapper = Wrappers.query();
        wrapper.select(ID).eq(ID, id);
        return super.count(wrapper) > 0;
    }

    @Override
    public boolean checkUnique(String column, Object value) {
        QueryWrapper<T> wrapper = Wrappers.query();
        wrapper.select(column).eq(column, value);
        return super.count(wrapper) == 1;
    }

}
