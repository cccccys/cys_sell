package pers.design.cys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pers.design.cys.service.ProductService;
import pers.design.cys.Exception.SellException;
import pers.design.cys.dataobject.ProductInfo;
import pers.design.cys.dto.CartDTO;
import pers.design.cys.enums.ProductStatusEnum;
import pers.design.cys.enums.ResultEnum;
import pers.design.cys.repository.ProductInfoRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * 商品Service实现类
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoRepository repository;

    @Override
    public ProductInfo findOne(String productId) {
        ProductInfo productInfo = new ProductInfo();
        try {
            productInfo = repository.findById(productId).get();
        } catch (NoSuchElementException e) {
            throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
        }

        return productInfo;
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return repository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return repository.save(productInfo);
    }

    @Override
    @Transactional
    public void increaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO : cartDTOList) {

            ProductInfo productInfo = new ProductInfo();
            try {
                productInfo = repository.findById(cartDTO.getProductId()).get();
            } catch (NoSuchElementException e) {
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }

            Integer result = productInfo.getProductStock() + cartDTO.getProductQuantity();
            productInfo.setProductStock(result);

            repository.save(productInfo);
        }

    }

    @Override
    @Transactional
    public void decreaseStock(List<CartDTO> cartDTOList) {

        for (CartDTO cartDTO : cartDTOList) {

            ProductInfo productInfo = new ProductInfo();
            try {
                productInfo = repository.findById(cartDTO.getProductId()).get();
            } catch (NoSuchElementException e) {
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }

            Integer result = productInfo.getProductStock() - cartDTO.getProductQuantity();
            //判断一下库存是否充足，如果不足就报错
            if (result < 0) {
                throw new SellException(ResultEnum.PRODUCT_STOCK_ERROR);
            }
            //充足就将做差之后的库存数存回数据库
            productInfo.setProductStock(result);

            repository.save(productInfo);

        }
    }

    @Override
    public ProductInfo onSale(String productId) {

        ProductInfo productInfo = new ProductInfo();

        try {
            productInfo = repository.findById(productId).get();
        } catch (NoSuchElementException e) {
            throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
        }
        //如果是在售中就不能上架了
        if (productInfo.getProductStatusEnum() == ProductStatusEnum.UP) {
            throw new SellException(ResultEnum.PRODUCT_STATUS_ERROR);
        }
        //更新状态
        productInfo.setProductStatus(ProductStatusEnum.UP.getCode());

        return repository.save(productInfo);
    }

    @Override
    public ProductInfo offSale(String productId) {

        ProductInfo productInfo = new ProductInfo();

        try {
            productInfo = repository.findById(productId).get();
        } catch (NoSuchElementException e) {
            throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
        }
        //如果是已下架就不能下架了
        if (productInfo.getProductStatusEnum() == ProductStatusEnum.DOWN) {
            throw new SellException(ResultEnum.PRODUCT_STATUS_ERROR);
        }
        //更新状态
        productInfo.setProductStatus(ProductStatusEnum.DOWN.getCode());

        return repository.save(productInfo);
    }
}
