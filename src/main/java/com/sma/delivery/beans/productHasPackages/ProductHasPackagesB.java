package com.sma.delivery.beans.productHasPackages;

import com.sma.delivery.beans.base.BaseBean;
import org.apache.commons.lang.StringUtils;

import java.util.Map;

public class ProductHasPackagesB extends BaseBean {
    private static final long serialVersionUID = 1L;

    Integer cost;
    Integer quantity;
    String  comment;
    Integer product;
    Integer packages;

    public Integer getProduct() {
        return product;
    }

    public void setProduct(Integer product) {
        this.product = product;
    }

    public Integer getPackages() {
        return packages;
    }

    public void setPackages(Integer packages) {
        this.packages = packages;
    }

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

    public ProductHasPackagesB(Map<String, String> params)  {
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
        if(!StringUtils.isBlank(params.get("product")))
            setProduct(Integer.valueOf(params.get("product")));
        if(!StringUtils.isBlank(params.get("promotion")))
            setPackages(Integer.valueOf(params.get("packages")));
        setComment(params.get("comment"));
    }
}
