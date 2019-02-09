package com.sma.delivery.beans.promotions;


import com.sma.delivery.beans.base.BaseBean;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;

import java.sql.Time;
import java.util.Date;
import java.util.Map;

public class PromotionsB extends BaseBean {
    private static final long serialVersionUID = 1L;

    String name;
    String available;
    Time end_date;

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

    public Time getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Time end_date) {
        this.end_date = end_date;
    }

    public PromotionsB(Map<String, String> params) {
        super(params);
    }

    @Override
    protected void create(Map<String, String> params) {
        if (!StringUtils.isBlank(params.get("id"))) {
            setId(Integer.valueOf(params.get("id")));

        }
        if (!StringUtils.isBlank(params.get("end_date"))) {
            setEnd_date(Time.valueOf(params.get("end_date")));

        }

            setAvailable(params.get("available"));
            setName(params.get("name"));
        }

    }
