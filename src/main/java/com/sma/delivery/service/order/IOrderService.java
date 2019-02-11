package com.sma.delivery.service.order;

import com.sma.delivery.beans.order.OrderB;
import com.sma.delivery.dto.orders.OrderDTO;
import com.sma.delivery.service.base.IBaseService;

import java.text.ParseException;
import java.util.List;

public interface IOrderService extends IBaseService<OrderB, OrderDTO> {
    public List<OrderB> getOrders() throws ParseException;

}
