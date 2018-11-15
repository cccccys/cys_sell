package pers.design.cys.service;

import pers.design.cys.dataobject.UserInfo;

/**
 * 用户Service接口
 */
public interface UserService {

    //按用户名查
    UserInfo findByUsername(String username);

    UserInfo save(UserInfo userInfo);

}
