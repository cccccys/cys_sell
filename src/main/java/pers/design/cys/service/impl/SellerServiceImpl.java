package pers.design.cys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.design.cys.dataobject.SellerInfo;
import pers.design.cys.repository.SellerInfoRepository;
import pers.design.cys.service.SellerService;

/**
 * 用户Service接口impl
 */
@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerInfoRepository repository;

    @Override
    public SellerInfo findByUsername(String username) {
        return repository.findByUsername(username);
    }

    @Override
    public SellerInfo save(SellerInfo sellerInfo) {
        return repository.save(sellerInfo);
    }
}
