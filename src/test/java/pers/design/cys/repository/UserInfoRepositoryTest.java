package pers.design.cys.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pers.design.cys.dataobject.UserInfo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserInfoRepositoryTest {

    @Autowired
    private UserInfoRepository repository;

    @Test
    public void findOneTest() {
        UserInfo result = repository.findById("0").get();
        Assert.assertNotNull(result);
    }

    @Test
    public void saveTest() {
        UserInfo userInfo = new UserInfo("test", "123456", 1);
        UserInfo result = repository.save(userInfo);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByUsername() {
        UserInfo result = repository.findByUsername("root");
        Assert.assertNotNull(result);
    }
}