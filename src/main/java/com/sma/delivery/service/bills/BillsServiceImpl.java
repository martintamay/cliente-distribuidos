package com.sma.delivery.service.bills;

import com.sma.delivery.beans.bills.BillsB;
import com.sma.delivery.dto.bills.BillsDTO;
import com.sma.delivery.dto.bills.BillsResult;
import com.sma.delivery.service.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sma.delivery.rest.bills.IBillsResource;
import com.sma.delivery.service.order.IOrderService;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("billsService")
public class BillsServiceImpl extends BaseServiceImpl<BillsB, BillsDTO> implements IBillsService {

    @Autowired
    private IBillsResource _billsResource;

    @Autowired
    private IOrderService _orderService;
    public BillsServiceImpl() {
    }

    @Override
    public BillsB save(BillsB bean) {
        final BillsDTO bills = convertBeanToDto(bean);
        final BillsDTO dto = _billsResource.save(bills);

        final BillsB billsB = convertDtoToBean(dto);
        return billsB;
    }

    @Override
    public void delete(Integer id){
        _billsResource.delete(id);
    }

    @Override
    public List<BillsB> getAll(Integer page) {
        final BillsResult result = _billsResource.getAll(page);
        final List<BillsDTO> cList = null == result.getBills() ? new ArrayList<BillsDTO>()
                : result.getBills();

        final List<BillsB> bills = new ArrayList<BillsB>();
        for (BillsDTO dto : cList) {
            final BillsB bean = convertDtoToBean(dto);
            bills.add(bean);
        }
        return bills;
    }
    @Override
    public BillsB getById(Integer id) {
        final BillsDTO dto = _billsResource.getById(id);
        final BillsB bean = convertDtoToBean(dto);

        return bean;
    }

    @Override
    public List<BillsB> find(String text, Integer page) {

        final BillsResult result = _billsResource.find(text, page);
        final List<BillsDTO> cList = null == result.getBills() ? new ArrayList<BillsDTO>()
                : result.getBills();

        final List<BillsB> bills = new ArrayList<BillsB>();
        for (BillsDTO dto : cList) {
            final BillsB bean = convertDtoToBean(dto);
            bills.add(bean);
        }
        return bills;
    }

    @Override
    protected BillsB convertDtoToBean(BillsDTO dto) {
        final Map<String, String> params = new HashMap<String, String>();
        params.put("id", String.valueOf(dto.getId()));
        params.put("total", dto.getTotal());
        params.put("iva10", String.valueOf(dto.getIva()));

        final BillsB billsB = new BillsB(params);

        billsB.setOrder(_orderService.getById(dto.getOrder_id()));
        return billsB;
    }

    @Override
    protected BillsDTO convertBeanToDto(BillsB bean) {
        final BillsDTO dto = new BillsDTO();
        dto.setId(bean.getId());
        dto.setTotal(bean.getTotal());
        dto.setIva(bean.getIva10());
        dto.setOrder_id(bean.getOrder().getId());

        return dto;
    }

    @Override
    public List<BillsB> getBills() {
        final BillsResult result = _billsResource.getBills();
        final List<BillsDTO> cList = null == result.getBills() ? new ArrayList<BillsDTO>() : result.getBills();
        final List<BillsB> bills = new ArrayList<BillsB>();
        for (BillsDTO dto : cList) {
            bills.add(convertDtoToBean(dto));
        }
        return bills;
    }
}
