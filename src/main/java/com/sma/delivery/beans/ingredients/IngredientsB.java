package com.sma.delivery.beans.ingredients;

import org.apache.commons.lang.StringUtils;
import com.sma.delivery.beans.base.BaseBean;
import java.util.Map;

public class IngredientsB extends BaseBean {
    private static final long serialVersionUID = 1L;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    String description;
    public IngredientsB(Map<String, String> params)  {
        super(params);
    }
    @Override
    protected void create(Map<String, String> params) {
        if (!StringUtils.isBlank(params.get("id"))) {
            setId(Integer.valueOf(params.get("id")));
        }

        setDescription (params.get("description"));


    }

}
