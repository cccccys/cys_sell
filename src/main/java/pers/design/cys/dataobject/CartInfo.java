package pers.design.cys.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 购物车表
 */
@Entity
@Data
public class CartInfo {

    @Id
    private String cartId;

    private String username;

    private String productId;

    private BigDecimal productPrice;

    private Integer productQuantity;

    private Date createTime;

}
