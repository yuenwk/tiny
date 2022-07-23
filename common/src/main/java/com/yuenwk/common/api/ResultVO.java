package com.yuenwk.common.api;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Getter
@Setter
@Accessors(chain = true)
@Builder
public class ResultVO<T> implements Serializable {

    private Long code;

    private String message;

    private T data;

    public static <T> ResultVO<T> success(T data) {
        return ResultVO.<T>builder().code(200L).data(data).build();
    }

    public static <T> ResultVO<T> failed(String message) {
        return ResultVO.<T>builder().code(500L).message(message).build();
    }

}
