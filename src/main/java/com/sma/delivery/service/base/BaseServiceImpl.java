package com.sma.delivery.service.base;

import com.sma.delivery.beans.base.BaseBean;
import com.sma.delivery.dto.base.BaseDTO;

import java.text.ParseException;

public abstract class BaseServiceImpl<BEAN extends BaseBean, DTO extends BaseDTO> implements IBaseService<BEAN, DTO> {

	public BaseServiceImpl() {

	}

	protected abstract BEAN convertDtoToBean(DTO dto) throws ParseException;

	protected abstract DTO convertBeanToDto(BEAN bean) throws ParseException;

}
