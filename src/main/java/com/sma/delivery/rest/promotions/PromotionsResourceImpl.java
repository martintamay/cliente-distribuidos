package com.sma.delivery.rest.promotions;
import com.sma.delivery.dto.promotions.PromotionsResult;
import com.sma.delivery.dto.promotions.PromotionsDTO;
import com.sma.delivery.rest.base.BaseResourceImpl;
import org.springframework.stereotype.Repository;
@Repository("promotionsResource")
public class PromotionsResourceImpl extends BaseResourceImpl<PromotionsDTO> implements IPromotionsResource {

    public PromotionsResourceImpl() {
        super(PromotionsDTO.class, "/promotions");
    }

    @Override
    public PromotionsResult getAll(Integer page) {
        setWebResourceBasicAuthFilter();
        final PromotionsResult result = getWebResource().path("/"+page+"/"+20).get(PromotionsResult.class);
        return result;
    }

    @Override
    public PromotionsResult find(String text, Integer page) {
        final PromotionsResult result = getWebResource().path("/search/"+page+"/"+3+"/"+text).get(PromotionsResult.class);
        return result;
    }

    @Override
    public PromotionsResult getPromotions() {
        return getWebResource().path("/" + 1 + "/" + 200).get(PromotionsResult.class);

    }

}

