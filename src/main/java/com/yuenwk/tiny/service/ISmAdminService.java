package com.yuenwk.tiny.service;

import com.yuenwk.common.mybatis.IBaseService;
import com.yuenwk.tiny.entity.SmAdmin;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author yuenwk
 * @since 2022-07-03
 */
public interface ISmAdminService extends IBaseService<SmAdmin> {

    SmAdmin getByUsername(String username);

}
