package pers.design.cys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pers.design.cys.dataobject.OrderDetail;

import java.util.List;

/**
 * 订单详情DAO
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {

    List<OrderDetail> findByOrderId(String orderId);
}
