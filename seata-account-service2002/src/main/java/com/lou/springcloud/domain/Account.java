package com.lou.springcloud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private Long id;

    private Long userId;

    private BigDecimal total;
//    消费了的金额
    private BigDecimal used;
//    剩余的金额
    private BigDecimal residue;

}
