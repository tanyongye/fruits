package org.example.fruits.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.example.fruits.enums.DiscountTypes;
import org.example.fruits.service.StrategyService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Objects;

@Service
public class FullReductionStrategyServiceImpl implements StrategyService {
    @Override
    public boolean isStrategy(Integer code) {
        return Objects.equals(code, DiscountTypes.FULL_REDUCTION.getCode());
    }

    @Override
    public String discount(String price) throws Exception {
        if (StringUtils.isNotBlank(price)) {
            BigDecimal originalPrive = new BigDecimal(price);
            BigDecimal discountPrive = originalPrive.remainder(BigDecimal.valueOf(100)).multiply(BigDecimal.valueOf(10));
            return originalPrive.subtract(discountPrive).setScale(2,BigDecimal.ROUND_DOWN).toString();
        }
        throw new Exception("FullReductionStrategyServiceImpl.discount");
    }

}
