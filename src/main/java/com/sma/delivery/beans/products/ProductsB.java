package com.sma.delivery.beans.products;

import com.sma.delivery.beans.base.BaseBean;
import com.sma.delivery.beans.establishments.EstablishmentsB;
import org.apache.commons.lang.StringUtils;

import java.util.Map;

public class ProductsB extends BaseBean {
    private static final long serialVersionUID = 1L;
    private String name;
    private String description;
    private EstablishmentsB establishments;
    private Integer cost;

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










    public ProductsB(Map<String, String> params) {
        super(params);
    }
    @Override
    protected void create(Map<String, String> params) {
        if (!StringUtils.isBlank(params.get("id"))) {
            setId(Integer.valueOf(params.get("id")));
        }

        setName(params.get("name"));
        setDescription (params.get("description"));
        setCost(0);


    }

}


