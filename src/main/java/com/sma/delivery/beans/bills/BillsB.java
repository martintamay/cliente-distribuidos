package com.sma.delivery.beans.bills;

import com.sma.delivery.beans.base.BaseBean;
import com.sma.delivery.beans.order.OrderB;
import org.apache.commons.lang.StringUtils;
import java.util.Map;


public class BillsB extends BaseBean{
    private static final long serialVersionUID = 1L;

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public Integer getIva10() {
        return iva10;
    }

    public void setIva10(Integer iva10) {
        this.iva10 = iva10;
    }

    public OrderB getOrder() {
        return order;
    }

    public void setOrder(OrderB order) {
        this.order = order;
    }

    private String total;
    private Integer iva10;
    private OrderB order;




    public BillsB(Map<String, String> params) {
        super(params);
    }
    @Override
    protected void create(Map<String, String> params) {
        if (!StringUtils.isBlank(params.get("id"))) {
            setId(Integer.valueOf(params.get("id")));

        }

        if (!StringUtils.isBlank(params.get("iva10"))) {
            setIva10(Integer.valueOf(params.get("iva10")));

        }

        setTotal(params.get("total"));




    }


}
