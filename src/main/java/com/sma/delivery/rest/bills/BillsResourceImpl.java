package com.sma.delivery.rest.bills;

import com.sma.delivery.dto.bills.BillsDTO;
import com.sma.delivery.dto.bills.BillsResult;
import com.sma.delivery.rest.base.BaseResourceImpl;
import org.springframework.stereotype.Repository;

@Repository("billsResource")
public class BillsResourceImpl extends BaseResourceImpl<BillsDTO> implements IBillsResource {

    public BillsResourceImpl() {
        super(BillsDTO.class, "/bills");
    }

    @Override
    public BillsResult getAll(Integer page) {
        final BillsResult result = getWebResource().path("/"+page+"/"+20).get(BillsResult.class);
        return result;
    }

    @Override
    public BillsDTO getById(Integer id) {
        return getWebResource().path("/" + id).get(getDtoClass());
    }

    @Override
    public BillsResult find(String text) {
        final BillsResult result = getWebResource().path("/buscar").queryParam("text", text).get(BillsResult.class);
        return result;
    }

    @Override
    public BillsResult getBills() {
        return getWebResource().path("/" + 1 + "/" + 200).get(BillsResult.class);

    }

}