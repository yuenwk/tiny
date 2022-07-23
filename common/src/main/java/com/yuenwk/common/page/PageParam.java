package com.yuenwk.common.page;

import com.github.pagehelper.ISelect;
import com.github.pagehelper.PageHelper;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Getter
@Setter
@Accessors(chain = true)
public class PageParam<T> implements Serializable {

    private Integer size = 15;

    private Integer current = 1;

    public PageVO<T> page(ISelect select) {
        isZero();

        return new PageVO<>(PageHelper.startPage(current, size, Boolean.TRUE, null, false).doSelectPageInfo(select));
    }

    /**
     * 当页码为0
     */
    private void isZero() {
        if (current == 0) {
            current = 1;
            size = Integer.MAX_VALUE;
        }
    }

}