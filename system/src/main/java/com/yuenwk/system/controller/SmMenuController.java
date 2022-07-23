package com.yuenwk.system.controller;

import com.yuenwk.common.api.ResultVO;
import com.yuenwk.common.mybatis.BaseController;
import com.yuenwk.common.page.PageParam;
import com.yuenwk.common.page.PageVO;
import com.yuenwk.system.entity.SmMenu;
import com.yuenwk.system.service.ISmMenuService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author yuenwk
 * @since 2022-07-03
 */
@RestController
@RequestMapping("/sm/menu")
public class SmMenuController extends BaseController<SmMenu, ISmMenuService> {

    @GetMapping
    public ResultVO<PageVO<SmMenu>> list(PageParam<SmMenu> param) {
        return ResultVO.success(param.page(() -> service.list()));
    }

}
