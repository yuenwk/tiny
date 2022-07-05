package com.yuenwk.tiny.controller;

import com.yuenwk.common.mybatis.BaseController;
import com.yuenwk.tiny.entity.SmResourceCategory;
import com.yuenwk.tiny.service.ISmResourceCategoryService;
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
@RequestMapping("/sm/resource-category")
public class SmResourceCategoryController extends BaseController<SmResourceCategory, ISmResourceCategoryService> {

}
