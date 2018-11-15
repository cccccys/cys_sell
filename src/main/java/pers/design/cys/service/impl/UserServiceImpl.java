package pers.design.cys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.design.cys.dataobject.UserInfo;
import pers.design.cys.repository.UserInfoRepository;
import pers.design.cys.service.UserService;

/**
 * 用户Service接口impl
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserInfoRepository repository;

    @Override
    public UserInfo findByUsername(String username) {
        return repository.findByUsername(username);
    }

    @Override
    public UserInfo save(UserInfo userInfo) {
        return repository.save(userInfo);
    }
}
