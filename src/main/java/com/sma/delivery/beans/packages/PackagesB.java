package com.sma.delivery.beans.packages;

import com.sma.delivery.beans.base.BaseBean;
import org.apache.commons.lang.StringUtils;

import java.text.ParseException;
import java.util.Map;

public class PackagesB extends BaseBean {
    private static final long serialVersionUID = 1L;
    private String name;
    private Integer cost;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public PackagesB(Map<String, String> params)  {
        super(params);
    }

    @Override
    protected void create(Map<String, String> params) {
        if (!StringUtils.isBlank(params.get("id"))) {
            setId(Integer.valueOf(params.get("id")));
        }
        setName(params.get("name"));

        if (!StringUtils.isBlank(params.get("cost"))) {
            setCost(Integer.valueOf(params.get("cost")));
        }




    }

}


