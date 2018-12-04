package pers.design.cys.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import pers.design.cys.Exception.SellException;
import pers.design.cys.converter.OrderForm2OrderDTOConverter;
import pers.design.cys.dataobject.CartInfo;
import pers.design.cys.dto.OrderDTO;
import pers.design.cys.enums.ResultEnum;
import pers.design.cys.form.OrderForm;
import pers.design.cys.service.CartService;
import pers.design.cys.service.OrderService;
import pers.design.cys.utils.CookieUtil;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * 订单Service
 */
@Controller
@RequestMapping("/order")
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private CartService cartService;

    /**
     * 查询所有订单
     *
     * @param page 页数，从1开始
     * @param size 每页数据数
     * @return
     */
    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "page", defaultValue = "1") Integer page,
                             @RequestParam(value = "size", defaultValue = "10") Integer size,
                             Map<String, Object> map) {

        PageRequest request = new PageRequest(page - 1, size);
        Page<OrderDTO> orderDTOPage = orderService.findList(request);
        map.put("orderDTOPage", orderDTOPage);
        map.put("currentPage", page);
        map.put("size", size);
        return new ModelAndView("order/list", map);
    }

    /**
     * 查看用户订单
     *
     * @param request
     * @param page
     * @param size
     * @param map
     * @return
     */
    @GetMapping("buyer_list")
    public ModelAndView buyerList(HttpServletRequest request,
                                  @RequestParam(value = "page", defaultValue = "1") Integer page,
                                  @RequestParam(value = "size", defaultValue = "10") Integer size,
                                  Map<String, Object> map) {
        PageRequest pageRequest = new PageRequest(page - 1, size);
        String username = CookieUtil.get(request, "username").getValue();
        if (username == null) {
            map.put("msg", "请先登录");
            map.put("url", "/sell/index");
            return new ModelAndView("common/error", map);
        }
        Page<OrderDTO> orderDTOPage = orderService.findListByUsername(username, pageRequest);
        map.put("orderDTOPage", orderDTOPage);
        map.put("currentPage", page);
        map.put("size", size);
        return new ModelAndView("order/list", map);
    }

    /**
     * 取消订单
     *
     * @param orderId
     * @return
     */
    @GetMapping("/cancel")
    public ModelAndView cancel(@RequestParam("orderId") String orderId,
                               Map<String, Object> map) {

        try {
            OrderDTO orderDTO = orderService.findOne(orderId);
            orderService.cancel(orderDTO);
        } catch (SellException e) {
            log.error("【卖家端取消订单】发生异常{}", e);
            map.put("msg", e.getMessage());
            map.put("url", "/sell/order/list");
            return new ModelAndView("common/error", map);
        }

        map.put("msg", ResultEnum.ORDER_CANCEL_SUCCESS.getMessage());
        map.put("url", "/sell/order/list");
        return new ModelAndView("common/success");
    }

    /**
     * 查看订单详情
     *
     * @param orderId
     * @param map
     * @return
     */
    @GetMapping("/detail")
    public ModelAndView detail(@RequestParam("orderId") String orderId,
                               Map<String, Object> map) {

        OrderDTO orderDTO = new OrderDTO();
        try {
            orderDTO = orderService.findOne(orderId);
        } catch (SellException e) {
            log.error("【卖家端查询订单详情】发生异常{}", e);
            map.put("msg", e.getMessage());
            map.put("url", "/sell/order/list");
            return new ModelAndView("common/error", map);
        }

        map.put("orderDTO", orderDTO);
        return new ModelAndView("order/detail", map);
    }

    /**
     * 完结订单
     *
     * @param orderId
     * @param map
     * @return
     */
    @GetMapping("/finish")
    public ModelAndView finish(@RequestParam("orderId") String orderId,
                               Map<String, Object> map) {

        try {
            OrderDTO orderDTO = orderService.findOne(orderId);
            orderService.finish(orderDTO);
        } catch (SellException e) {
            log.error("【卖家端完结订单】发生异常{}", e);
            map.put("msg", e.getMessage());
            map.put("url", "/sell/order/list");
            return new ModelAndView("common/error", map);
        }

        map.put("msg", ResultEnum.ORDER_FINISH_SUCCESS.getMessage());
        map.put("url", "/sell/order/list");
        return new ModelAndView("common/success");
    }

    @PostMapping("/add")
    public ModelAndView add(HttpServletRequest request,
                            @Valid OrderForm orderForm,
                            BindingResult bindingResult,
                            Map<String, Object> map) {

        if (bindingResult.hasErrors()) {
            map.put("msg", ResultEnum.PARAM_ERROR.getMessage());
            map.put("url", "/sell/cart/list");
            return new ModelAndView("common/error", map);
        }
        OrderDTO orderDTO = OrderForm2OrderDTOConverter.convert(orderForm);
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())) {
            map.put("msg", ResultEnum.CART_EMPTY.getMessage());
            map.put("url", "/sell/cart/list");
            return new ModelAndView("common/error", map);
        }

        OrderDTO createResult = orderService.create(orderDTO);
        if (createResult != null) {
            String username = CookieUtil.get(request, "username").getValue();
            List<CartInfo> cartInfoList = cartService.findByUsername(username);
            cartInfoList.forEach(cart -> cartService.delete(cart));

        }

        String url = "/sell/order/detail?orderId=" + createResult.getOrderId();

        map.put("url", url);
        return new ModelAndView("common/success", map);
    }
}

