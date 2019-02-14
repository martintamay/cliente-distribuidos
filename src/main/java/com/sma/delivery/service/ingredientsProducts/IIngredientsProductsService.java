package com.sma.delivery.service.ingredientsProducts;

import com.sma.delivery.beans.ingredientsProducts.IngredientsProductsB;
import com.sma.delivery.dto.ingredients_products.IngredientsProductsDTO;
import com.sma.delivery.service.base.IBaseService;

import java.util.List;

public interface IIngredientsProductsService extends IBaseService<IngredientsProductsB, IngredientsProductsDTO> {
    public List<IngredientsProductsB> getIngredientsProducts();
}