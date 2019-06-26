package com.sma.delivery.beans.bills;

import com.sma.delivery.beans.base.BaseBean;
import com.sma.delivery.beans.billsDetails.BillsDetailsB;
import com.sma.delivery.beans.order.OrderB;
import org.apache.commons.lang.StringUtils;
import org.grails.web.json.JSONArray;
import org.grails.web.json.JSONObject;
import java.util.*;


public class BillsB extends BaseBean{
    private static final long serialVersionUID = 1L;
    public String getAlgo() {
        return algo;
    }

    public void setAlgo(String total) {
        this.algo = total;
    }
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

    public void setDetails(Set<BillsDetailsB> billsDetails) {
        this.details = billsDetails;
    }

    public Set<BillsDetailsB> getDetails() {
        return this.details;
    }

    private String algo;
    private String total;
    private Integer iva10;
    private OrderB order;
    private Set<BillsDetailsB> details;


    public BillsB(Map<String, String> params) {
        super(params);
    }

    @Override
    protected void create(Map<String, String> params) {
        if(params.get("bill")!=null) {
            JSONObject json = new JSONObject(params.get("bill"));
            Set<BillsDetailsB> b = new HashSet<>();
            if(json.containsKey("BillsDetails")) {
                JSONArray jsonArray = new JSONArray(json.getString("BillsDetails"));
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject a = (JSONObject) jsonArray.get(i);
                    Map<String, String> p = new HashMap<>();
                    if(a.containsKey("id"))
                        p.put("id", a.getString("id"));
                    p.put("iva10", a.getString("iva"));
                    p.put("amount", a.getString("amount"));
                    BillsDetailsB detailsB = new BillsDetailsB(p);
                    b.add(detailsB);
                }
            }
            setDetails(b);
            JSONObject bill = new JSONObject(json.getString("bill"));
        if(bill.containsKey("id"))
            setId(Integer.valueOf(bill.getString("id")));
            setIva10(Integer.valueOf(bill.getString("iva10")));
            setTotal(bill.getString("total"));
        }
    }
}