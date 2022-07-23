package com.yuenwk.system.service;

import com.yuenwk.common.mybatis.IBaseService;
import com.yuenwk.system.dto.SmMenuNode;
import com.yuenwk.system.entity.SmMenu;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author yuenwk
 * @since 2022-07-03
 */
public interface ISmMenuService extends IBaseService<SmMenu> {

    List<SmMenuNode> treeList();

}
