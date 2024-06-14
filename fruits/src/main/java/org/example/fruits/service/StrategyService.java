package org.example.fruits.service;

import java.math.BigDecimal;

public interface StrategyService {

    /**
     *判断是否使用该策略
     */
    boolean isStrategy(Integer code);

    /**
     *优惠实现
     */
    String discount(String price) throws Exception;
}
