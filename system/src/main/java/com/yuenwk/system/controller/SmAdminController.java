package com.yuenwk.system.controller;

import com.yuenwk.common.api.ResultVO;
import com.yuenwk.common.mybatis.BaseController;
import com.yuenwk.common.page.PageParam;
import com.yuenwk.common.page.PageVO;
import com.yuenwk.system.entity.SmAdmin;
import com.yuenwk.system.service.ISmAdminService;
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
@RequestMapping("/sm/admin")
public class SmAdminController extends BaseController<SmAdmin, ISmAdminService> {

    @GetMapping
    public ResultVO<PageVO<SmAdmin>> list(PageParam<SmAdmin> param) {
        return ResultVO.success(param.page(() -> service.list()));
    }

}
