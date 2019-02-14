package com.sma.delivery.service.ingredientsProducts;

import com.sma.delivery.beans.ingredientsProducts.IngredientsProductsB;
import com.sma.delivery.dto.ingredients_products.IngredientsProductsDTO;
import com.sma.delivery.service.base.IBaseService;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface IIngredientsProductsService extends IBaseService<IngredientsProductsB, IngredientsProductsDTO> {
    List<IngredientsProductsB> getIngredientsProducts();
    IngredientsProductsDTO convertBeanToDto(IngredientsProductsB bean);
    Set<IngredientsProductsB> getAllBy(Map<String, String> args);
}