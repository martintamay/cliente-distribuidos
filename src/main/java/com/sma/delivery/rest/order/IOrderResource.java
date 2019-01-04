package com.sma.delivery.rest.order;

import com.sma.delivery.dto.orders.OrdersDTO;
import com.sma.delivery.dto.orders.OrdersResult;
import com.sma.delivery.rest.base.IBaseResource;

public interface IOrderResource extends IBaseResource<OrdersDTO> {

	public OrdersResult getAll(Integer page);
	public OrdersResult find(String text);
	public OrdersResult getOrders();


}
