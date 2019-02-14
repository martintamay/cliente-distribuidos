package com.sma.delivery.rest.ingredientsProducts;

import com.sma.delivery.dto.ingredients_products.IngredientsProductsDTO;
import com.sma.delivery.dto.ingredients_products.IngredientsProductsResult;
import com.sma.delivery.rest.base.BaseResourceImpl;
import org.springframework.stereotype.Repository;

@Repository("ingredientsProductsResource")
public class IngredientsProductsResourceImpl extends BaseResourceImpl<IngredientsProductsDTO> implements IIngredientsProductsResource {

    public IngredientsProductsResourceImpl() {
        super(IngredientsProductsDTO.class, "/ingredients-products");
    }

    @Override
    public IngredientsProductsResult getAll(Integer page) {
        final IngredientsProductsResult result = getWebResource().path("/"+page+"/"+20).get(IngredientsProductsResult.class);
        return result;
    }

    @Override
    public IngredientsProductsResult find(String text, Integer page) {
        final IngredientsProductsResult result = getWebResource().path("/search/"+page+"/"+3+"/"+text).get(IngredientsProductsResult.class);
        return result;
    }

    @Override
    public IngredientsProductsResult getIngredientsProducts() {
        return getWebResource().path("/" + 1 + "/" + 200).get(IngredientsProductsResult.class);

    }

}