package com.sma.delivery.service.order;

import com.google.gson.JsonObject;
import com.sma.delivery.beans.order.OrderB;
import com.sma.delivery.beans.orderDetails.OrdersDetailsB;
import com.sma.delivery.dto.order_details.OrderDetailDTO;
import com.sma.delivery.dto.orders.OrderDTO;
import com.sma.delivery.dto.orders.OrderResult;
import com.sma.delivery.rest.order.IOrderResource;
import com.sma.delivery.rest.promotions.IPromotionsResource;
import com.sma.delivery.service.base.BaseServiceImpl;
import com.sma.delivery.service.establishments.IEstablishmentsService;
import com.sma.delivery.service.orderDetails.IOrderDetailService;
import com.sma.delivery.service.packages.IPackagesService;
import com.sma.delivery.service.products.IProductsService;
import com.sma.delivery.service.promotions.IPromotionsService;
import com.sma.delivery.service.user.IUserService;
import org.grails.web.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("orderService")
public class OrderServiceImpl extends BaseServiceImpl<OrderB, OrderDTO> implements IOrderService {

	@Autowired
	private  IOrderResource ordersResource;
	@Autowired
	private IEstablishmentsService _establishmentsService;
	@Autowired
	private IOrderDetailService _orderDetailsService;
	@Autowired
	private IUserService _userService;

	public OrderServiceImpl() {
	}

	@Override
	@CachePut(value="delivery-cacheC", key= "'commentsClients_'+#bean.id", condition = "#bean.id!=null")
	public OrderB save(OrderB bean)  {
		final OrderDTO order = convertBeanToDto(bean);
		final OrderDTO dto = ordersResource.save(order);
		final OrderB orderB = convertDtoToBean(dto);
		if (bean.getId() == null) {
			getCacheManager().getCache("delivery-cacheC").put("ordersClients_" + dto.getId(), orderB);
		}
		return orderB;
	}

	@Override
	@CacheEvict(value = "delivery-cacheC", key = "'ordersClients_' + #id")
	public void delete(Integer id){
		ordersResource.delete(id);
	}
	@Override
	public List<OrderB> find(String text, Integer page)  {
		final OrderResult result = ordersResource.find(text, page);
		final List<OrderDTO> cList = null == result.getOrders() ? new ArrayList<OrderDTO>()
				: result.getOrders();

		final List<OrderB> order = new ArrayList<OrderB>();
		for (OrderDTO dto : cList) {
			final OrderB bean = convertDtoToBean(dto);
			order.add(bean);
			if (bean.getId() != null) {
				getCacheManager().getCache("delivery-cacheC").put("ordersC_" + bean.getId(), bean);
			}
		}
		return order;
	}

	@Override
	public List<OrderB> getAll(Integer page)  {
		final OrderResult result = ordersResource.getAll(page);
		final List<OrderDTO> cList = null == result.getOrders() ? new ArrayList<OrderDTO>()
				: result.getOrders();

		final List<OrderB> orders = new ArrayList<OrderB>();
		for (OrderDTO dto : cList) {
			final OrderB bean = convertDtoToBean(dto);
			orders.add(bean);
			if (bean.getId() != null) {
				getCacheManager().getCache("delivery-cacheC").put("ordersClients_" + dto.getId(), bean);
			}
		}
		return orders;
	}

	@Override
	@Cacheable(value= "delivery-cacheC", key= "'ordersClients_'+#id")
	public OrderB getById(Integer id)  {
		final OrderDTO dto = ordersResource.getById(id);
		final OrderB bean = convertDtoToBean(dto);

		return bean;
	}

	@Override
	protected OrderB convertDtoToBean(OrderDTO dto)  {
		final Map<String, String> params = new HashMap<String, String>();
		JSONObject order = new JSONObject();
		order.put("id", String.valueOf(dto.getId()));
		order.put("orderNumber", String.valueOf(dto.getOrderNumber()));
		order.put("address", dto.getAddress());
		order.put("contactNumber", dto.getContactNumber());
		order.put("state", dto.getState());
		order.put("totalCost", String.valueOf(dto.getTotalCost()));

		List<JSONObject> details = new ArrayList<>();
		for (OrderDetailDTO detail : dto.getOrderDetails()){
			JSONObject jDetail = new JSONObject();
			if (detail.getId() != null)
				jDetail.put("id", detail.getId());

			if (detail.getProductId() != null)
				jDetail.put("productId", detail.getProductId());
			if (detail.getPackageId() != null)
				jDetail.put("packageId", detail.getPackageId());
			if (detail.getPromotionId() != null)
				jDetail.put("promotionId", detail.getPromotionId());

			jDetail.put("cost", detail.getCost());
			jDetail.put("quantity", detail.getQuantity());
			jDetail.put("comment", detail.getComment());

			details.add(jDetail);
		}

		JSONObject orderParams = new JSONObject();
		orderParams.put("order", order.toString());
		orderParams.put("details", details.toString());

		params.put("order", orderParams.toString());

		final OrderB orderB = new OrderB(params);
		orderB.setUser(_userService.getById(dto.getUserId()));
		orderB.setEstablishments(_establishmentsService.getById(dto.getEstablishmentId()));
		return orderB;
	}

	@Override
	protected OrderDTO convertBeanToDto(OrderB bean) {
		final OrderDTO dto = new OrderDTO();
		dto.setId(bean.getId());
		dto.setOrderNumber(bean.getOrderNumber());
		dto.setAddress(bean.getAddress());
		dto.setContactNumber(bean.getContactNumber());
		dto.setState(bean.getState());
		dto.setTotalCost(bean.getTotalCost());
		dto.setEstablishmentId(bean.getEstablishments().getId());
		dto.setUserId(bean.getUser().getId());

		Set<OrderDetailDTO> detailDTO = new HashSet<>();
		for (OrdersDetailsB detailsB : bean.getDetails()){
			detailDTO.add(_orderDetailsService.convertBeanToDto(detailsB));
		}
		dto.setOrderDetails(detailDTO);
		return dto;
	}

	@Override
	public List<OrderB> getOrders()  {
		final OrderResult result = ordersResource.getOrders();
		final List<OrderDTO> cList = null == result.getOrders() ? new ArrayList<OrderDTO>() : result.getOrders();
		final List<OrderB> orders = new ArrayList<OrderB>();
		for (OrderDTO dto : cList) {
			orders.add(convertDtoToBean(dto));
		}
		return orders;
	}
}
