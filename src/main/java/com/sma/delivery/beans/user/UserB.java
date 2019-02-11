package com.sma.delivery.beans.user;

import java.text.ParseException;
import java.util.Map;
import java.util.Set;

import com.sma.delivery.beans.role.RoleB;
import org.apache.commons.lang.StringUtils;
import com.sma.delivery.beans.base.BaseBean;

import javax.xml.bind.annotation.XmlRootElement;

public class UserB extends BaseBean {

	private static final long serialVersionUID = 1L;
	private String _firstName;
	private String _email;
	private String _lastName;
	private String _password;
	private String _address;
	private String _phone_number;
	private String _accountLocked;
	private Set<RoleB> _roles;

	public String getPhoneNumber() {
		return _phone_number;
	}

	public void setPhoneNumber(String _phone_number) {
		this._phone_number = _phone_number;
	}

	public String getPassword() {
		return _password;
	}

	public void setPassword(String _password) {
		this._password = _password;
	}

	public String getAddress() {
		return _address;
	}

	public void setAddress(String _address) {
		this._address = _address;
	}

	public String getFirstName() {
		return _firstName;
	}

	public void setEmail(String email) {
		_email = email;
	}

	public String getEmail() {
		return _email;
	}

	public void setFirstName(String firstName) {
		_firstName = firstName;
	}

	public String getLastName() {
		return _lastName;
	}

	public void setLastName(String lastName) {
		_lastName = lastName;
	}

	public UserB(Map<String, String> params)  {
		super(params);
	}


	public String getAccountLocked() {
		return _accountLocked;
	}

	public void setAccountLocked(String _accountLocked) {
		this._accountLocked = _accountLocked;
	}

	public Set<RoleB> getRoles(){
		return _roles;
	}

	public void setRoles(Set<RoleB> roles){
		_roles = roles;
	}

	@Override
	protected void create(Map<String, String> params) {
		if (!StringUtils.isBlank(params.get("id"))) {
			setId(Integer.valueOf(params.get("id")));
		}
		setFirstName(params.get("firstName"));
		setLastName(params.get("lastName"));
		setAddress(params.get("address"));
		setPassword(params.get("password"));
		setEmail(params.get("email"));
		setPhoneNumber(params.get("phoneNumber"));
	}

}
