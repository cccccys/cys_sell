package pers.design.cys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pers.design.cys.dataobject.ProductInfo;

import java.util.List;

/**
 * 商品表DAO
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo, String> {

    List<ProductInfo> findByProductStatus(Integer productStatus);
}
