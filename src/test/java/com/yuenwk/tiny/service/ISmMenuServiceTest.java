package com.yuenwk.tiny.service;

import com.yuenwk.tiny.TinyApplicationTests;
import com.yuenwk.tiny.entity.SmMenu;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;

class ISmMenuServiceTest extends TinyApplicationTests {

    @Resource
    ISmMenuService smMenuService;

    @Test
    void save() {
        smMenuService.save(new SmMenu().setName("仪表盘").setTitle("menu"));
    }

    @Test
    void update() {

    }

    @Test
    void treeList() {

    }
}