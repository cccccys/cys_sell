package pers.design.cys.dataobject;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import pers.design.cys.enums.ProductStatusEnum;
import pers.design.cys.utils.EnumUtil;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品实体
 */
@Entity
@Data
@DynamicUpdate
public class ProductInfo {

    @Id
    private String productId;

    //商品名
    private String productName;

    //单价
    private BigDecimal productPrice;

    //库存
    private Integer productStock;

    //描述
    private String productDescription;

    //缩略图
    private String productIcon;

    //状态 0正常1下架 默认正常
    private Integer productStatus = ProductStatusEnum.UP.getCode();

    //类目编号
    private Integer categoryType;

    //创建时间
    //@Column(columnDefinition="TIMESTAMP", insertable = false, updatable = false)
    //@Temporal(TemporalType.TIMESTAMP)
    private Date createTime;

    //修改时间
    private Date updateTime;

    @JsonIgnore
    public ProductStatusEnum getProductStatusEnum() {
        return EnumUtil.getByCode(productStatus, ProductStatusEnum.class);
    }
}
