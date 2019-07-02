package com.sma.delivery.rest.orderDetails;

import com.sma.delivery.dto.order_details.OrderDetailDTO;
import com.sma.delivery.dto.order_details.OrderDetailResult;
import com.sma.delivery.rest.base.BaseResourceImpl;
import org.springframework.stereotype.Repository;

@Repository("orderDetailsResource")
public class OrderDetailsResourceImpl extends BaseResourceImpl<OrderDetailDTO> implements IOrderDetailsResource {

	public OrderDetailsResourceImpl() {
		super(OrderDetailDTO.class, "/order-details");
	}

	@Override
	public OrderDetailResult getByOrderId(Integer orderId) {
		final OrderDetailResult result = getWebResource().path("/by-order-id/"+orderId).get(OrderDetailResult.class);
		return result;
	}
}
