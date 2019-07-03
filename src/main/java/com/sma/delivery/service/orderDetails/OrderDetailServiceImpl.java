package com.sma.delivery.service.orderDetails;

import com.sma.delivery.beans.orderDetails.OrdersDetailsB;
import com.sma.delivery.beans.packages.PackagesB;
import com.sma.delivery.beans.products.ProductsB;
import com.sma.delivery.beans.promotions.PromotionsB;
import com.sma.delivery.dto.order_details.OrderDetailDTO;
import com.sma.delivery.dto.order_details.OrderDetailResult;
import com.sma.delivery.rest.orderDetails.IOrderDetailsResource;
import com.sma.delivery.service.base.BaseServiceImpl;
import com.sma.delivery.service.order.IOrderService;
import com.sma.delivery.service.packages.IPackagesService;
import com.sma.delivery.service.products.IProductsService;
import com.sma.delivery.service.promotions.IPromotionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("orderDetailsService")
public class OrderDetailServiceImpl extends BaseServiceImpl<OrdersDetailsB, OrderDetailDTO> implements IOrderDetailService {

	@Autowired
	private IOrderDetailsResource orderDetailsResource;
	@Autowired
	private IProductsService _productService;
	@Autowired
	private IPromotionsService _promotionsService;
	@Autowired
	private IPackagesService _packageService;
	@Autowired
	private IOrderService _orderService;

	public OrderDetailServiceImpl() {
	}

	@Override
	public List<OrdersDetailsB> getOrderDetailsByOrderId(int orderId) throws ParseException {
		final OrderDetailResult result = orderDetailsResource.getByOrderId(orderId);
		final List<OrderDetailDTO> cList = null == result.getOrdersDetail() ? new ArrayList<OrderDetailDTO>()
				: result.getOrdersDetail();

		final List<OrdersDetailsB> orderDetails = new ArrayList<>();
		for (OrderDetailDTO dto : cList) {
			final OrdersDetailsB bean = convertDtoToBean(dto);
			orderDetails.add(bean);
			if (bean.getId() != null) {
				getCacheManager().getCache("delivery-cacheC").put("ordersDetailsClients_" + dto.getId(), bean);
			}
		}
		return orderDetails;
	}

	@Override
	public OrdersDetailsB convertDtoToBean(OrderDetailDTO dto)  {
		final Map<String, String> params = new HashMap<String, String>();
		params.put("id", String.valueOf(dto.getId()));
		params.put("cost", String.valueOf(dto.getCost()));
		params.put("quantity", String.valueOf(dto.getQuantity()));
		params.put("comment", String.valueOf(dto.getComment()));
		final OrdersDetailsB ordersDetailsB = new OrdersDetailsB(params);
		if(dto.getProductId() != 0)
			ordersDetailsB.setProduct(_productService.getById(dto.getProductId()));
		if(dto.getPromotionId() != 0)
			ordersDetailsB.setPromotion(_promotionsService.getById(dto.getPromotionId()));
		if(dto.getPackageId() != 0)
			ordersDetailsB.setPackageB(_packageService.getById(dto.getPackageId()));
		ordersDetailsB.setOrder(_orderService.getById(dto.getOrderId()));
		return ordersDetailsB;
	}

	@Override
	public OrderDetailDTO convertBeanToDto(OrdersDetailsB bean) {
		final OrderDetailDTO dto = new OrderDetailDTO();
		dto.setId(bean.getId());
		dto.setComment(bean.getComment());
		dto.setCost(bean.getCost());
		dto.setQuantity(bean.getQuantity());
		if (bean.getOrder() != null)
			dto.setOrderId(bean.getOrder().getId());
		ProductsB product = bean.getProduct();
		dto.setProductId(product != null ? product.getId() : 0);
		PromotionsB promotion = bean.getPromotion();
		dto.setPromotionId(promotion != null ? promotion.getId() : 0);
		PackagesB packageB = bean.getPackageB();
		dto.setPackageId(packageB != null ? packageB.getId() : 0);
		return dto;
	}

	@Override
	public OrdersDetailsB save(OrdersDetailsB bean) throws ParseException {
		return null;
	}

	@Override
	public void delete(Integer id) {

	}

	@Override
	public List<OrdersDetailsB> getAll(Integer page) {
		return null;
	}

	@Override
	public OrdersDetailsB getById(Integer id) {
		return null;
	}

	@Override
	public List<OrdersDetailsB> find(String text, Integer page) {
		return null;
	}
}
