package com.sma.delivery.service.orderDetails;

import com.sma.delivery.beans.orderDetails.OrdersDetailsB;
import com.sma.delivery.dto.order_details.OrderDetailDTO;
import com.sma.delivery.service.base.IBaseService;

import java.text.ParseException;
import java.util.List;

public interface IOrderDetailService extends IBaseService<OrdersDetailsB, OrderDetailDTO> {
    List<OrdersDetailsB> getOrderDetailsByOrderId(int orderId) throws ParseException;

}
