package com.sma.delivery.rest.promotions;


import com.sma.delivery.dto.promotions.PromotionDTO;
import com.sma.delivery.dto.promotions.PromotionResult;
import com.sma.delivery.rest.base.IBaseResource;

public interface IPromotionsResource extends IBaseResource<PromotionDTO>{
    public PromotionResult find(String text, Integer page);
    public PromotionResult getAll(Integer page);
    public PromotionResult getPromotions();
}
