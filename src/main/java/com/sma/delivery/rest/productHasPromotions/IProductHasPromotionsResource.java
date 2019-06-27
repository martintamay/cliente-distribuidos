package com.sma.delivery.rest.productHasPromotions;

import com.sma.delivery.dto.product_has_promotions.ProductHasPromotionDTO;
import com.sma.delivery.dto.product_has_promotions.ProductHasPromotionResult;
import com.sma.delivery.rest.base.IBaseResource;

import java.util.Map;

public interface IProductHasPromotionsResource extends IBaseResource<ProductHasPromotionDTO> {
    public ProductHasPromotionResult getAllBy(Map<String, String> args);
}
