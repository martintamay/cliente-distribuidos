package com.sma.delivery.service.billsDetails;

import com.sma.delivery.beans.billsDetails.BillsDetailsB;
import com.sma.delivery.dto.bills_details.BillDetailDTO;
import com.sma.delivery.dto.bills_details.BillDetailResult;
import com.sma.delivery.service.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sma.delivery.rest.billsDetails.IBillsDetailsResource;
import com.sma.delivery.service.bills.IBillsService;


import java.text.ParseException;
import java.util.*;

@Service("billsService")
public class BillsDetailsServiceImpl extends BaseServiceImpl<BillsDetailsB, BillDetailDTO> implements IBillsDetailsService {

    @Autowired
    private IBillsDetailsResource _billsDetailsResource;

    @Autowired
    private IBillsService _billsService;
    public BillsDetailsServiceImpl() {
    }

    @Override
    public BillsDetailsB save(BillsDetailsB bean)  {
        final BillDetailDTO billsDetails = convertBeanToDto(bean);
        final BillDetailDTO dto = _billsDetailsResource.save(billsDetails);

        final BillsDetailsB billsDetailsB = convertDtoToBean(dto);
        return billsDetailsB;
    }

    @Override
    public void delete(Integer id){
        _billsDetailsResource.delete(id);
    }

    @Override
    public List<BillsDetailsB> getAll(Integer page)  {
        final BillDetailResult result = _billsDetailsResource.getAll(page);
        final List<BillDetailDTO> cList = null == result.getBillsDetails() ? new ArrayList<BillDetailDTO>()
                : result.getBillsDetails();

        final List<BillsDetailsB> billsDetails = new ArrayList<BillsDetailsB>();
        for (BillDetailDTO dto : cList) {
            final BillsDetailsB bean = convertDtoToBean(dto);
            billsDetails.add(bean);
        }
        return billsDetails;
    }
    @Override
    public BillsDetailsB getById(Integer id)  {
        final BillDetailDTO dto = _billsDetailsResource.getById(id);
        final BillsDetailsB bean = convertDtoToBean(dto);

        return bean;
    }

    @Override
    public List<BillsDetailsB> find(String text, Integer page)  {

        final BillDetailResult result = _billsDetailsResource.find(text, page);
        final List<BillDetailDTO> cList = null == result.getBillsDetails() ? new ArrayList<BillDetailDTO>()
                : result.getBillsDetails();

        final List<BillsDetailsB> bills = new ArrayList<BillsDetailsB>();
        for (BillDetailDTO dto : cList) {
            final BillsDetailsB bean = convertDtoToBean(dto);
            bills.add(bean);
        }
        return bills;
    }

    @Override
    protected BillsDetailsB convertDtoToBean(BillDetailDTO dto)  {
        final Map<String, String> params = new HashMap<String, String>();
        params.put("id", String.valueOf(dto.getId()));
        params.put("amount", String.valueOf(dto.getAmount()));
        params.put("iva10", String.valueOf(dto.getIva10()));
        final BillsDetailsB billsDetailsB = new BillsDetailsB(params);

        billsDetailsB.setBills(_billsService.getById(dto.getBill()));
        return billsDetailsB;
    }

    @Override
    public BillDetailDTO convertBeanToDto(BillsDetailsB bean) {
        final BillDetailDTO dto = new BillDetailDTO();
        dto.setId(bean.getId());
        dto.setAmount(bean.getAmount());
        dto.setIva10(bean.getIva10());
        if(bean.getBills() != null)
        dto.setBill(bean.getBills().getId());

        return dto;
    }

    @Override
    public List<BillsDetailsB> getBillsDetails() throws ParseException {
        final BillDetailResult result = _billsDetailsResource.getBillsDetails();
        final List<BillDetailDTO> cList = null == result.getBillsDetails() ? new ArrayList<BillDetailDTO>() : result.getBillsDetails();
        final List<BillsDetailsB> bills = new ArrayList<BillsDetailsB>();
        for (BillDetailDTO dto : cList) {
            bills.add(convertDtoToBean(dto));
        }
        return bills;
    }

    @Override
    public Set<BillsDetailsB> getAllBy(Map<String, String> args) {
        final BillDetailResult result = _billsDetailsResource.getAllBy(args);
        final List<BillDetailDTO> cList = null == result.getBillsDetails() ? new ArrayList<>()
                : result.getBillsDetails();
        final Set<BillsDetailsB> billsDetails = new HashSet<>();
        for (BillDetailDTO dto : cList) {
            final BillsDetailsB billDetail = convertDtoToBean(dto);
            billsDetails.add(billDetail);
        }
        return billsDetails;
    }
}

