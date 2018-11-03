package pers.design.cys.enums;


import lombok.Getter;

/**
 * 商品状态枚举
 */
@Getter
public enum ProductStatusEnum implements CodeEnum {

    UP(0, "在售中"),
    DOWN(1, "已下架");

    private Integer code;

    private String message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
