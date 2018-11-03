package pers.design.cys.service;

import pers.design.cys.dataobject.ProductCategory;

import java.util.List;

/**
 * 类目Service接口
 */
public interface CategoryService {

    //查单条
    ProductCategory findOne(Integer categoryId);

    //查询所有类目
    List<ProductCategory> findAll();

    //按类型查询
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);
}
