package com.yuenwk.system.dto;

import com.yuenwk.system.entity.SmRole;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

@Getter
@Setter
@Accessors(chain = true)
public class SmRoleNode extends SmRole implements NodeDTO<SmRoleNode> {

    private List<SmRoleNode> children;

}