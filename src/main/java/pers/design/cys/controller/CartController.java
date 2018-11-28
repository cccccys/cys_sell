package pers.design.cys.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pers.design.cys.dataobject.CartInfo;
import pers.design.cys.form.CartForm;
import pers.design.cys.service.CartService;
import pers.design.cys.service.OrderService;
import pers.design.cys.utils.CookieUtil;
import pers.design.cys.utils.KeyUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * 购物车Controller
 */
@Controller
@RequestMapping("/cart")
@Slf4j
public class CartController {
    @Autowired
    private CartService cartService;

    @Autowired
    private OrderService orderService;

    @GetMapping("/list")
    public ModelAndView list(HttpServletRequest request,
                             Map<String, Object> map) {

        // 从Cookie中获取username
        String username = CookieUtil.get(request, "username").getValue();

        if (username != null) {
            List<CartInfo> cartInfoList = cartService.findByUsername(username);
            map.put("cartInfoList", cartInfoList);
        }

        return new ModelAndView("cart/list", map);
    }

    @PostMapping("/add")
    public ModelAndView add(@RequestBody Map<String, String> data, Map<String, Object> map) {

        CartInfo cartInfo = new CartInfo();
        cartInfo.setCartId(KeyUtil.genUniqueKey());
        cartInfo.setUsername(data.get("username"));
        cartInfo.setProductId(data.get("productId"));
        cartInfo.setProductQuantity(Integer.valueOf(data.get("productQuantity")));

        try {
            cartService.create(cartInfo);
        } catch (Exception e) {
            map.put("msg", e.getMessage());
            map.put("url", "/sell/product/list");
            return new ModelAndView("common/error", map);
        }

        map.put("url", "/sell/product/list");
        return new ModelAndView("common/success", map);

    }

    @PostMapping("/delete")
    public ModelAndView delete(CartForm form, Map<String, Object> map) {

        CartInfo cartInfo = cartService.findOne(form.getCartId());

        try {
            cartService.delete(cartInfo);
        } catch (Exception e) {
            map.put("msg", e.getMessage());
            map.put("url", "/sell/product/list");
            return new ModelAndView("common/error", map);
        }

        map.put("url", "/sell/cart/list");
        return new ModelAndView("common/success", map);
    }

}
