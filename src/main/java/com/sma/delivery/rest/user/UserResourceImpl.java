package com.sma.delivery.rest.user;

import org.springframework.stereotype.Repository;

import com.sma.delivery.dto.users.UserDTO;
import com.sma.delivery.dto.users.UserResult;
import com.sma.delivery.dto.roles.RoleResult;
import com.sma.delivery.rest.base.BaseResourceImpl;

import javax.xml.bind.annotation.XmlRootElement;
@Repository("userResource")
@XmlRootElement(name = "userResult")
public class UserResourceImpl extends BaseResourceImpl<UserDTO> implements IUserResource {

	public UserResourceImpl() {
		super(UserDTO.class, "/users");
	}

	@Override
	public UserResult getAll(Integer page) {
		final UserResult result = getWebResource().path("/"+page+"/"+3).get(UserResult.class);
		return result;
	}

	@Override
	public UserDTO getById(Integer id) {
		return getWebResource().path("/" + id).get(getDtoClass());
	}

	@Override
	public UserResult find(String text, Integer page) {
		final UserResult result = getWebResource().path("/search/"+page+"/"+3+"/"+text).get(UserResult.class);
		return result;
	}

	@Override
	public UserResult getByEmail(String email) {
		final UserResult result = getWebResource(false).path("/buscar").queryParam("email", email).get(UserResult.class);
		return result;
	}

	@Override
	public UserResult getUsers() {
		return getWebResource().path("/" + 1 + "/" + 200).get(UserResult.class);
	}

	@Override
	public RoleResult getRoles(Integer userId) {
		final RoleResult result = getWebResource(false).path("/"+userId+"/roles").get(RoleResult.class);
		return result;
	}
}
