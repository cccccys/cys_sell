package pers.design.cys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pers.design.cys.dataobject.UserInfo;

/**
 * 用户表DAO
 */
public interface UserInfoRepository extends JpaRepository<UserInfo, String> {

    UserInfo findByUsername(String username);
}
