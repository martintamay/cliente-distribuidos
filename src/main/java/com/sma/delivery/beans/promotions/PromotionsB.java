package com.sma.delivery.beans.promotions;


import com.sma.delivery.beans.base.BaseBean;
import com.sma.delivery.beans.productHasPromotions.ProductHasPromotionsB;
import org.apache.commons.lang.StringUtils;
import org.grails.web.json.JSONArray;
import org.grails.web.json.JSONObject;

import java.sql.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PromotionsB extends BaseBean {
    private static final long serialVersionUID = 1L;

    String name;
    String available;
    Date end_date;
    private Set<ProductHasPromotionsB> productHasPromotions;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

    public Date getEnd_date() {
        return end_date;
    }
    public Set<ProductHasPromotionsB> getProductHasPromotions() {
        return productHasPromotions;
    }

    public void setProductHasPromotions(Set<ProductHasPromotionsB> productHasPromotions) {
        this.productHasPromotions = productHasPromotions;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public PromotionsB(Map<String, String> params)  {
        super(params);
    }

    @Override
    protected void create(Map<String, String> params)  {
        if(params.get("promotion")!=null) {
            JSONObject json = new JSONObject(params.get("promotion"));
            Set<ProductHasPromotionsB> b = new HashSet<>();
            if(json.containsKey("productsHasPromotions")) {
                JSONArray jsonArray = new JSONArray(json.getString("productsHasPromotions"));
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject a = (JSONObject) jsonArray.get(i);
                    Map<String, String> p = new HashMap<>();
                    if(a.containsKey("id"))
                        p.put("id", a.getString("id"));
                    p.put("product", a.getString("product"));
                    p.put("comment", a.getString("comment"));
                    p.put("quantity", a.getString("quantity"));
                    p.put("cost", a.getString("cost"));
                    ProductHasPromotionsB detailsB = new ProductHasPromotionsB(p);
                    b.add(detailsB);
                }
            }
            System.out.println("length --------"+b.size());
            setProductHasPromotions(b);
            JSONObject promotion = new JSONObject(json.getString("promotion"));
            if(promotion.containsKey("id"))
                setId(Integer.valueOf(promotion.getString("id")));
            setAvailable(promotion.getString("available"));
            setEnd_date(Date.valueOf(promotion.getString("end_date")));
            setName(promotion.getString("name"));
        }

    }
}
