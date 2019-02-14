package com.sma.delivery.service.order;

import com.sma.delivery.beans.order.OrderB;
import com.sma.delivery.dto.orders.OrderDTO;
import com.sma.delivery.dto.orders.OrderResult;
import com.sma.delivery.service.base.BaseServiceImpl;
import com.sma.delivery.service.establishments.IEstablishmentsService;
import com.sma.delivery.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import com.sma.delivery.rest.order.IOrderResource;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("orderService")
public class OrderServiceImpl extends BaseServiceImpl<OrderB, OrderDTO> implements IOrderService {

	@Autowired
	private  IOrderResource ordersResource;
	@Autowired
	private IEstablishmentsService _establishmentsService;
	@Autowired
	private IUserService _userService;

	public OrderServiceImpl() {
	}

	@Override
	@CachePut(value="delivery-cacheC", key= "'commentsClients_'+#order.id", condition = "#bean.id!=null")
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
	@Cacheable(value = "delivery-cache")
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
		params.put("id", String.valueOf(dto.getId()));
		params.put("orderNumber", String.valueOf(dto.getOrderNumber()));
		params.put("address", dto.getAddress());
		params.put("contactNumber", dto.getContactNumber());
		params.put("state", dto.getState());
		params.put("totalCost", String.valueOf(dto.getTotalCost()));
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
