package com.yuenwk.tiny.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.yuenwk.common.api.ResultVO;
import com.yuenwk.common.page.PageParam;
import com.yuenwk.common.page.PageVO;
import com.yuenwk.tiny.entity.SmAdmin;
import com.yuenwk.tiny.service.ISmAdminService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author yuenwk
 * @since 2022-07-03
 */
@RestController
@RequestMapping("/sm/admin")
public class SmAdminController {

    @Resource
    private ISmAdminService adminService;

    @GetMapping
    public ResultVO<PageVO<SmAdmin>> list(PageParam<SmAdmin> param) {
        return ResultVO.success(param.page(() -> adminService.list()));
    }

    @GetMapping("/get")
    public SmAdmin get() {
        LambdaQueryWrapper<SmAdmin> queryWrapper = Wrappers.lambdaQuery();
        return adminService.getOne(queryWrapper);
    }

}
