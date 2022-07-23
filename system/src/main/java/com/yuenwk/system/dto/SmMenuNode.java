package com.yuenwk.system.dto;

import com.yuenwk.system.entity.SmMenu;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

@Getter
@Setter
@Accessors(chain = true)
public class SmMenuNode extends SmMenu implements NodeDTO<SmMenuNode> {

    private List<SmMenuNode> children;

}