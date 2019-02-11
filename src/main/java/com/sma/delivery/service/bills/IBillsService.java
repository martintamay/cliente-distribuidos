package com.sma.delivery.service.bills;

import com.sma.delivery.beans.bills.BillsB;
import com.sma.delivery.dto.bills.BillDTO;
import com.sma.delivery.service.base.IBaseService;

import java.text.ParseException;
import java.util.List;
public interface IBillsService extends IBaseService<BillsB, BillDTO>{
    public List<BillsB> getBills() throws ParseException;
}
