package com.yuenwk.system.util;

import cn.hutool.core.util.NumberUtil;
import com.yuenwk.system.dto.NodeDTO;

import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

import static java.util.stream.Collectors.toList;

public class NodeUtil<T extends NodeDTO<T>> {

    /**
     * 递归获取
     */
    public List<T> getChildrenNode(List<T> nodes, Long parentId) {
        List<T> emptyList = Collections.emptyList();
        if (nodes.isEmpty()) { // 空则跳出递归
            return emptyList;
        }
        // 根节点
        boolean isRoot = NumberUtil.equals(parentId, 0);
        Predicate<T> isCurrent = m -> isRoot ? NumberUtil.equals(m.getParentId(), 0) : NumberUtil.equals(m.getParentId(), parentId);

        List<T> currentNodes = nodes.stream().filter(isCurrent).collect(toList());
        if (currentNodes.isEmpty()) { // 空则跳出递归
            return emptyList;
        }

        List<T> otherNodes = nodes.stream().filter(isCurrent.negate()).collect(toList());

        currentNodes.forEach(cm -> {
            List<T> cMenus = getChildrenNode(otherNodes, cm.getParentId());
            if (!cMenus.equals(emptyList)) {
                cm.setChildren(cMenus);
            }
        });

        return currentNodes;
    }


}
