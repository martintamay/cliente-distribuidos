package com.sma.delivery.service.user;

import com.sma.delivery.service.base.IBaseService;
import com.sma.delivery.beans.user.UserB;
import com.sma.delivery.dto.user.UserDTO;

import java.util.List;

public interface IUserService extends IBaseService<UserB, UserDTO> {
    public List<UserB> getUsers();
    public UserB getByEmail(String username);
}
