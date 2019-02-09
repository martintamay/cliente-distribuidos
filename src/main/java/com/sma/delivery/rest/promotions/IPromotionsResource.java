package com.sma.delivery.rest.promotions;


import com.sma.delivery.dto.promotions.PromotionsDTO;
import com.sma.delivery.dto.promotions.PromotionsResult;
import com.sma.delivery.rest.base.IBaseResource;

public interface IPromotionsResource extends IBaseResource<PromotionsDTO>{
    public PromotionsResult find(String text, Integer page);
    public PromotionsResult getAll(Integer page);
    public PromotionsResult getPromotions();
}
