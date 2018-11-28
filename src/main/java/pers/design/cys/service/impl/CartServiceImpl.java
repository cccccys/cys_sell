package pers.design.cys.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.design.cys.dataobject.CartInfo;
import pers.design.cys.repository.CartInfoRepository;
import pers.design.cys.service.CartService;

import java.util.List;

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
}
