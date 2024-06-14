package org.example.fruits.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Fruits {

    /**
     * 序号
     */
    private Integer id;

    /**
     * 名字
     */
    private String name;

    /**
     * 价格（单位：分/斤）
     */
    private String price;

    /**
     * 重量
     */
    private String weight;

    /**
     * 优惠策略
     */
    private Integer strategy;

}
