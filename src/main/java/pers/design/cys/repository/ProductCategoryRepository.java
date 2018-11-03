package pers.design.cys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pers.design.cys.dataobject.ProductCategory;

import java.util.List;

/**
 * 商品类目DAO
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
