package com.sma.delivery.rest.orderDetails;

import com.sma.delivery.dto.order_details.OrderDetailDTO;
import com.sma.delivery.dto.order_details.OrderDetailResult;
import com.sma.delivery.rest.base.IBaseResource;

public interface IOrderDetailsResource extends IBaseResource<OrderDetailDTO> {

	OrderDetailResult getByOrderId(Integer orderId);


}
