package com.sma.delivery.rest.bills;

import com.sma.delivery.dto.bills.BillDTO;
import com.sma.delivery.dto.bills.BillResult;
import com.sma.delivery.rest.base.IBaseResource;
public interface IBillsResource extends IBaseResource<BillDTO>{

    public BillResult find(String text, Integer page);
    public BillResult getAll(Integer page);
    public BillResult getBills();
}
