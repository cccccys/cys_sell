package pers.design.cys.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pers.design.cys.dataobject.ProductInfo;

import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {

    @Autowired
    private ProductInfoRepository repository;

    @Test
    public void saveTest() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("564");
        productInfo.setProductName("猴脑");
        productInfo.setProductPrice(new BigDecimal("3.8"));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("大补，好吃");
        productInfo.setProductIcon("http://oklij0lk2.bkt.clouddn.com/18-4-6/25254382.jpg");
        productInfo.setProductStatus(0);
        productInfo.setCategoryType(102);

        repository.save(productInfo);
        ProductInfo result = repository.save(productInfo);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByProductStatus() {

        List<ProductInfo> productInfoList = repository.findByProductStatus(0);
        Assert.assertNotEquals(0, productInfoList.size());
    }
}