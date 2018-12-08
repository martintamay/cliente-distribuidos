package com.sma.delivery.service.user;

import com.sma.delivery.service.base.IBaseService;
import com.sma.delivery.beans.user.UserB;
import com.sma.delivery.dto.user.UserDTO;

public interface IUserService extends IBaseService<UserB, UserDTO> {

    public UserB getByEmail(String username);
}
