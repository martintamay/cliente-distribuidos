package com.sma.delivery.beans.role;

import com.sma.delivery.beans.base.BaseBean;
import org.apache.commons.lang.StringUtils;

import java.util.Map;

public class RoleB extends BaseBean {

	private static final long serialVersionUID = 4680476902664047494L;

	private String name;

	public RoleB(Map<String, String> params)  {
		super(params);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	protected void create(Map<String, String> params) {
		if (!StringUtils.isBlank(params.get("id"))) {
			setId(Integer.valueOf(params.get("id")));
		}
		setName(params.get("name"));
	}

}
