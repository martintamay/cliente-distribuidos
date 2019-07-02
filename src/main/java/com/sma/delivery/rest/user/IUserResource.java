package com.sma.delivery.rest.user;

import com.sma.delivery.dto.roles.RoleResult;
import com.sma.delivery.dto.users.UserDTO;
import com.sma.delivery.dto.users.UserResult;
import com.sma.delivery.rest.base.IBaseResource;

public interface IUserResource extends IBaseResource<UserDTO> {

	UserResult find(String text, Integer page);
	UserResult getAll(Integer page);
	UserResult getByEmail(String email);
    UserResult getUsers();
    RoleResult getRoles(Integer userId);
}
