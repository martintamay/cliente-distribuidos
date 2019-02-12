package com.sma.delivery.rest.ingredients;

import com.sma.delivery.dto.ingredients.IngredientDTO;
import com.sma.delivery.dto.ingredients.IngredientResult;
import com.sma.delivery.rest.base.BaseResourceImpl;
import org.springframework.stereotype.Repository;

@Repository("ingredientsResource")
public class IngredientsResourceImpl extends BaseResourceImpl<IngredientDTO> implements IIngredientsResource {

    public IngredientsResourceImpl() {
        super(IngredientDTO.class, "/ingredients");
    }

    @Override
    public IngredientResult getAll(Integer page) {
        final IngredientResult result = getWebResource().path("/"+page+"/"+20).get(IngredientResult.class);
        return result;
    }

    @Override
    public IngredientDTO getById(Integer id) {
        return getWebResource().path("/" + id).get(getDtoClass());
    }

    @Override
    public IngredientResult find(String text, Integer page) {
        final IngredientResult result = getWebResource().path("/search/"+page+"/"+3+"/"+text).get(IngredientResult.class);
        return result;
    }

    @Override
    public IngredientResult getIngredients() {
        return getWebResource().path("/" + 1 + "/" + 200).get(IngredientResult.class);

    }

}
