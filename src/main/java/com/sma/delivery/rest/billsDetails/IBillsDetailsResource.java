package com.sma.delivery.rest.billsDetails;

import com.sma.delivery.dto.billsDetails.BillsDetailsDTO;
import com.sma.delivery.dto.billsDetails.BillsDetailsResult;
import com.sma.delivery.rest.base.IBaseResource;

public interface IBillsDetailsResource extends IBaseResource<BillsDetailsDTO> {

    public BillsDetailsResult getAll(Integer page);
    public BillsDetailsResult find(String text);
    public BillsDetailsResult getBillsDetails();


}