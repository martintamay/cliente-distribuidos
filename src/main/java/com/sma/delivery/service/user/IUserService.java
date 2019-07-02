package com.sma.delivery.service.user;

import com.sma.delivery.beans.role.RoleB;
import com.sma.delivery.beans.user.UserB;
import com.sma.delivery.dto.users.UserDTO;
import com.sma.delivery.service.base.IBaseService;

import java.text.ParseException;
import java.util.List;

public interface IUserService extends IBaseService<UserB, UserDTO> {
    List<UserB> getUsers() throws ParseException;
    UserB getByEmail(String username) throws ParseException;
    List<RoleB> getRoles(Integer userId) throws ParseException;
}
