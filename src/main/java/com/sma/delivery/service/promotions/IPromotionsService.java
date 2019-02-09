package com.sma.delivery.service.promotions;

import com.sma.delivery.beans.promotions.PromotionsB;
import com.sma.delivery.beans.promotions.PromotionsB;
import com.sma.delivery.dto.promotions.PromotionsDTO;
import com.sma.delivery.service.base.IBaseService;

import java.util.List;

public interface IPromotionsService extends IBaseService<PromotionsB, PromotionsDTO> {
    public List<PromotionsB> getPromotions();
}
