package com.yuenwk.tiny.service.impl;

import cn.hutool.core.util.NumberUtil;
import com.yuenwk.common.mybatis.BaseServiceImpl;
import com.yuenwk.tiny.converter.MenuConverter;
import com.yuenwk.tiny.dto.SmMenuNode;
import com.yuenwk.tiny.entity.SmMenu;
import com.yuenwk.tiny.mapper.SmMenuMapper;
import com.yuenwk.tiny.service.ISmMenuService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;

import static java.util.stream.Collectors.toList;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author yuenwk
 * @since 2022-07-03
 */
@Service
public class SmMenuServiceImpl extends BaseServiceImpl<SmMenuMapper, SmMenu> implements ISmMenuService {

    @Override
    public boolean save(SmMenu entity) {
        setLevel.accept(entity);
        return super.save(entity);
    }

    @Override
    public boolean update(SmMenu entity) {
        setLevel.accept(entity);
        return super.update(entity);
    }

    @Override
    public List<SmMenuNode> treeList() {
        List<SmMenuNode> smMenuNodes = MenuConverter.toMenuNodes(list());

        return getChildrenMenuNode(smMenuNodes, 0L);
    }

    /**
     * 设置菜单层级
     */
    Consumer<SmMenu> setLevel = (menu) -> {
        Long pid = Optional.ofNullable(menu.getParentId()).orElse(0L);
        if (pid == 0) {
            menu.setLevel(0);
            return;
        }
        Integer level = Optional.ofNullable(get(pid)).map(SmMenu::getLevel).orElse(0);
        menu.setLevel(level > 0 ? level + 1 : 0);
    };


    /**
     * 递归获取
     */
    private List<SmMenuNode> getChildrenMenuNode(List<SmMenuNode> menus, Long parentId) {
        List<SmMenuNode> emptyList = Collections.emptyList();
        if (menus.isEmpty()) { // 空则跳出递归
            return emptyList;
        }
        // 根节点
        boolean isRoot = NumberUtil.equals(parentId, 0);
        Predicate<SmMenuNode> isCurrent = m -> isRoot ? NumberUtil.equals(m.getParentId(), 0) : NumberUtil.equals(m.getParentId(), parentId);

        List<SmMenuNode> currentMenus = menus.stream().filter(isCurrent).collect(toList());
        if (currentMenus.isEmpty()) { // 空则跳出递归
            return emptyList;
        }

        List<SmMenuNode> otherMenus = menus.stream().filter(isCurrent.negate()).collect(toList());

        currentMenus.forEach(cm -> {
            List<SmMenuNode> cMenus = getChildrenMenuNode(otherMenus, cm.getParentId());
            if (!cMenus.equals(emptyList)) {
                cm.setChildren(cMenus);
            }
        });

        return currentMenus;
    }

}
