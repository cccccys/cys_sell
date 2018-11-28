package pers.design.cys.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pers.design.cys.dataobject.CartInfo;
import pers.design.cys.utils.KeyUtil;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CartInfoRepositoryTest {

    @Autowired
    private CartInfoRepository repository;

    @Test
    public void saveTest() {
        CartInfo cartInfo = new CartInfo();
        cartInfo.setCartId(KeyUtil.genUniqueKey());
        cartInfo.setUsername("cys");
        cartInfo.setProductId("100001");
        cartInfo.setProductQuantity(2);

        CartInfo result = repository.save(cartInfo);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByUsername() {
        List<CartInfo> cartInfoList = repository.findByUsername("cys");
        Assert.assertEquals(2, cartInfoList.size());
    }
}