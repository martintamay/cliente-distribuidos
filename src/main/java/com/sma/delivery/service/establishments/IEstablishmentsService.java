package com.sma.delivery.service.establishments;

import com.sma.delivery.beans.establishments.EstablishmentsB;
import com.sma.delivery.dto.establishments.EstablishmentsDTO;
import com.sma.delivery.service.base.IBaseService;
import java.util.List;

public interface IEstablishmentsService extends IBaseService<EstablishmentsB, EstablishmentsDTO> {
    public List<EstablishmentsB> getEstablishments();
}