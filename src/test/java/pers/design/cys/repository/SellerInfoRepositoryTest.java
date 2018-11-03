package pers.design.cys.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pers.design.cys.dataobject.SellerInfo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SellerInfoRepositoryTest {

    @Autowired
    private SellerInfoRepository repository;

    @Test
    public void findOneTest() {
        SellerInfo result = repository.findById("0").get();
        Assert.assertNotNull(result);
    }

    @Test
    public void saveTest() {
        SellerInfo sellerInfo = new SellerInfo("test", "123456");
        SellerInfo result = repository.save(sellerInfo);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByUsername() {
        SellerInfo result = repository.findByUsername("root");
        Assert.assertNotNull(result);
    }
}