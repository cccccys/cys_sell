package pers.design.cys.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import pers.design.cys.enums.OrderStatusEnum;
import pers.design.cys.enums.PayStatusEnum;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单主表
 */
@Entity
@Data
@DynamicUpdate
public class OrderMaster {

    //订单Id
    @Id
    private String orderId;

    //买家名字
    private String buyerName;

    //买家电话
    private String buyerPhone;

    //买家地址
    private String buyerAddress;

    //买家微信openid
    private String buyerOpenid;

    //订单总金额
    private BigDecimal orderAmount;

    //订单状态 默认0新下单
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();

    //支付状态 默认0未支付
    private Integer payStatus = PayStatusEnum.WAIT.getCode();

    //创建时间
    private Date createTime;

    //更新时间
    private Date updateTime;
}
