package com.sma.delivery.rest.productHasPromotions;

import com.sma.delivery.dto.product_has_promotions.ProductHasPromotionDTO;
import com.sma.delivery.dto.product_has_promotions.ProductHasPromotionResult;
import com.sma.delivery.rest.base.BaseResourceImpl;
import org.springframework.stereotype.Repository;

import java.util.Map;
@Repository("ingredientsProductsResource")
public class ProductHasPromotionsResourceImpl extends BaseResourceImpl<ProductHasPromotionDTO> implements IProductHasPromotionsResource {
    public ProductHasPromotionsResourceImpl() {
        super(ProductHasPromotionDTO.class, "/product-has-promotions");
    }

    @Override
    public ProductHasPromotionResult getAllBy(Map<String, String> args) {
        return getWebResource().path("/promotionId/" +args.get("promotionId")).get(ProductHasPromotionResult.class);
    }
}
