package com.sma.delivery.service.base;

import com.sma.delivery.beans.base.BaseBean;
import com.sma.delivery.dto.base.BaseDTO;

public abstract class BaseServiceImpl<BEAN extends BaseBean, DTO extends BaseDTO> implements IBaseService<BEAN, DTO> {

	public BaseServiceImpl() {

	}

	protected abstract BEAN convertDtoToBean(DTO dto);

	protected abstract DTO convertBeanToDto(BEAN bean);

}
