package com.sma.delivery.rest.ingredientsProducts;

import com.sma.delivery.dto.ingredients_products.IngredientsProductsDTO;
import com.sma.delivery.dto.ingredients_products.IngredientsProductsResult;
import com.sma.delivery.rest.base.IBaseResource;
public interface IIngredientsProductsResource  extends IBaseResource<IngredientsProductsDTO>{
    public IngredientsProductsResult find(String text, Integer page);
    public IngredientsProductsResult getAll(Integer page);
    public IngredientsProductsResult getIngredientsProducts();
}