package com.yuenwk.system.service.impl;

import com.yuenwk.common.mybatis.BaseServiceImpl;
import com.yuenwk.system.converter.MenuConverter;
import com.yuenwk.system.dto.SmMenuNode;
import com.yuenwk.system.entity.SmMenu;
import com.yuenwk.system.mapper.SmMenuMapper;
import com.yuenwk.system.service.ISmMenuService;
import com.yuenwk.system.util.NodeUtil;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

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

        return getSmMenuNodeNodeUtil().getChildrenNode(smMenuNodes, 0L);
    }

    @NotNull
    private static NodeUtil<SmMenuNode> getSmMenuNodeNodeUtil() {
        return new NodeUtil<SmMenuNode>();
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



}
