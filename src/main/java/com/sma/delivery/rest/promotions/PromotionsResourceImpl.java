package com.sma.delivery.rest.promotions;
import com.sma.delivery.dto.promotions.PromotionResult;
import com.sma.delivery.dto.promotions.PromotionDTO;
import com.sma.delivery.rest.base.BaseResourceImpl;
import org.springframework.stereotype.Repository;
@Repository("promotionsResource")
public class PromotionsResourceImpl extends BaseResourceImpl<PromotionDTO> implements IPromotionsResource {

    public PromotionsResourceImpl() {
        super(PromotionDTO.class, "/promotions");
    }

    @Override
    public PromotionResult getAll(Integer page) {
        setWebResourceBasicAuthFilter();
        final PromotionResult result = getWebResource().path("/"+page+"/"+20).get(PromotionResult.class);
        return result;
    }

    @Override
    public PromotionResult find(String text, Integer page) {
        final PromotionResult result = getWebResource().path("/search/"+page+"/"+3+"/"+text).get(PromotionResult.class);
        return result;
    }

    @Override
    public PromotionResult getPromotions() {
        return getWebResource().path("/" + 1 + "/" + 200).get(PromotionResult.class);

    }

}

