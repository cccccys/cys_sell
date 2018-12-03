package pers.design.cys.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import pers.design.cys.enums.OrderStatusEnum;
import pers.design.cys.enums.PayStatusEnum;
import pers.design.cys.utils.EnumUtil;
import pers.design.cys.utils.serializer.Date2LongSerializer;
import pers.design.cys.dataobject.OrderDetail;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 订单DTO
 */
@Data
public class OrderDTO {

    //订单Id
    private String orderId;

    //买家名字
    private String buyerName;

    //买家电话
    private String buyerPhone;

    //买家地址
    private String buyerAddress;

    //买家username
    private String username;

    //订单总金额
    private BigDecimal orderAmount;

    //订单状态 默认0新下单
    private Integer orderStatus;

    //支付状态 默认0未支付
    private Integer payStatus;

    //创建时间
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date createTime;

    //更新时间
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date updateTime;

    List<OrderDetail> orderDetailList;

    @JsonIgnore
    public OrderStatusEnum getOrderStatusEnum() {
        return EnumUtil.getByCode(orderStatus, OrderStatusEnum.class);
    }

    @JsonIgnore
    public PayStatusEnum getPayStatusEnum() {
        return EnumUtil.getByCode(payStatus, PayStatusEnum.class);
    }
}
