package com.yuenwk.tiny.controller;

import com.yuenwk.common.mybatis.BaseController;
import com.yuenwk.tiny.entity.SmResource;
import com.yuenwk.tiny.service.ISmResourceService;
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
@RequestMapping("/sm/resource")
public class SmResourceController extends BaseController<SmResource, ISmResourceService> {

}
