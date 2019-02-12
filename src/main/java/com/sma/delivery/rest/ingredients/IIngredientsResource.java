package com.sma.delivery.rest.ingredients;

import com.sma.delivery.dto.ingredients.IngredientDTO;
import com.sma.delivery.dto.ingredients.IngredientResult;
import com.sma.delivery.rest.base.IBaseResource;
public interface IIngredientsResource  extends IBaseResource<IngredientDTO>{
    public IngredientResult find(String text, Integer page);
    public IngredientResult getAll(Integer page);
    public IngredientResult getIngredients();
}
