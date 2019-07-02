package com.sma.delivery.rest.billsDetails;

import com.sma.delivery.dto.bills_details.BillDetailDTO;
import com.sma.delivery.dto.bills_details.BillDetailResult;
import com.sma.delivery.rest.base.BaseResourceImpl;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository("billsDetailsResource")
public class BillsDetailsResourceImpl extends BaseResourceImpl<BillDetailDTO> implements IBillsDetailsResource {

    public BillsDetailsResourceImpl() {
        super(BillDetailDTO.class, "/bill-details");
    }

    @Override
    public BillDetailResult getAll(Integer page) {
        final BillDetailResult result = getWebResource().path("/"+page+"/"+20).get(BillDetailResult.class);
        return result;
    }

    @Override
    public BillDetailDTO getById(Integer id) {
        return getWebResource().path("/" + id).get(getDtoClass());
    }

    @Override
    public BillDetailResult find(String text, Integer page) {
        final BillDetailResult result = getWebResource().path("/search/"+page+"/"+3+"/"+text).get(BillDetailResult.class);
        return result;
    }

    @Override
    public BillDetailResult getBillsDetails() {
        return getWebResource().path("/" + 1 + "/" + 200).get(BillDetailResult.class);
    }

    @Override
    public BillDetailResult getAllBy(Map<String, String> args) {
        return getWebResource().path("/billId/" +args.get("billId")).get(BillDetailResult.class);
    }

}