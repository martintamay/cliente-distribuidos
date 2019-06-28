package com.sma.delivery.beans.products;

import com.sma.delivery.beans.base.BaseBean;
import com.sma.delivery.beans.establishments.EstablishmentsB;
import com.sma.delivery.beans.ingredientsProducts.IngredientsProductsB;
import org.grails.web.json.JSONArray;
import org.grails.web.json.JSONObject;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ProductsB extends BaseBean {
    private static final long serialVersionUID = 1L;
    private String name;
    private String description;
    private EstablishmentsB establishments;
    private Integer cost;

    private Set<IngredientsProductsB> ingredientsProducts;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EstablishmentsB getEstablishments() {
        return establishments;
    }

    public void setEstablishments(EstablishmentsB establishments) {
        this.establishments = establishments;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public Set<IngredientsProductsB> getIngredientsProducts() {
        return ingredientsProducts;
    }

    public void setIngredientsProducts(Set<IngredientsProductsB> ingredientsProducts) {
        this.ingredientsProducts = ingredientsProducts;
    }

    public ProductsB(Map<String, String> params)  {
        super(params);
    }
    @Override
    protected void create(Map<String, String> params) {
        if(params.get("product")!=null) {
            JSONObject json = new JSONObject(params.get("product"));
            Set<IngredientsProductsB> ingProductsB= new HashSet<>();
            if(json.containsKey("IngredientsProducts")) {
                JSONArray jsonArray = new JSONArray(json.getString("IngredientsProducts"));
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject a = (JSONObject) jsonArray.get(i);
                    Map<String, String> p = new HashMap<>();
                    if(a.containsKey("id"))
                        p.put("id", a.getString("id"));
                    p.put("ingredient", a.getString("ingredient"));
                    p.put("amount", a.getString("amount"));
                    IngredientsProductsB detailsB = new IngredientsProductsB(p);
                    ingProductsB.add(detailsB);
                }
            }
            setIngredientsProducts(ingProductsB);
            JSONObject product = new JSONObject(json.getString("Product"));
            if(product.containsKey("id"))
                setId(Integer.valueOf(product.getString("id")));
            setName(product.getString("name"));
            setDescription(product.getString("description"));
            setCost(Integer.valueOf(product.getString("cost")));
        }
    }

}


