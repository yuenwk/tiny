package com.yuenwk.tiny.dto;

import com.yuenwk.tiny.entity.SmMenu;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

@Getter
@Setter
@Accessors(chain = true)
public class SmMenuNode extends SmMenu {

    private List<SmMenuNode> children;

}