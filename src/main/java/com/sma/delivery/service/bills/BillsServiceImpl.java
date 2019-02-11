package com.sma.delivery.service.bills;

import com.sma.delivery.beans.bills.BillsB;
import com.sma.delivery.dto.bills.BillDTO;
import com.sma.delivery.dto.bills.BillResult;
import com.sma.delivery.service.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sma.delivery.rest.bills.IBillsResource;
import com.sma.delivery.service.order.IOrderService;


import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("billsService")
public class BillsServiceImpl extends BaseServiceImpl<BillsB, BillDTO> implements IBillsService {

    @Autowired
    private IBillsResource _billsResource;

    @Autowired
    private IOrderService _orderService;
    public BillsServiceImpl() {
    }

    @Override
    public BillsB save(BillsB bean)  {
        final BillDTO bills = convertBeanToDto(bean);
        final BillDTO dto = _billsResource.save(bills);

        final BillsB billsB = convertDtoToBean(dto);
        return billsB;
    }

    @Override
    public void delete(Integer id){
        _billsResource.delete(id);
    }

    @Override
    public List<BillsB> getAll(Integer page)  {
        final BillResult result = _billsResource.getAll(page);
        final List<BillDTO> cList = null == result.getBills() ? new ArrayList<BillDTO>()
                : result.getBills();

        final List<BillsB> bills = new ArrayList<BillsB>();
        for (BillDTO dto : cList) {
            final BillsB bean = convertDtoToBean(dto);
            bills.add(bean);
        }
        return bills;
    }
    @Override
    public BillsB getById(Integer id)  {
        final BillDTO dto = _billsResource.getById(id);
        final BillsB bean = convertDtoToBean(dto);

        return bean;
    }

    @Override
    public List<BillsB> find(String text, Integer page)  {

        final BillResult result = _billsResource.find(text, page);
        final List<BillDTO> cList = null == result.getBills() ? new ArrayList<BillDTO>()
                : result.getBills();

        final List<BillsB> bills = new ArrayList<BillsB>();
        for (BillDTO dto : cList) {
            final BillsB bean = convertDtoToBean(dto);
            bills.add(bean);
        }
        return bills;
    }

    @Override
    protected BillsB convertDtoToBean(BillDTO dto)  {
        final Map<String, String> params = new HashMap<String, String>();
        params.put("id", String.valueOf(dto.getId()));
        params.put("total", dto.getTotal());
        params.put("iva10", String.valueOf(dto.getIva()));

        final BillsB billsB = new BillsB(params);

        billsB.setOrder(_orderService.getById(dto.getOrderId()));
        return billsB;
    }

    @Override
    protected BillDTO convertBeanToDto(BillsB bean) {
        final BillDTO dto = new BillDTO();
        dto.setId(bean.getId());
        dto.setTotal(bean.getTotal());
        dto.setIva(bean.getIva10());
        dto.setOrderId(bean.getOrder().getId());

        return dto;
    }

    @Override
    public List<BillsB> getBills()  {
        final BillResult result = _billsResource.getBills();
        final List<BillDTO> cList = null == result.getBills() ? new ArrayList<BillDTO>() : result.getBills();
        final List<BillsB> bills = new ArrayList<BillsB>();
        for (BillDTO dto : cList) {
            bills.add(convertDtoToBean(dto));
        }
        return bills;
    }
}
