package org.example.fruits.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CalculateService {

    @Autowired
    private List<StrategyService> serviceList;

    public String calculatePrice(Integer code, String price, String weight) throws Exception {
        try {
            if (StringUtils.isBlank(price) || StringUtils.isBlank(weight)) {
                throw new Exception("calculatePrice：信息有误");
            }

            //总价为零直接返回
            BigDecimal originalPrive = new BigDecimal(price).multiply(new BigDecimal(weight));
            if(originalPrive.compareTo(BigDecimal.ZERO)==0){
                return "0";
            }

            //查找对应service
            StrategyService strategyService = serviceList.stream()
                    .filter(l -> l.isStrategy(code))
                    .findFirst()
                    .orElseThrow(() -> new Exception());

            return strategyService.discount(originalPrive.toString());
        } catch (Exception e) {
            throw new Exception("calculatePrice：计算异常" + e.getMessage());
        }
    }

}
