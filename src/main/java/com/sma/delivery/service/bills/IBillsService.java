package com.sma.delivery.service.bills;

import com.sma.delivery.beans.bills.BillsB;
import com.sma.delivery.dto.bills.BillsDTO;
import com.sma.delivery.service.base.IBaseService;

import java.util.List;
public interface IBillsService extends IBaseService<BillsB, BillsDTO>{
    public List<BillsB> getBills();
}
