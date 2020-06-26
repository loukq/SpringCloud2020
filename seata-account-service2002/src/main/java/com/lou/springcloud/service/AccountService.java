package com.lou.springcloud.service;

import java.math.BigDecimal;

public interface AccountService {
    void decreace(Long userId, BigDecimal money);
}
