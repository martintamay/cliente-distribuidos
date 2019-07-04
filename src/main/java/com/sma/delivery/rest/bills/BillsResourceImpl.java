package com.sma.delivery.rest.bills;

import com.sma.delivery.dto.bills.BillDTO;
import com.sma.delivery.dto.bills.BillResult;
import com.sma.delivery.rest.base.BaseResourceImpl;
import org.springframework.stereotype.Repository;

@Repository("billsResource")
public class BillsResourceImpl extends BaseResourceImpl<BillDTO> implements IBillsResource {

    public BillsResourceImpl() {
        super(BillDTO.class, "/bills");
    }

    @Override
    public BillResult getAll(Integer page) {
        final BillResult result = getWebResource().path("/"+page+"/"+5).get(BillResult.class);
        return result;
    }

    @Override
    public BillDTO getById(Integer id) {
        return getWebResource().path("/" + id).get(getDtoClass());
    }

    @Override
    public BillResult find(String text, Integer page) {
        final BillResult result = getWebResource().path("/search/"+page+"/"+3+"/"+text).get(BillResult.class);
        return result;
    }

    @Override
    public BillResult getBills() {
        return getWebResource().path("/" + 1 + "/" + 200).get(BillResult.class);

    }

}