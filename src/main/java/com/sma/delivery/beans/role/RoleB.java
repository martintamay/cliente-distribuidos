package com.sma.delivery.beans.role;

import com.sma.delivery.beans.base.BaseBean;
import org.apache.commons.lang.StringUtils;

import java.text.ParseException;
import java.util.Map;

public class RoleB extends BaseBean {

	private static final long serialVersionUID = 4680476902664047494L;

	private String _authority;

	public RoleB(Map<String, String> params)  {
		super(params);
	}

	public String getAuthority() {
		return _authority;
	}

	public void setAuthority(String _authority) {
		this._authority = _authority;
	}

	@Override
	protected void create(Map<String, String> params) {
		if (!StringUtils.isBlank(params.get("id"))) {
			setId(Integer.valueOf(params.get("id")));
		}
		setAuthority(params.get("authority"));
	}

}
