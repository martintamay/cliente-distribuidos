package com.sma.delivery.rest.order;

import com.sma.delivery.dto.orders.OrdersDTO;
import com.sma.delivery.dto.orders.OrdersResult;
import com.sma.delivery.rest.base.BaseResourceImpl;
import org.springframework.stereotype.Repository;

@Repository("orderResource")
public class OrderResourceImpl extends BaseResourceImpl<OrdersDTO> implements IOrderResource {

	public OrderResourceImpl() {
		super(OrdersDTO.class, "/orders");
	}

	@Override
	public OrdersResult getAll(Integer page) {
		setWebResourceBasicAuthFilter();
		final OrdersResult result = getWebResource().path("/"+page+"/"+20).get(OrdersResult.class);
		return result;
	}

}
