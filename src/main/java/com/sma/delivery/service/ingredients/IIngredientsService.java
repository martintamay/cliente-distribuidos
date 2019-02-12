package com.sma.delivery.service.ingredients;

import com.sma.delivery.beans.ingredients.IngredientsB;
import com.sma.delivery.dto.ingredients.IngredientDTO;
import com.sma.delivery.service.base.IBaseService;

import java.util.List;

public interface IIngredientsService extends IBaseService<IngredientsB, IngredientDTO> {
    public List<IngredientsB> getIngredients();
}
