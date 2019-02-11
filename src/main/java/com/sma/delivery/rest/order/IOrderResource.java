package com.sma.delivery.rest.order;

import com.sma.delivery.dto.orders.OrderDTO;
import com.sma.delivery.dto.orders.OrderResult;
import com.sma.delivery.rest.base.IBaseResource;

public interface IOrderResource extends IBaseResource<OrderDTO> {

	public OrderResult find(String text, Integer page);
	public OrderResult getAll(Integer page);
	public OrderResult getOrders();


}
