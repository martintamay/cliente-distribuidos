package com.sma.delivery.service.billsDetails;

import com.sma.delivery.beans.billsDetails.BillsDetailsB;
import com.sma.delivery.dto.billsDetails.BillsDetailsDTO;
import com.sma.delivery.dto.billsDetails.BillsDetailsResult;
import com.sma.delivery.service.base.BaseServiceImpl;
import com.sma.delivery.service.billsDetails.IBillsDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sma.delivery.rest.billsDetails.IBillsDetailsResource;
import com.sma.delivery.service.bills.IBillsService;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("billsService")
public class BillsDetailsServiceImpl extends BaseServiceImpl<BillsDetailsB, BillsDetailsDTO> implements IBillsDetailsService {

    @Autowired
    private IBillsDetailsResource _billsDetailsResource;

    @Autowired
    private IBillsService _billsService;
    public BillsDetailsServiceImpl() {
    }

    @Override
    public BillsDetailsB save(BillsDetailsB bean) {
        final BillsDetailsDTO billsDetails = convertBeanToDto(bean);
        final BillsDetailsDTO dto = _billsDetailsResource.save(billsDetails);

        final BillsDetailsB billsDetailsB = convertDtoToBean(dto);
        return billsDetailsB;
    }

    @Override
    public void delete(Integer id){
        _billsDetailsResource.delete(id);
    }

    @Override
    public List<BillsDetailsB> getAll(Integer page) {
        final BillsDetailsResult result = _billsDetailsResource.getAll(page);
        final List<BillsDetailsDTO> cList = null == result.getBillsDetails() ? new ArrayList<BillsDetailsDTO>()
                : result.getBillsDetails();

        final List<BillsDetailsB> billsDetails = new ArrayList<BillsDetailsB>();
        for (BillsDetailsDTO dto : cList) {
            final BillsDetailsB bean = convertDtoToBean(dto);
            billsDetails.add(bean);
        }
        return billsDetails;
    }
    @Override
    public BillsDetailsB getById(Integer id) {
        final BillsDetailsDTO dto = _billsDetailsResource.getById(id);
        final BillsDetailsB bean = convertDtoToBean(dto);

        return bean;
    }

    @Override
    public List<BillsDetailsB> find(String text, Integer page) {

        final BillsDetailsResult result = _billsDetailsResource.find(text, page);
        final List<BillsDetailsDTO> cList = null == result.getBillsDetails() ? new ArrayList<BillsDetailsDTO>()
                : result.getBillsDetails();

        final List<BillsDetailsB> bills = new ArrayList<BillsDetailsB>();
        for (BillsDetailsDTO dto : cList) {
            final BillsDetailsB bean = convertDtoToBean(dto);
            bills.add(bean);
        }
        return bills;
    }

    @Override
    protected BillsDetailsB convertDtoToBean(BillsDetailsDTO dto) {
        final Map<String, String> params = new HashMap<String, String>();
        params.put("id", String.valueOf(dto.getId()));
        params.put("amount", String.valueOf(dto.getAmount()));
        params.put("iva10", String.valueOf(dto.getIva()));

        final BillsDetailsB billsDetailsB = new BillsDetailsB(params);

        billsDetailsB.setBills(_billsService.getById(dto.get_bills()));
        return billsDetailsB;
    }

    @Override
    protected BillsDetailsDTO convertBeanToDto(BillsDetailsB bean) {
        final BillsDetailsDTO dto = new BillsDetailsDTO();
        dto.setId(bean.getId());
        dto.setAmount(bean.getAmount());
        dto.setIva(bean.getIva10());
        dto.set_bills(bean.getBills().getId());

        return dto;
    }

    @Override
    public List<BillsDetailsB> getBillsDetails() {
        final BillsDetailsResult result = _billsDetailsResource.getBillsDetails();
        final List<BillsDetailsDTO> cList = null == result.getBillsDetails() ? new ArrayList<BillsDetailsDTO>() : result.getBillsDetails();
        final List<BillsDetailsB> bills = new ArrayList<BillsDetailsB>();
        for (BillsDetailsDTO dto : cList) {
            bills.add(convertDtoToBean(dto));
        }
        return bills;
    }
}

