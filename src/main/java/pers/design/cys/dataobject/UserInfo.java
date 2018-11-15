package pers.design.cys.dataobject;

import lombok.Data;
import pers.design.cys.utils.KeyUtil;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 用户表
 */
@Entity
@Data
public class UserInfo {

    @Id
    private String userId;

    private String username;

    private String password;

    private Integer userType = 0;

    public UserInfo() {
    }

    public UserInfo(String username, String password, Integer userType) {

        //生成随机id，并调用四参数构造器
        this(KeyUtil.genUniqueKey(), username, password, userType);
    }

    public UserInfo(String userId, String username, String password, Integer userType) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.userType = userType;
    }
}
