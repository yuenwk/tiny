package com.yuenwk.system.converter;

import com.yuenwk.system.dto.SmMenuNode;
import com.yuenwk.system.entity.SmMenu;

import java.util.List;
import java.util.stream.Collectors;

public class MenuConverter {

    public static List<SmMenuNode> toMenuNodes(List<SmMenu> menus) {
        return menus.stream().map(MenuConverter::toMenuNode).collect(Collectors.toList());
    }

    public static SmMenuNode toMenuNode(SmMenu menu) {
        SmMenuNode smMenuNode = new SmMenuNode();
        smMenuNode.setId(menu.getId());
        smMenuNode.setParentId(menu.getParentId());
        smMenuNode.setPath(menu.getPath());
        smMenuNode.setLevel(menu.getLevel());
        smMenuNode.setSort(menu.getSort());
        smMenuNode.setName(menu.getName());
        smMenuNode.setIcon(menu.getIcon());
        smMenuNode.setHidden(menu.getHidden());
        smMenuNode.setCreateTime(menu.getCreateTime());
        return smMenuNode;
    }

}
