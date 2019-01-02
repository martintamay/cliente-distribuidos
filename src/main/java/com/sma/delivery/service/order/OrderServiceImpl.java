package com.sma.delivery.service.order;

import com.sma.delivery.beans.order.OrderB;
import com.sma.delivery.dto.orders.OrdersDTO;
import com.sma.delivery.dto.orders.OrdersResult;
import com.sma.delivery.service.base.BaseServiceImpl;
import com.sma.delivery.service.establishments.IEstablishmentsService;
import com.sma.delivery.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sma.delivery.rest.order.IOrderResource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("orderService")
public class OrderServiceImpl extends BaseServiceImpl<OrderB, OrdersDTO> implements IOrderService {

	@Autowired
	private  IOrderResource ordersResource;
	@Autowired
	private IEstablishmentsService _establishmentsService;
	@Autowired
	private IUserService _userService;

	public OrderServiceImpl() {
	}

	@Override
	public OrderB save(OrderB bean) {
		final OrdersDTO order = convertBeanToDto(bean);
		final OrdersDTO dto = ordersResource.save(order);
		final OrderB orderB = convertDtoToBean(dto);
		return orderB;
	}

	@Override
	public void delete(Integer id){
		ordersResource.delete(id);
	}
	@Override
	public List<OrderB> find(String text) {
		final OrdersResult result = ordersResource.find(text);
		final List<OrdersDTO> cList = null == result.getOrders() ? new ArrayList<OrdersDTO>()
				: result.getOrders();

		final List<OrderB> orders = new ArrayList<OrderB>();
		for (OrdersDTO dto : cList) {
			final OrderB bean = convertDtoToBean(dto);
			orders.add(bean);
		}
		return orders;
	}

	@Override
	public List<OrderB> getAll(Integer page) {
		final OrdersResult result = ordersResource.getAll(page);
		final List<OrdersDTO> cList = null == result.getOrders() ? new ArrayList<OrdersDTO>()
				: result.getOrders();

		final List<OrderB> orders = new ArrayList<OrderB>();
		for (OrdersDTO dto : cList) {
			final OrderB bean = convertDtoToBean(dto);
			orders.add(bean);
		}
		return orders;
	}

	@Override
	public OrderB getById(Integer id) {
		final OrdersDTO dto = ordersResource.getById(id);
		final OrderB bean = convertDtoToBean(dto);

		return bean;
	}

	@Override
	protected OrderB convertDtoToBean(OrdersDTO dto) {
		final Map<String, String> params = new HashMap<String, String>();
		params.put("id", String.valueOf(dto.getId()));
		params.put("orderNumber", String.valueOf(dto.getOrderNumber()));
		params.put("address", dto.getAddress());
		params.put("contactNumber", dto.getContactNumber());
		params.put("state", dto.getState());
		params.put("totalCost", String.valueOf(dto.getTotalCost()));
		final OrderB orderB = new OrderB(params);
		orderB.setUser(_userService.getById(dto.getUser_id()));
		orderB.setEstablishments(_establishmentsService.getById(dto.getEstablishment_id()));
		return orderB;
	}

	@Override
	protected OrdersDTO convertBeanToDto(OrderB bean) {
		final OrdersDTO dto = new OrdersDTO();
		dto.setId(bean.getId());
		dto.setOrderNumber(bean.getOrderNumber());
		dto.setAddress(bean.getAddress());
		dto.setContactNumber(bean.getContactNumber());
		dto.setState(bean.getState());
		dto.setTotalCost(bean.getTotalCost());
		dto.setEstablishment_id(bean.getEstablishments().getId());
		dto.setUser_id(bean.getUser().getId());
		return dto;
	}
}
