package com.sma.delivery.service.base;

import com.sma.delivery.beans.base.BaseBean;
import com.sma.delivery.dto.base.BaseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;

import java.text.ParseException;

public abstract class BaseServiceImpl<BEAN extends BaseBean, DTO extends BaseDTO> implements IBaseService<BEAN, DTO> {

	public BaseServiceImpl() {

	}
	@Autowired
	private CacheManager cacheManager;

	protected CacheManager getCacheManager() {
		return cacheManager;
	}

	protected abstract BEAN convertDtoToBean(DTO dto) throws ParseException;

	protected abstract DTO convertBeanToDto(BEAN bean) throws ParseException;

}
