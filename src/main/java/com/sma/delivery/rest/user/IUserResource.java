package com.sma.delivery.rest.user;

import com.sma.delivery.dto.users.UserDTO;
import com.sma.delivery.dto.users.UserResult;
import com.sma.delivery.rest.base.IBaseResource;
import com.sma.delivery.dto.roles.RoleResult;

public interface IUserResource extends IBaseResource<UserDTO> {

	public UserResult find(String text, Integer page);
	public UserResult getAll(Integer page);
	public UserResult getByEmail(String email);
    public UserResult getUsers();
    public RoleResult getRoles(Integer userId);
}
