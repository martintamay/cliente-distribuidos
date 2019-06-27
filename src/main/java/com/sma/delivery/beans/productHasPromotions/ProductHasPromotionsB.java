package com.sma.delivery.beans.productHasPromotions;

import com.sma.delivery.beans.base.BaseBean;
import com.sma.delivery.beans.products.ProductsB;
import com.sma.delivery.beans.promotions.PromotionsB;
import org.apache.commons.lang.StringUtils;

import java.util.Map;
import java.util.Set;

public class ProductHasPromotionsB extends BaseBean {
    private static final long serialVersionUID = 1L;

    Integer cost;
    Integer quantity;
    String  comment;
    ProductsB product;
    PromotionsB promotion;
    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public ProductsB getProduct() {
        return product;
    }

    public void setProduct(ProductsB product) {
        this.product = product;
    }

    public PromotionsB getPromotion() {
        return promotion;
    }

    public void setPromotion(PromotionsB promotion) {
        this.promotion = promotion;
    }

    public ProductHasPromotionsB(Map<String, String> params)  {
        super(params);
    }

    @Override
    protected void create(Map<String, String> params)  {
        if (!StringUtils.isBlank(params.get("id"))) {
            setId(Integer.valueOf(params.get("id")));
        }
        if(!StringUtils.isBlank(params.get("cost")))
            setCost(Integer.valueOf(params.get("cost")));
        if(!StringUtils.isBlank(params.get("quantity")))
            setQuantity(Integer.valueOf(params.get("quantity")));
        setComment(params.get("comments"));
    }
}
