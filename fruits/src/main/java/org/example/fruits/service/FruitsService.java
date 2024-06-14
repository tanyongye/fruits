package org.example.fruits.service;

import org.example.fruits.entity.Fruits;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 模拟RestController
 */

@Service
public class FruitsService {

    /**
     * 模拟从前端和数据库拿到数据
     */
    public List<Fruits> getList(){
        List<Fruits> fruitsList = new ArrayList<>();

        fruitsList.add(Fruits.builder()
                .id(1)
                .name("苹果")
                .price("800")
                .weight(String.valueOf((int) (Math.random()*100)))
                .strategy((int) (Math.random()*2)).build());
        fruitsList.add(Fruits.builder()
                .id(2)
                .name("草莓")
                .price("1300")
                .weight(String.valueOf((int) (Math.random()*100)))
                .strategy((int) (Math.random()*2)).build());
        fruitsList.add(Fruits.builder()
                .id(3)
                .name("芒果")
                .price("2000")
                .weight(String.valueOf((int) (Math.random()*100)))
                .strategy((int) (Math.random()*2)).build());

        return fruitsList;
    }


}
