package com.lou.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
//返回该前端的json包装类
public class CommonPayment<T> {
    private String code;
    private String message;
    private T data;

    public CommonPayment(String code, String message) {
        this(code, message, null);
    }
}
