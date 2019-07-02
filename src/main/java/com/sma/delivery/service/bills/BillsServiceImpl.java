package com.sma.delivery.service.bills;

import com.sma.delivery.beans.bills.BillsB;
import com.sma.delivery.beans.billsDetails.BillsDetailsB;
import com.sma.delivery.dto.bills.BillDTO;
import com.sma.delivery.dto.bills.BillResult;
import com.sma.delivery.dto.bills_details.BillDetailDTO;
import com.sma.delivery.rest.bills.IBillsResource;
import com.sma.delivery.service.base.BaseServiceImpl;
import com.sma.delivery.service.billsDetails.IBillsDetailsService;
import com.sma.delivery.service.order.IOrderService;
import org.grails.web.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


import java.util.*;

@Service("billsService")
public class BillsServiceImpl extends BaseServiceImpl<BillsB, BillDTO> implements IBillsService {

    @Autowired
    private IBillsResource _billsResource;

    @Autowired
    private IOrderService _orderService;

    @Autowired
    private IBillsDetailsService _billsDetailsService;
    public BillsServiceImpl() {
    }

    @Override
    public BillsB save(BillsB bean)  {
        final BillDTO bills = convertBeanToDto(bean);
        final BillDTO dto = _billsResource.save(bills);
        final BillsB billsB = convertDtoToBean(dto);
        if (bean.getId() == null) {
        }
        return billsB;
    }

    @Override
    @CacheEvict(value= "delivery-cacheC", key="'billsClients_'+#id")
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
            if (bean.getId() != null) {
                getCacheManager().getCache("delivery-cacheC").put("billsClients_" + dto.getId(), bean);
            }
        }
        return bills;
    }
    @Override
    @Cacheable(value="delivery-cacheC", key= "'billsClients_'+#id")
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
            if (bean.getId() != null) {
                getCacheManager().getCache("delivery-cacheC").put("billsC_" + bean.getId(), bean);
            }
        }
        return bills;
    }

    @Override
    protected BillsB convertDtoToBean(BillDTO dto) {
        final Map<String, String> params = new HashMap<String, String>();
        JSONObject bills = new JSONObject();
        bills.put("id",String.valueOf(dto.getId()));
        bills.put("total",String.valueOf(dto.getTotal()));
        bills.put("iva10", String.valueOf(dto.getIva10()));
        bills.put("ruc",String.valueOf(dto.getRuc()));
        bills.put("timbrado",String.valueOf(dto.getTimbrado()));
        bills.put("nombre", String.valueOf(dto.getNombre()));
        bills.put("fecha", String.valueOf(dto.getFecha()));
        bills.put("num1", String.valueOf(dto.getNum1()));
        bills.put("num2", String.valueOf(dto.getNum2()));
        bills.put("num3", String.valueOf(dto.getNum3()));
        bills.put("direccion", String.valueOf(dto.getDireccion()));

        JSONObject billsParams = new JSONObject();
        billsParams.put("bill",bills);
        List<JSONObject> details = new ArrayList<>();
        for (BillDetailDTO detailsB: dto.getBillsDetails()){
            JSONObject tmp = new JSONObject();
            tmp.put("id",detailsB.getId());
            tmp.put("iva10", detailsB.getIva10());
            tmp.put("amount",detailsB.getAmount());

            details.add(tmp);
        }
        billsParams.put("BillsDetails",details.toString());
        params.put("bill",billsParams.toString());
        final BillsB billsB = new BillsB(params);
        billsB.setOrder(_orderService.getById(dto.getOrderId()));
        return billsB;
    }

    @Override
    protected BillDTO convertBeanToDto(BillsB bean) {
        final BillDTO dto = new BillDTO();

        dto.setId(bean.getId());
        dto.setTotal(bean.getTotal());
        dto.setIva10(bean.getIva10());
        dto.setOrderId(bean.getOrder().getId());
        dto.setRuc(bean.getRuc());
        dto.setTimbrado(bean.getTimbrado());
        dto.setNum1(bean.getNum1());
        dto.setNum2(bean.getNum2());
        dto.setNum3(bean.getNum3());
        dto.setNombre(bean.getNombre());
        dto.setFecha(bean.getFecha());
        dto.setDireccion(bean.getDireccion());
        Set<BillDetailDTO> detailsDTO = new HashSet<>();
        for(BillsDetailsB detailsB: bean.getBillsDetails()){
            detailsDTO.add(_billsDetailsService.convertBeanToDto(detailsB));
        }
        dto.setBillsDetails(detailsDTO);
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
