package com.sma.delivery.service.billsDetails;

import com.sma.delivery.beans.billsDetails.BillsDetailsB;
import com.sma.delivery.dto.bills_details.BillDetailDTO;
import com.sma.delivery.service.base.IBaseService;

import java.text.ParseException;
import java.util.List;

public interface IBillsDetailsService extends IBaseService<BillsDetailsB, BillDetailDTO> {
    public List<BillsDetailsB> getBillsDetails() throws ParseException;
}
