package com.yuenwk.tiny.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.yuenwk.common.mybatis.BaseDomain;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

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
@TableName("sm_menu")
public class SmMenu extends BaseDomain implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private Long parentId;

    private String title;

    private Short level;

    private Short sort;

    private String name;

    private String icon;

    private Short hidden;

    private LocalDateTime createTime;
}
