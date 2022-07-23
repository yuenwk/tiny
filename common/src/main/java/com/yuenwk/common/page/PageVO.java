package com.yuenwk.common.page;

import com.github.pagehelper.PageInfo;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PageVO<T> {

    /**
     * 总记录数
     */
    private Long total;

    /**
     * 结果集
     */
    private List<T> records;

    public PageVO(PageInfo<T> page) {
        this.total = page.getTotal();
        this.records = page.getList();
    }

}
