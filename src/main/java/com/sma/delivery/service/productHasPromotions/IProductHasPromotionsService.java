package com.sma.delivery.service.productHasPromotions;

import com.sma.delivery.beans.productHasPromotions.ProductHasPromotionsB;
import com.sma.delivery.dto.product_has_promotions.ProductHasPromotionDTO;
import com.sma.delivery.service.base.IBaseService;

import java.util.Map;
import java.util.Set;

public interface IProductHasPromotionsService extends IBaseService<ProductHasPromotionsB, ProductHasPromotionDTO> {
    Set<ProductHasPromotionsB> getAllBy(Map<String, String> args);
}
