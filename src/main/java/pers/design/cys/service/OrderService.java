package pers.design.cys.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pers.design.cys.dto.OrderDTO;

/**
 * 订单Service
 */
public interface OrderService {

    //创建订单
    OrderDTO create(OrderDTO orderDTO);

    //查询单个订单
    OrderDTO findOne(String orderId);

    //查询某个openid的订单列表
    Page<OrderDTO> findList(String buyerOpenid, Pageable pageable);

    //取消订单
    OrderDTO cancel(OrderDTO orderDTO);

    //接单（完结订单
    OrderDTO finish(OrderDTO orderDTO);

    //支付订单
    OrderDTO paid(OrderDTO orderDTO);

    //查询所有人的订单列表
    Page<OrderDTO> findList(Pageable pageable);

}
