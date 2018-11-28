package pers.design.cys.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.design.cys.Exception.SellException;
import pers.design.cys.dataobject.CartInfo;
import pers.design.cys.enums.ResultEnum;
import pers.design.cys.repository.CartInfoRepository;
import pers.design.cys.service.CartService;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartInfoRepository repository;

    @Override
    public CartInfo create(CartInfo cartInfo) {
        return repository.save(cartInfo);
    }

    @Override
    public List<CartInfo> findByUsername(String username) {
        return repository.findByUsername(username);
    }

    @Override
    public void delete(CartInfo cartInfo) {
        repository.delete(cartInfo);
    }

    @Override
    public CartInfo findOne(String cartId) {
        CartInfo cartInfo = new CartInfo();
        try {
            cartInfo = repository.findById(cartId).get();
        } catch (NoSuchElementException e) {
            throw new SellException(ResultEnum.CART_NOT_EXIST);
        }

        return cartInfo;
    }
}
