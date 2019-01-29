package com.sma.delivery.rest.billsDetails;

import com.sma.delivery.dto.billsDetails.BillsDetailsDTO;
import com.sma.delivery.dto.billsDetails.BillsDetailsResult;
import com.sma.delivery.rest.base.IBaseResource;
import delivery.billsDetails.BillsDetails;

public interface IBillsDetailsResource extends IBaseResource<BillsDetailsDTO> {

    public BillsDetailsResult find(String text, Integer page);
    public BillsDetailsResult getAll(Integer page);
    public BillsDetailsResult getBillsDetails();


}