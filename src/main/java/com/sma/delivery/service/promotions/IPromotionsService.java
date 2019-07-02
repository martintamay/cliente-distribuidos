package com.sma.delivery.service.promotions;

import com.sma.delivery.beans.promotions.PromotionsB;
import com.sma.delivery.dto.promotions.PromotionDTO;
import com.sma.delivery.service.base.IBaseService;

import java.text.ParseException;
import java.util.List;

public interface IPromotionsService extends IBaseService<PromotionsB, PromotionDTO> {
    List<PromotionsB> getPromotions() throws ParseException;
}
