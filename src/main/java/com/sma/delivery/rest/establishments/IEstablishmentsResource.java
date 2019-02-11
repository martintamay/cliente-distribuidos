package com.sma.delivery.rest.establishments;

import com.sma.delivery.dto.establishments.EstablishmentDTO;
import com.sma.delivery.dto.establishments.EstablishmentResult;
import com.sma.delivery.rest.base.IBaseResource;

public interface IEstablishmentsResource extends IBaseResource<EstablishmentDTO> {

    public EstablishmentResult find(String text, Integer page);
    public EstablishmentResult getAll(Integer page);
    public EstablishmentResult getEstablishments();

}