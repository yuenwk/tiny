package com.yuenwk.system.controller;

import com.yuenwk.common.mybatis.BaseController;
import com.yuenwk.system.entity.SmRole;
import com.yuenwk.system.service.ISmRoleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yuenwk
 * @since 2022-07-03
 */
@RestController
@RequestMapping("/sm/role")
public class SmRoleController extends BaseController<SmRole, ISmRoleService> {

}
