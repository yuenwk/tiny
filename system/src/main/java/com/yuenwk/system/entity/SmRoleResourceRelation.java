package com.yuenwk.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.yuenwk.common.mybatis.BaseDomain;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author yuenwk
 * @since 2022-07-03
 */
@Getter
@Setter
@TableName("sm_role_resource_relation")
public class SmRoleResourceRelation extends BaseDomain implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private Long roleId;

    private Long resourceId;
}
