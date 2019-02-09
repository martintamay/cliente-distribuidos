package com.sma.delivery.service.promotions;


import com.sma.delivery.beans.promotions.PromotionsB;
import com.sma.delivery.dto.promotions.PromotionsDTO;
import com.sma.delivery.dto.promotions.PromotionsResult;
import com.sma.delivery.service.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sma.delivery.rest.promotions.IPromotionsResource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("promotionsService")
public class PromotionsServiceImpl extends BaseServiceImpl<PromotionsB, PromotionsDTO> implements IPromotionsService {

    @Autowired
    private  IPromotionsResource promotionsResource;

    public PromotionsServiceImpl() {
    }

    @Override
    public PromotionsB save(PromotionsB bean) {
        final PromotionsDTO promotions = convertBeanToDto(bean);
        final PromotionsDTO dto = promotionsResource.save(promotions);
        final PromotionsB promotionsB = convertDtoToBean(dto);
        return promotionsB;
    }

    @Override
    public void delete(Integer id){
        promotionsResource.delete(id);
    }
    @Override
    public List<PromotionsB> find(String text, Integer page) {
        final PromotionsResult result = promotionsResource.find(text, page);
        final List<PromotionsDTO> cList = null == result.getPromotions() ? new ArrayList<PromotionsDTO>()
                : result.getPromotions();

        final List<PromotionsB> promotions = new ArrayList<PromotionsB>();
        for (PromotionsDTO dto : cList) {
            final PromotionsB bean = convertDtoToBean(dto);
            promotions.add(bean);
        }
        return promotions;
    }

    @Override
    public List<PromotionsB> getAll(Integer page) {
        final PromotionsResult result = promotionsResource.getAll(page);
        final List<PromotionsDTO> cList = null == result.getPromotions() ? new ArrayList<PromotionsDTO>()
                : result.getPromotions();

        final List<PromotionsB> promotions = new ArrayList<PromotionsB>();
        for (PromotionsDTO dto : cList) {
            final PromotionsB bean = convertDtoToBean(dto);
            promotions.add(bean);
        }
        return promotions;
    }

    @Override
    public PromotionsB getById(Integer id) {
        final PromotionsDTO dto = promotionsResource.getById(id);
        final PromotionsB bean = convertDtoToBean(dto);

        return bean;
    }

    @Override
    protected PromotionsB convertDtoToBean(PromotionsDTO dto) {
        final Map<String, String> params = new HashMap<String, String>();
        params.put("id", String.valueOf(dto.getId()));
        params.put("name", String.valueOf(dto.getName()));
        params.put("available", String.valueOf(dto.getAvailable()));
        params.put("end_date", String.valueOf(dto.getEnd_date()));


        final PromotionsB promotionsB = new PromotionsB(params);

        return promotionsB;
    }

    @Override
    protected PromotionsDTO convertBeanToDto(PromotionsB bean) {
        final PromotionsDTO dto = new PromotionsDTO();
        dto.setId(bean.getId());
        dto.setName(bean.getName());
        dto.setEnd_date(bean.getEnd_date());
        dto.setAvailable(bean.getAvailable());
        return dto;
    }

    @Override
    public List<PromotionsB> getPromotions() {
        final PromotionsResult result = promotionsResource.getPromotions();
        final List<PromotionsDTO> cList = null == result.getPromotions() ? new ArrayList<PromotionsDTO>() : result.getPromotions();
        final List<PromotionsB> promotions = new ArrayList<PromotionsB>();
        for (PromotionsDTO dto : cList) {
            promotions.add(convertDtoToBean(dto));
        }
        return promotions;
    }
}
