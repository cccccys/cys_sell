package pers.design.cys.service;

import pers.design.cys.dataobject.CartInfo;

import java.util.List;

public interface CartService {

    // 添加新的购物车记录
    CartInfo create(CartInfo cartInfo);

    // 查询指定用户的购物车
    List<CartInfo> findByUsername(String username);

    void delete(CartInfo cartInfo);

    CartInfo findOne(String cartId);
}
