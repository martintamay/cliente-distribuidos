package com.sma.delivery.beans.promotions;


import com.sma.delivery.beans.base.BaseBean;
import com.sma.delivery.beans.productHasPromotions.ProductHasPromotionsB;
import org.apache.commons.lang.StringUtils;

import java.sql.Date;
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
        if (!StringUtils.isBlank(params.get("id"))) {
            setId(Integer.valueOf(params.get("id")));
        }
        if(!StringUtils.isBlank(params.get("end_date")))
        setEnd_date(Date.valueOf(params.get("end_date")));
        setAvailable(params.get("available"));
        setName(params.get("name"));

    }
}
