package pers.design.cys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pers.design.cys.dataobject.CartInfo;

import java.util.List;

public interface CartInfoRepository extends JpaRepository<CartInfo, String> {

    List<CartInfo> findByUsername(String username);
}
