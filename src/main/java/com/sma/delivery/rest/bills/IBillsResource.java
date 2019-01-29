package com.sma.delivery.rest.bills;

import com.sma.delivery.dto.bills.BillsDTO;
import com.sma.delivery.dto.bills.BillsResult;
import com.sma.delivery.rest.base.IBaseResource;
public interface IBillsResource extends IBaseResource<BillsDTO>{

    public BillsResult find(String text, Integer page);
    public BillsResult getAll(Integer page);
    public BillsResult getBills();
}
