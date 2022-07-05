package com.yuenwk.tiny.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.yuenwk.common.mybatis.BaseServiceImpl;
import com.yuenwk.tiny.entity.SmAdmin;
import com.yuenwk.tiny.mapper.SmAdminMapper;
import com.yuenwk.tiny.service.ISmAdminService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author yuenwk
 * @since 2022-07-03
 */
@Service
public class SmAdminServiceImpl extends BaseServiceImpl<SmAdminMapper, SmAdmin> implements ISmAdminService {

    @Override
    public SmAdmin getByUsername(String username) {
        LambdaQueryWrapper<SmAdmin> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.eq(SmAdmin::getUsername, username);
        return baseMapper.selectOne(queryWrapper);
    }

}
