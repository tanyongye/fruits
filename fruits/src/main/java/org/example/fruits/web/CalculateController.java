package org.example.fruits.web;

import org.example.fruits.entity.Fruits;
import org.example.fruits.enums.DiscountTypes;
import org.example.fruits.service.CalculateService;
import org.example.fruits.service.FruitsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.List;

/**
 * 模拟RestController
 */

@Controller
public class CalculateController {

    @Autowired
    private CalculateService calculateService;

    @Autowired
    private FruitsService fruitsService;

    /**
     * 适用于计算水果列表总价
     */
    @RequestMapping("/calculate")
    @ResponseBody
    public void calculate() {
        List<Fruits> fruitsList = fruitsService.getList();
        BigDecimal totalPrice = new BigDecimal("0");

        try {
            //单一水果计算
            for (Fruits f : fruitsList) {
                String priceStr = calculateService.calculatePrice(f.getStrategy(), f.getPrice(), f.getWeight());
                totalPrice = totalPrice.add(new BigDecimal(priceStr));
                System.out.println(f.getName() + "总价(分)：" + priceStr
                        + " 重量：" + f.getWeight()
                        + " 单价：" + f.getPrice()
                        + " 优惠活动：" + DiscountTypes.codeOf(f.getStrategy()).getName());
            }

            //整体总价计算
            int overallStrategy = (int) (Math.random() * 2);
            if(DiscountTypes.codeOf(overallStrategy)==null){
                throw new Exception("优惠信息输入异常");
            }
            System.out.println("总价(分)：" + totalPrice + " 全场优惠活动：" + DiscountTypes.codeOf(overallStrategy).getName());
            if (overallStrategy != 0) {
                System.out.println("实付(分)：" + calculateService.calculatePrice(overallStrategy, totalPrice.toString(), "1"));
            } else {
                System.out.println("实付(分)：" + totalPrice);
            }
        } catch (Exception e) {
            System.out.println("提示：" + e.getMessage());
        }
    }
}
