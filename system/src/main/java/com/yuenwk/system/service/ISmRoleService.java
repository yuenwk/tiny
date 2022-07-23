package com.yuenwk.system.service;

import com.yuenwk.common.mybatis.IBaseService;
import com.yuenwk.system.dto.SmRoleNode;
import com.yuenwk.system.entity.SmRole;

import java.util.List;

/**
 * 角色接口
 *
 * @author yuenwk
 * @since 2022-07-03
 */
public interface ISmRoleService extends IBaseService<SmRole> {

    List<SmRoleNode> treeList();

}
