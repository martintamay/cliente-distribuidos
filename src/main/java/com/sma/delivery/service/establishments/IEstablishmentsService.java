package com.sma.delivery.service.establishments;

import com.sma.delivery.beans.establishments.EstablishmentsB;
import com.sma.delivery.dto.establishments.EstablishmentDTO;
import com.sma.delivery.service.base.IBaseService;

import java.text.ParseException;
import java.util.List;

public interface IEstablishmentsService extends IBaseService<EstablishmentsB, EstablishmentDTO> {
    public List<EstablishmentsB> getEstablishments() throws ParseException;
}