package com.sma.delivery.service.base;

import com.sma.delivery.beans.base.BaseBean;
import com.sma.delivery.dto.base.BaseDTO;

import java.text.ParseException;
import java.util.List;

public interface IBaseService<BEAN extends BaseBean, DTO extends BaseDTO> {
	public BEAN save(BEAN bean) throws ParseException;

	public void delete(Integer id);

	public List<BEAN> getAll(Integer page) ;

	public BEAN getById(Integer id) ;

	public List<BEAN> find(String text, Integer page) ;
}
