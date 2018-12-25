package pers.design.cys.enums;

import lombok.Getter;

@Getter
public enum ResultEnum {

    SUCCESS(0, "成功"),
    PARAM_ERROR(1, "参数不正确"),
    PRODUCT_NOT_EXIST(10, "商品不存在"),
    PRODUCT_STOCK_ERROR(11, "商品库存不正确"),
    ORDER_NOT_EXIST(12, "订单不存在"),
    ORDERDETAIL_NOT_EXIST(13, "订单详情不存在"),
    ORDER_STATUS_ERROR(14, "订单状态不正确"),
    ORDER_UPDATE_FAIL(15, "订单更新失败"),
    ORDER_DETAIL_EMPTY(16, "订单详情为空"),
    ORDER_PAY_STATUS_ERROR(17, "订单支付状态不正确"),
    CART_EMPTY(18, "购物车为空"),
    ORDER_CANCEL_SUCCESS(22, "订单取消成功"),
    ORDER_FINISH_SUCCESS(23, "订单完结成功"),
    PRODUCT_STATUS_ERROR(24, "商品状态不正确"),
    LOGIN_FAIL(25, "登录失败，登录信息不正确"),
    LOGOUT_SUCCESS(26, "登出成功"),
    LOGIN_SUCCESS(27, "登陆成功"),
    REG_SUCCESS(28, "注册成功"),
    REG_FAILED(29, "注册失败"),
    PASSWORD_INCONSISTENT(30, "两次密码输入不一致"),
    USER_NOT_EXIST(31, "用户不存在"),
    CART_NOT_EXIST(32, "购物车记录不存在"),
    ADD_CART_SUCCESS(33, "添加购物车成功"),
    USER_EXISTED(34, "用户已存在"),
    ;

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
