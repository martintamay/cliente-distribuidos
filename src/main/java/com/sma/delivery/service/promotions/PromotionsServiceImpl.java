package com.sma.delivery.service.promotions;


import com.sma.delivery.beans.promotions.PromotionsB;
import com.sma.delivery.dto.promotions.PromotionDTO;
import com.sma.delivery.dto.promotions.PromotionResult;
import com.sma.delivery.service.base.BaseServiceImpl;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sma.delivery.rest.promotions.IPromotionsResource;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("promotionsService")
public class PromotionsServiceImpl extends BaseServiceImpl<PromotionsB, PromotionDTO> implements IPromotionsService {

    @Autowired
    private  IPromotionsResource promotionsResource;

    public PromotionsServiceImpl() {
    }

    @Override
    public PromotionsB save(PromotionsB bean)  {
        final PromotionDTO promotions = convertBeanToDto(bean);
        final PromotionDTO dto = promotionsResource.save(promotions);
        final PromotionsB promotionsB = convertDtoToBean(dto);
        return promotionsB;
    }

    @Override
    public void delete(Integer id){
        promotionsResource.delete(id);
    }
    @Override
    public List<PromotionsB> find(String text, Integer page)  {
        final PromotionResult result = promotionsResource.find(text, page);
        final List<PromotionDTO> cList = null == result.getPromotions() ? new ArrayList<PromotionDTO>()
                : result.getPromotions();

        final List<PromotionsB> promotions = new ArrayList<PromotionsB>();
        for (PromotionDTO dto : cList) {
            final PromotionsB bean = convertDtoToBean(dto);
            promotions.add(bean);
        }
        return promotions;
    }

    @Override
    public List<PromotionsB> getAll(Integer page)  {
        final PromotionResult result = promotionsResource.getAll(page);
        final List<PromotionDTO> cList = null == result.getPromotions() ? new ArrayList<PromotionDTO>()
                : result.getPromotions();

        final List<PromotionsB> promotions = new ArrayList<PromotionsB>();
        for (PromotionDTO dto : cList) {
            final PromotionsB bean = convertDtoToBean(dto);
            promotions.add(bean);
        }
        return promotions;
    }

    @Override
    public PromotionsB getById(Integer id)  {
        final PromotionDTO dto = promotionsResource.getById(id);
        final PromotionsB bean = convertDtoToBean(dto);

        return bean;
    }

    @Override
    protected PromotionsB convertDtoToBean(PromotionDTO dto)  {
        final Map<String, String> params = new HashMap<String, String>();
        params.put("id", String.valueOf(dto.getId()));
        params.put("name", String.valueOf(dto.getName()));
        params.put("available", String.valueOf(dto.getAvailable()));
        params.put("end_date", String.valueOf(dto.getEndDate()));


        final PromotionsB promotionsB = new PromotionsB(params);

        return promotionsB;
    }

    @Override
    protected PromotionDTO convertBeanToDto(PromotionsB bean)  {
        final PromotionDTO dto = new PromotionDTO();

        dto.setId(bean.getId());
        dto.setName(bean.getName());
        dto.setEndDate((Time) bean.getEnd_date());
        dto.setAvailable(bean.getAvailable());
        return dto;
    }

    @Override
    public List<PromotionsB> getPromotions()  {
        final PromotionResult result = promotionsResource.getPromotions();
        final List<PromotionDTO> cList = null == result.getPromotions() ? new ArrayList<PromotionDTO>() : result.getPromotions();
        final List<PromotionsB> promotions = new ArrayList<PromotionsB>();
        for (PromotionDTO dto : cList) {
            promotions.add(convertDtoToBean(dto));
        }
        return promotions;
    }
}
