package com.yuenwk.system.converter;

import com.yuenwk.system.dto.SmRoleNode;
import com.yuenwk.system.entity.SmRole;

import java.util.List;
import java.util.stream.Collectors;

public class RoleConverter {

    public static List<SmRoleNode> toRoleNodes(List<SmRole> roles) {
        return roles.stream().map(RoleConverter::toRoleNode).collect(Collectors.toList());
    }

    public static SmRoleNode toRoleNode(SmRole role) {
        SmRoleNode smRoleNode = new SmRoleNode();
        smRoleNode.setId(role.getId());
        smRoleNode.setParentId(role.getParentId());
        smRoleNode.setName(role.getName());
        smRoleNode.setDescription(role.getDescription());
        smRoleNode.setStatus(role.getStatus());
        smRoleNode.setSort(role.getSort());
        smRoleNode.setCreateTime(role.getCreateTime());
        return smRoleNode;
    }

}
