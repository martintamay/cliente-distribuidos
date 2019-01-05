package com.sma.delivery.rest.billsDetails;

import com.sma.delivery.dto.billsDetails.BillsDetailsDTO;
import com.sma.delivery.dto.billsDetails.BillsDetailsResult;
import com.sma.delivery.rest.base.BaseResourceImpl;
import com.sma.delivery.rest.billsDetails.IBillsDetailsResource;
import org.springframework.stereotype.Repository;

@Repository("billsDetailsResource")
public class BillsDetailsResourceImpl extends BaseResourceImpl<BillsDetailsDTO> implements IBillsDetailsResource {

    public BillsDetailsResourceImpl() {
        super(BillsDetailsDTO.class, "/billsDetails");
    }

    @Override
    public BillsDetailsResult getAll(Integer page) {
        final BillsDetailsResult result = getWebResource().path("/"+page+"/"+20).get(BillsDetailsResult.class);
        return result;
    }

    @Override
    public BillsDetailsDTO getById(Integer id) {
        return getWebResource().path("/" + id).get(getDtoClass());
    }

    @Override
    public BillsDetailsResult find(String text) {
        final BillsDetailsResult result = getWebResource().path("/buscar").queryParam("text", text).get(BillsDetailsResult.class);
        return result;
    }

    @Override
    public BillsDetailsResult getBillsDetails() {
        return getWebResource().path("/" + 1 + "/" + 200).get(BillsDetailsResult.class);

    }

}