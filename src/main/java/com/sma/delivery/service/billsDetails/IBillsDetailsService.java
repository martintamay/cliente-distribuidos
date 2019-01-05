package com.sma.delivery.service.billsDetails;

import com.sma.delivery.beans.billsDetails.BillsDetailsB;
import com.sma.delivery.dto.billsDetails.BillsDetailsDTO;
import com.sma.delivery.service.base.IBaseService;

import java.util.List;

public interface IBillsDetailsService extends IBaseService<BillsDetailsB, BillsDetailsDTO> {
    public List<BillsDetailsB> getBillsDetails();
}
