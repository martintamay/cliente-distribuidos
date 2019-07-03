package com.sma.delivery.beans.orderDetails;

import com.sma.delivery.beans.base.BaseBean;
import com.sma.delivery.beans.order.OrderB;
import com.sma.delivery.beans.packages.PackagesB;
import com.sma.delivery.beans.products.ProductsB;
import com.sma.delivery.beans.promotions.PromotionsB;
import org.apache.commons.lang.StringUtils;

import java.util.Map;

public class OrdersDetailsB extends BaseBean{
    private static final long serialVersionUID = 1L;

    private String comment;
    private Integer quantity;
    private Integer cost;

    private PackagesB packageB;
    private ProductsB product;
    private PromotionsB promotion;
    private OrderB order;

    public OrderB getOrder() {
        return order;
    }

    public void setOrder(OrderB order) {
        this.order = order;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer cuantity) {
        this.quantity = cuantity;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public PackagesB getPackageB() {
        return packageB;
    }

    public void setPackageB(PackagesB packageB) {
        this.packageB = packageB;
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

    public OrdersDetailsB(Map<String, String> params)  {
        super(params);
    }
    @Override
    protected void create(Map<String, String> params) {
        if (!StringUtils.isBlank(params.get("id"))) {
            setId(Integer.valueOf(params.get("id")));
        }
        if (!StringUtils.isBlank(params.get("comment"))) {
            setComment(params.get("comment"));
        }
        if (!StringUtils.isBlank(params.get("cost"))) {
            setCost(Integer.valueOf(params.get("cost")));
        }
        if (!StringUtils.isBlank(params.get("quantity"))) {
            setQuantity(Integer.valueOf(params.get("quantity")));
        }


    }

}

