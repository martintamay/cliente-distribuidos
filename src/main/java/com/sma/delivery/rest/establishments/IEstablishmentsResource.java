package com.sma.delivery.rest.establishments;

import com.sma.delivery.dto.establishments.EstablishmentsDTO;
import com.sma.delivery.dto.establishments.EstablishmentsResult;
import com.sma.delivery.rest.base.IBaseResource;

public interface IEstablishmentsResource extends IBaseResource<EstablishmentsDTO> {

    public EstablishmentsResult getAll(Integer page);
    public EstablishmentsResult find(String text);
    public EstablishmentsResult getEstablishments();

}