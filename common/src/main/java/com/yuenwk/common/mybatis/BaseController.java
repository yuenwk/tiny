package com.yuenwk.common.mybatis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("all")
@Slf4j
public abstract class BaseController<T extends BaseDomain, S extends IBaseService<T>> {

    @Resource
    protected HttpServletRequest request;
    @Resource
    protected HttpServletResponse response;

    @Autowired
    protected S service;

}
