package com.sma.delivery.service.order;

import com.sma.delivery.beans.order.OrderB;
import com.sma.delivery.dto.orders.OrdersDTO;
import com.sma.delivery.service.base.IBaseService;

import java.util.List;

public interface IOrderService extends IBaseService<OrderB, OrdersDTO> {
    public List<OrderB> getOrders();

}
