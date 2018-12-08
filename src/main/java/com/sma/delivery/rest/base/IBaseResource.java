package com.sma.delivery.rest.base;

import com.sma.delivery.dto.base.BaseDTO;

public interface IBaseResource<DTO extends BaseDTO> {

	public DTO save(DTO dto);

	public DTO getById(Integer id);

	public void delete(Integer id);

}
