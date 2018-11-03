package pers.design.cys.service;

import pers.design.cys.dataobject.SellerInfo;

/**
 * 用户Service接口
 */
public interface SellerService {

    //按用户名查
    SellerInfo findByUsername(String username);

    SellerInfo save(SellerInfo sellerInfo);

}
