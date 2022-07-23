package com.yuenwk.system.dto;

import java.util.List;


public interface NodeDTO<T> {

    void setChildren(List<T> tList);

    Long getParentId();

}
