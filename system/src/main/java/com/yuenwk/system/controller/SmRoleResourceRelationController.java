package com.yuenwk.system.controller;

import com.yuenwk.common.mybatis.BaseController;
import com.yuenwk.system.entity.SmRoleResourceRelation;
import com.yuenwk.system.service.ISmRoleResourceRelationService;
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
@RequestMapping("/sm/role-resource-relation")
public class SmRoleResourceRelationController extends BaseController<SmRoleResourceRelation, ISmRoleResourceRelationService> {

}
