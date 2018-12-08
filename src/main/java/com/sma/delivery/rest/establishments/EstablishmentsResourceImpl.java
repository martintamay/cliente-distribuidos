package com.sma.delivery.rest.establishments;

import com.sma.delivery.dto.establishments.EstablishmentsDTO;
import com.sma.delivery.dto.establishments.EstablishmentsResult;
import com.sma.delivery.rest.base.BaseResourceImpl;
import delivery.establishments.Establishments;
import org.springframework.stereotype.Repository;

@Repository("establishmentsResource")
public class EstablishmentsResourceImpl extends BaseResourceImpl<EstablishmentsDTO> implements IEstablishmentsResource {

    public EstablishmentsResourceImpl() {
        super(EstablishmentsDTO.class, "/establishments");
    }

    @Override
    public EstablishmentsResult getAll(Integer page) {
        final EstablishmentsResult result = getWebResource().path("/"+page+"/"+20).get(EstablishmentsResult.class);
        return result;
    }

    @Override
    public EstablishmentsDTO getById(Integer id) {
        return getWebResource().path("/" + id).get(getDtoClass());
    }

    @Override
    public EstablishmentsResult find(String text) {
        final EstablishmentsResult result = getWebResource().path("/buscar").queryParam("text", text).get(EstablishmentsResult.class);
        return result;
    }

}