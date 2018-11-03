package pers.design.cys.converter;

import org.springframework.beans.BeanUtils;
import pers.design.cys.dataobject.OrderMaster;
import pers.design.cys.dto.OrderDTO;

import java.util.List;
import java.util.stream.Collectors;

/**
 * OrderMaster to OrderDTO 转换器
 */
public class OrderMaster2OrderDTOConverter {

    public static OrderDTO convert(OrderMaster orderMaster) {

        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster, orderDTO);
        return orderDTO;
    }

    public static List<OrderDTO> convert(List<OrderMaster> orderMasterList) {
        return orderMasterList.stream().map(e ->
                convert(e)
        ).collect(Collectors.toList());
    }
}
