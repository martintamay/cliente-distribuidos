package com.sma.delivery.rest.order;

import com.sma.delivery.dto.orders.OrderDTO;
import com.sma.delivery.dto.orders.OrderResult;
import com.sma.delivery.rest.base.BaseResourceImpl;
import org.springframework.stereotype.Repository;

@Repository("orderResource")
public class OrderResourceImpl extends BaseResourceImpl<OrderDTO> implements IOrderResource {

	public OrderResourceImpl() {
		super(OrderDTO.class, "/orders");
	}

	@Override
	public OrderResult getAll(Integer page) {
		setWebResourceBasicAuthFilter();
		final OrderResult result = getWebResource().path("/"+page+"/"+5).get(OrderResult.class);
		return result;
	}

	@Override
	public OrderResult find(String text, Integer page) {
		final OrderResult result = getWebResource().path("/search/"+page+"/"+3+"/"+text).get(OrderResult.class);
		return result;
	}

	@Override
	public OrderResult getOrders() {
		return getWebResource().path("/" + 1 + "/" + 200).get(OrderResult.class);

	}

}
