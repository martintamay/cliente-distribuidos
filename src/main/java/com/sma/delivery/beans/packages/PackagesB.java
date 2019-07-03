package com.sma.delivery.beans.packages;

import com.sma.delivery.beans.base.BaseBean;
import com.sma.delivery.beans.productHasPackages.ProductHasPackagesB;
import org.apache.commons.lang.StringUtils;
import org.grails.web.json.JSONArray;
import org.grails.web.json.JSONObject;

import java.sql.Date;
import java.text.ParseException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PackagesB extends BaseBean {
    private static final long serialVersionUID = 1L;
    private String name;
    private Integer cost;
    private Set<ProductHasPackagesB> productHasPackages;

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

    public Set<ProductHasPackagesB> getProductHasPackages() {
        return productHasPackages;
    }

    public void setProductHasPackages(Set<ProductHasPackagesB> productHasPackages) {
        this.productHasPackages = productHasPackages;
    }

    @Override
    protected void create(Map<String, String> params)  {
        if(params.get("packages")!=null) {
            JSONObject json = new JSONObject(params.get("packages"));
            Set<ProductHasPackagesB> b = new HashSet<>();
            if(json.containsKey("productsHasPackages")) {
                JSONArray jsonArray = new JSONArray(json.getString("productsHasPackages"));
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject a = (JSONObject) jsonArray.get(i);
                    Map<String, String> p = new HashMap<>();
                    if(a.containsKey("id"))
                        p.put("id", a.getString("id"));
                    p.put("product", a.getString("product"));
                    p.put("comment", a.getString("comment"));
                    p.put("quantity", a.getString("quantity"));
                    p.put("cost", a.getString("cost"));
                    ProductHasPackagesB detailsB = new ProductHasPackagesB(p);
                    b.add(detailsB);
                }
            }
            System.out.println("length --------"+b.size());
            setProductHasPackages(b);
            JSONObject packages = new JSONObject(json.getString("packages"));
            if(packages.containsKey("id"))
                setId(Integer.valueOf(packages.getString("id")));
            setName(packages.getString("name"));
            setCost(Integer.valueOf(packages.getString("cost")));

        }

    }

}



