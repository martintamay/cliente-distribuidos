package com.sma.delivery.service.user;

import com.sma.delivery.beans.role.RoleB;
import com.sma.delivery.service.base.IBaseService;
import com.sma.delivery.beans.user.UserB;
import com.sma.delivery.dto.users.UserDTO;

import javax.management.relation.RoleResult;
import java.text.ParseException;
import java.util.List;

public interface IUserService extends IBaseService<UserB, UserDTO> {
    public List<UserB> getUsers() throws ParseException;
    public UserB getByEmail(String username) throws ParseException;
    public List<RoleB> getRoles(Integer userId) throws ParseException;
}
