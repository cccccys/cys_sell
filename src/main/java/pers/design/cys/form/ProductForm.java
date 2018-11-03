package pers.design.cys.form;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 商品表单对象
 */
@Data
public class ProductForm {

    private String productId;

    //商品名
    private String productName;

    //单价 mysql的decimal在Java里用BigDecimal
    private BigDecimal productPrice;

    //库存
    private Integer productStock;

    //描述
    private String productDescription;

    //缩略图
    private String productIcon;

    //类目编号
    private Integer categoryType;
}

