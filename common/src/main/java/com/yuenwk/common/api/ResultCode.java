package com.yuenwk.common.api;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ResultCode implements IErrorCode {

    SUCCESS(200, "操作成功"),

    FAILED(500, "操作失败"),

    VALIDATE_FAILED(404, "参数检验失败"),

    UNAUTHORIZED(401, "暂未登录或token已经过期"),

    FORBIDDEN(403, "没有相关权限"),

    RESULT_DATA_NONE(50404, "相关数据不存在"),

    ;

    private final long code;

    private final String message;

}
