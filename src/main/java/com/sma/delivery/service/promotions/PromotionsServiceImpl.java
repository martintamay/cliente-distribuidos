package com.sma.delivery.service.promotions;


import com.sma.delivery.beans.productHasPromotions.ProductHasPromotionsB;
import com.sma.delivery.beans.promotions.PromotionsB;
import com.sma.delivery.dto.product_has_promotions.ProductHasPromotionDTO;
import com.sma.delivery.dto.promotions.PromotionDTO;
import com.sma.delivery.dto.promotions.PromotionResult;
import com.sma.delivery.rest.promotions.IPromotionsResource;
import com.sma.delivery.service.base.BaseServiceImpl;
import com.sma.delivery.service.productHasPromotions.IProductHasPromotionsService;
import org.grails.web.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("promotionsService")
public class PromotionsServiceImpl extends BaseServiceImpl<PromotionsB, PromotionDTO> implements IPromotionsService {

    @Autowired
    private IPromotionsResource promotionsResource;
    @Autowired
    private IProductHasPromotionsService _productHasPromotionsService;
    public PromotionsServiceImpl() {
    }

    @Override
    @CachePut(value="delivery-cacheC", key= "'promotionsClients_'+#bean.id", condition = "#bean.id!=null")
    public PromotionsB save(PromotionsB bean)  {
        final PromotionDTO promotions = convertBeanToDto(bean);
        final PromotionDTO dto = promotionsResource.save(promotions);
        final PromotionsB promotionsB = convertDtoToBean(dto);
        if (bean.getId() == null) {
            getCacheManager().getCache("delivery-cacheC").put("promotionsClients_" + dto.getId(), promotionsB);
        }
        return promotionsB;
    }

    @Override
    @CacheEvict(value = "delivery-cacheC", key = "'promotionsClients_' + #id")
    public void delete(Integer id){
        promotionsResource.delete(id);
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
            if (bean.getId() != null) {
                getCacheManager().getCache("delivery-cacheC").put("promotionsClients_" + bean.getId(), bean);
            }
        }
        return promotions;
    }
    public List<PromotionsB> find(String text, Integer page)  {
        final PromotionResult result = promotionsResource.find(text, page);
        final List<PromotionDTO> cList = null == result.getPromotions() ? new ArrayList<PromotionDTO>()
                : result.getPromotions();

        final List<PromotionsB> promotion = new ArrayList<PromotionsB>();
        for (PromotionDTO dto : cList) {
            final PromotionsB bean = convertDtoToBean(dto);
            promotion.add(bean);
            if (bean.getId() != null) {
                getCacheManager().getCache("delivery-cacheC").put("promotionsClients_" + bean.getId(), bean);
            }
        }
        return promotion;
    }
    @Override
    @Cacheable(value= "delivery-cacheC", key= "'promotionsClients_'+#id")
    public PromotionsB getById(Integer id)  {
        final PromotionDTO dto = promotionsResource.getById(id);
        final PromotionsB bean = convertDtoToBean(dto);

        return bean;
    }

    @Override
    protected PromotionsB convertDtoToBean(PromotionDTO dto)  {
        final Map<String, String> params = new HashMap<String, String>();
        JSONObject promotion = new JSONObject();
        promotion.put("id", String.valueOf(dto.getId()));
        promotion.put("name", String.valueOf(dto.getName()));
        promotion.put("available", String.valueOf(dto.getAvailable()));
        promotion.put("end_date", String.valueOf(dto.getEndDate()));
        JSONObject promotionParams = new JSONObject();
        promotionParams.put("promotion",promotion);
        params.put("promotion",promotionParams.toString());
        final PromotionsB promotionB = new PromotionsB(params);
        return promotionB;
    }

    @Override
    protected PromotionDTO convertBeanToDto(PromotionsB bean)  {
        final PromotionDTO dto = new PromotionDTO();
        dto.setId(bean.getId());
        dto.setName(bean.getName());
        dto.setEndDate( bean.getEnd_date().toString());
        dto.setAvailable(bean.getAvailable());
        List<ProductHasPromotionDTO> productHasPromotionsDTO = new ArrayList<>();
        for(ProductHasPromotionsB productsHasPromotionB: bean.getProductHasPromotions()){
            productHasPromotionsDTO.add(_productHasPromotionsService.convertBeanToDto(productsHasPromotionB));
        }
        dto.setProductHasPromotionsDTO(productHasPromotionsDTO);
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
