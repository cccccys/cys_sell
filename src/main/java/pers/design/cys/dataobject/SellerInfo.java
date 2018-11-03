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
public class SellerInfo {

    @Id
    private String sellerId;

    private String username;

    private String password;

    public SellerInfo() {
    }

    public SellerInfo(String username, String password) {

        //生成随机id，并调用三参数构造器
        this(KeyUtil.genUniqueKey(), username, password);
    }

    public SellerInfo(String sellerId, String username, String password) {
        this.sellerId = sellerId;
        this.username = username;
        this.password = password;
    }
}
