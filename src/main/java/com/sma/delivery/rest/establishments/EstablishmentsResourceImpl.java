package com.sma.delivery.rest.establishments;

import com.sma.delivery.dto.establishments.EstablishmentDTO;
import com.sma.delivery.dto.establishments.EstablishmentResult;
import com.sma.delivery.rest.base.BaseResourceImpl;
import org.springframework.stereotype.Repository;

@Repository("establishmentsResource")
public class EstablishmentsResourceImpl extends BaseResourceImpl<EstablishmentDTO> implements IEstablishmentsResource {

    public EstablishmentsResourceImpl() {
        super(EstablishmentDTO.class, "/establishments");
    }

    @Override
    public EstablishmentResult getAll(Integer page) {
        final EstablishmentResult result = getWebResource().path("/"+page+"/"+5).get(EstablishmentResult.class);
        return result;
    }

    @Override
    public EstablishmentDTO getById(Integer id) {
        return getWebResource().path("/" + id).get(getDtoClass());
    }

    @Override
    public EstablishmentResult find(String text, Integer page) {
        final EstablishmentResult result = getWebResource().path("/search/"+page+"/"+3+"/"+text).get(EstablishmentResult.class);
        return result;    }

    @Override
    public EstablishmentResult getEstablishments() {
        return getWebResource().path("/" + 1 + "/" + 200).get(EstablishmentResult.class);

    }

}