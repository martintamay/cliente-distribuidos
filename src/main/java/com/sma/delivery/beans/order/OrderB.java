package com.sma.delivery.beans.order;

import com.sma.delivery.beans.base.BaseBean;
import org.apache.commons.lang.StringUtils;

import java.util.Map;

public class OrderB extends BaseBean {

	private static final long serialVersionUID = 1L;
	private int orderNumber;
	private String address;
	private String state;
	private String contactNumber;
	private int totalCost;

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
	public OrderB(Map<String, String> params) {
		super(params);
	}
	@Override
	protected void create(Map<String, String> params) {
		if (!StringUtils.isBlank(params.get("id"))) {
			setId(Integer.valueOf(params.get("id")));
		}
		setOrderNumber(0);
		setAddress (params.get("address"));
		setState(params.get("state"));
		setContactNumber(params.get("contactNumber"));
		setTotalCost(0);

	}

}
