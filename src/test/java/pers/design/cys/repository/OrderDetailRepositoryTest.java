package pers.design.cys.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pers.design.cys.dataobject.OrderDetail;

import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {

    @Autowired
    private OrderDetailRepository repository;

    @Test
    public void saveTest() {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("79489");
        orderDetail.setOrderId("123457");
        orderDetail.setProductIcon("dasdsafa");
        orderDetail.setProductId("564");
        orderDetail.setProductName("曹珊珊");
        orderDetail.setProductPrice(new BigDecimal("50000.00"));
        orderDetail.setProductQuantity(10);

        OrderDetail result = repository.save(orderDetail);
        Assert.assertNotNull(result);

    }

    @Test
    public void findByOrderId() {
        List<OrderDetail> orderDetailList = repository.findByOrderId("123457");
        Assert.assertNotEquals(0, orderDetailList.size());
    }
}