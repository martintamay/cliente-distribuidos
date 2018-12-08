package com.sma.delivery.service.user;

import com.sma.delivery.beans.user.UserB;
import com.sma.delivery.dto.user.UserDTO;
import com.sma.delivery.dto.user.UserResult;
import com.sma.delivery.service.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.cache.annotation.Cacheable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<UserB, UserDTO> implements IUserService {

	@Autowired
	private com.sma.delivery.rest.user.IUserResource _userResource;

	public UserServiceImpl() {
	}

	@Override
	public UserB save(UserB bean) {
		final UserDTO user = convertBeanToDto(bean);
		final UserDTO dto = _userResource.save(user);
		final UserB userB = convertDtoToBean(dto);
		return userB;
	}
	public void delete(Integer id){
		_userResource.delete(id);
	}




	@Override
	public List<UserB> getAll(Integer page) {
		final UserResult result = _userResource.getAll(page);
		final List<UserDTO> cList = null == result.getUsers() ? new ArrayList<UserDTO>()
				: result.getUsers();

		final List<UserB> users = new ArrayList<UserB>();
		for (UserDTO dto : cList) {
			final UserB bean = convertDtoToBean(dto);
			users.add(bean);
		}
		return users;
	}
	@Override
	public List<UserB> find(String text) {
		final UserResult result = _userResource.find(text);
		final List<UserDTO> cList = null == result.getUsers() ? new ArrayList<UserDTO>()
				: result.getUsers();

		final List<UserB> users = new ArrayList<UserB>();
		for (UserDTO dto : cList) {
			final UserB bean = convertDtoToBean(dto);
			users.add(bean);
		}
		return users;
	}



@Override
	@Cacheable(value="client-delivery", key="'user_'+#root.methodName+'_'+#email")
	public UserB getByEmail(String email) {
		final UserResult result = _userResource.getByEmail(email);
		final List<UserDTO> cList = null == result.getUsers() ? new ArrayList<UserDTO>()
				: result.getUsers();

		System.out.println("UserServiceImpl: cant usr "+cList.size());
		for (UserDTO dto : cList) {
			final UserB bean = convertDtoToBean(dto);
			if (bean.getEmail().toLowerCase().trim().equals(email.toLowerCase().trim())){
				return bean;
			}
		}
		return null;
	}

	


	@Override
	public UserB getById(Integer id) {
		final UserDTO dto = _userResource.getById(id);
		final UserB bean = convertDtoToBean(dto);

		return bean;
	}

	@Override
	protected UserB convertDtoToBean(UserDTO dto) {
		final Map<String, String> params = new HashMap<String, String>();
		params.put("id", String.valueOf(dto.getId()));
		params.put("firstName", dto.getFirstName());
		params.put("lastName", dto.getLastName());
		params.put("phoneNumber", dto.getPhoneNumber());
		params.put("email", dto.getEmail());
		params.put("password", dto.getPassword());
		params.put("address",dto.getAddress());
		final UserB userB = new UserB(params);
		return userB;
	}

	@Override
	protected UserDTO convertBeanToDto(UserB bean) {
		final UserDTO dto = new UserDTO();
		dto.setId(bean.getId());
		dto.setFirstName(bean.getFirstName());
		dto.setLastName(bean.getLastName());
		dto.setAddress(bean.getAddress());
		dto.setPhoneNumber(bean.getPhoneNumber());
		dto.setEmail(bean.getEmail());
		dto.setPassword(bean.getPassword());
		return dto;
	}

	@Override
	public List<UserB> getUsers() {
		final UserResult result = _userResource.getUsers();
		final List<UserDTO> cList = null == result.getUsers() ? new ArrayList<UserDTO>() : result.getUsers();
		final List<UserB> users = new ArrayList<UserB>();
		for (UserDTO dto : cList) {
			users.add(convertDtoToBean(dto));
		}
		return users;
	}
}
