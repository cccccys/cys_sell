package pers.design.cys.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pers.design.cys.dataobject.ProductInfo;
import pers.design.cys.dto.CartDTO;

import java.util.List;

/**
 * 商品Service
 */
public interface ProductService {

    ProductInfo findOne(String productId);

    //查询所有状态为0的商品(上架的
    List<ProductInfo> findUpAll();

    //查询所有商品
    Page<ProductInfo> findAll(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);

    //加库存
    void increaseStock(List<CartDTO> cartDTOList);

    //减库存
    void decreaseStock(List<CartDTO> cartDTOList);

    //上架
    ProductInfo onSale(String productId);

    //下架
    ProductInfo offSale(String productId);

}
