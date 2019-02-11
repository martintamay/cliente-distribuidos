package com.sma.delivery.rest.billsDetails;

import com.sma.delivery.dto.bills_details.BillDetailDTO;
import com.sma.delivery.dto.bills_details.BillDetailResult;
import com.sma.delivery.rest.base.IBaseResource;

public interface IBillsDetailsResource extends IBaseResource<BillDetailDTO> {

    public BillDetailResult find(String text, Integer page);
    public BillDetailResult getAll(Integer page);
    public BillDetailResult getBillsDetails();


}