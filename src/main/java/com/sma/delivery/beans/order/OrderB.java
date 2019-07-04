package com.sma.delivery.beans.order;

import com.sma.delivery.beans.base.BaseBean;
import com.sma.delivery.beans.establishments.EstablishmentsB;
import com.sma.delivery.beans.orderDetails.OrdersDetailsB;
import com.sma.delivery.beans.user.UserB;
import com.sma.delivery.service.packages.IPackagesService;
import com.sma.delivery.service.products.IProductsService;
import com.sma.delivery.service.promotions.IPromotionsService;
import org.grails.web.json.JSONArray;
import org.grails.web.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderB extends BaseBean {

	private static final long serialVersionUID = 1L;
	private int orderNumber;
	private String address;
	private String state;
	private String contactNumber;
	private int totalCost;
	private UserB user;
	private EstablishmentsB establishments;
	private List<OrdersDetailsB> details;

	public List<OrdersDetailsB> getDetails(){
		return details;
	}

	public void setDetails(List<OrdersDetailsB> orderDetails){
		details = orderDetails;
	}

	public EstablishmentsB getEstablishments() {
		return establishments;
	}

	public void setEstablishments(EstablishmentsB establishments) {
		this.establishments = establishments;
	}

	public UserB getUser() {
		return user;
	}

	public void setUser(UserB user) {
		this.user = user;
	}



	public int getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public int getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(int totalCost) {
		this.totalCost = totalCost;
	}
	public OrderB(Map<String, String> params)  {
		super(params);
	}
	@Override
	protected void create(Map<String, String> params) {
		if(params.get("order")!=null) {
			JSONObject json = new JSONObject(params.get("order"));
			List<OrdersDetailsB> details = new ArrayList<>();

			if (json.containsKey("details")) {
				JSONArray jsonArray = new JSONArray(json.getString("details"));
				for (Object o : jsonArray) {
					Map<String, String> detailData = new HashMap<>();
					JSONObject detail = (JSONObject) o;
					if (detail.containsKey("id"))
						detailData.put("id", detail.getString("id"));


					detailData.put("cost", detail.getString("cost"));
					detailData.put("quantity", detail.getString("quantity"));
					detailData.put("comment", detail.getString("comment"));

					OrdersDetailsB detailsB = new OrdersDetailsB(detailData);
					details.add(detailsB);
				}

			}

			setDetails(details);
			JSONObject jOrder = new JSONObject(json.getString("order"));
			if (jOrder.containsKey("id"))
				setId(jOrder.getInt("id"));

			setAddress(jOrder.getString("address"));
			setContactNumber(jOrder.getString("contactNumber"));
			setOrderNumber(jOrder.getInt("orderNumber"));
			setState(jOrder.getString("state"));
			setTotalCost(jOrder.getInt("totalCost"));
		}
	}

}
