package com.sma.delivery.beans.ingredientsProducts;

import org.apache.commons.lang.StringUtils;
import com.sma.delivery.beans.base.BaseBean;
import java.util.Map;

public class IngredientsProductsB extends BaseBean {
    private static final long serialVersionUID = 1L;

    public Integer getProduct() {
        return product;
    }

    public void setProduct(Integer product) {
        this.product = product;
    }

    public Integer getIngredient() {
        return ingredient;
    }

    public void setIngredient(Integer ingredient) {
        this.ingredient = ingredient;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }


    Integer amount;
    Integer ingredient;
    Integer product;
    public IngredientsProductsB(Map<String, String> params)  {
        super(params);
    }
    @Override
    protected void create(Map<String, String> params) {
        if (!StringUtils.isBlank(params.get("id"))) {
            setId(Integer.valueOf(params.get("id")));
        }

        if (!StringUtils.isBlank(params.get("amount"))) {
            setId(Integer.valueOf(params.get("amount")));
        }

        if (!StringUtils.isBlank(params.get("product"))) {
            setId(Integer.valueOf(params.get("product")));
        }

        if (!StringUtils.isBlank(params.get("ingredient"))) {
            setId(Integer.valueOf(params.get("ingredient")));
        }

    }

}

