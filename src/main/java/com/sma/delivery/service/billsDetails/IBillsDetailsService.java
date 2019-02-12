package com.sma.delivery.service.billsDetails;

import com.sma.delivery.beans.billsDetails.BillsDetailsB;
import com.sma.delivery.dto.bills_details.BillDetailDTO;
import com.sma.delivery.service.base.IBaseService;

import java.text.ParseException;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface IBillsDetailsService extends IBaseService<BillsDetailsB, BillDetailDTO> {
    public List<BillsDetailsB> getBillsDetails() throws ParseException;
    public BillDetailDTO convertBeanToDto(BillsDetailsB bean);
    public Set<BillsDetailsB> getAllBy(Map<String, String> args);
}
