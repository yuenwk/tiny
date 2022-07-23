package com.yuenwk.system.service.impl;

import com.yuenwk.common.mybatis.BaseServiceImpl;
import com.yuenwk.system.converter.RoleConverter;
import com.yuenwk.system.dto.SmRoleNode;
import com.yuenwk.system.entity.SmRole;
import com.yuenwk.system.mapper.SmRoleMapper;
import com.yuenwk.system.service.ISmRoleService;
import com.yuenwk.system.util.NodeUtil;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author yuenwk
 * @since 2022-07-03
 */
@Service
public class SmRoleServiceImpl extends BaseServiceImpl<SmRoleMapper, SmRole> implements ISmRoleService {

    @Override
    public List<SmRoleNode> treeList() {
        List<SmRoleNode> smMenuNodes = RoleConverter.toRoleNodes(list());

        return getNodeNodeUtil().getChildrenNode(smMenuNodes, 0L);
    }

    @NotNull
    private static NodeUtil<SmRoleNode> getNodeNodeUtil() {
        return new NodeUtil<>();
    }

}
