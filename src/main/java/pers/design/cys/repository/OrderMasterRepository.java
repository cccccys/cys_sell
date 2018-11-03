package pers.design.cys.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import pers.design.cys.dataobject.OrderMaster;

/**
 * 订单主表DAO
 */
public interface OrderMasterRepository extends JpaRepository<OrderMaster, String> {

    //按照买家id来查询，防止订单量过大，用分页方式
    Page<OrderMaster> findByBuyerOpenid(String buyerOpenid, Pageable pageable);
}
