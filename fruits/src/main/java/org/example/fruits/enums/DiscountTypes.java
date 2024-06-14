package org.example.fruits.enums;

import lombok.Getter;

public enum DiscountTypes {

    NORMAL(0,"原价"),
    DISCOUNTS(1,"八折"),
    FULL_REDUCTION(2,"满100减10");

    private DiscountTypes(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    /**
     * 序号
     */
    @Getter
    private Integer code;

    /**
     * 活动名称
     */
    @Getter
    private String name;

    public static DiscountTypes codeOf(Integer code) {
        for (DiscountTypes v : values())
            if (v.getCode().equals(code))
                return v;

        return null;
    }
}
