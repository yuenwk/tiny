package com.yuenwk.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.yuenwk.common.mybatis.BaseServiceImpl;
import com.yuenwk.system.mapper.SmAdminMapper;
import com.yuenwk.system.entity.SmAdmin;
import com.yuenwk.system.service.ISmAdminService;
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
