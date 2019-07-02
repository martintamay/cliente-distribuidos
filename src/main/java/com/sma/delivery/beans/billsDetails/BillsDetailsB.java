package com.sma.delivery.beans.billsDetails;

import com.sma.delivery.beans.base.BaseBean;
import com.sma.delivery.beans.bills.BillsB;
import com.sma.delivery.beans.products.ProductsB;
import org.apache.commons.lang.StringUtils;
import java.util.Map;

public class BillsDetailsB extends BaseBean{

    private static final long serialVersionUID = 1L;

    private BillsB bills;

    private Integer amount;
    private Integer iva10;
    private Integer bill;
    private Integer iva5;
    private Integer exenta;
    private Integer unitary;
    private Integer quantity;

    public ProductsB getProduct() {
        return product;
    }

    public void setProduct(ProductsB product) {
        this.product = product;
    }

    private ProductsB product;

    public Integer getBill() {
        return bill;
    }

    public void setBill(Integer bill) {
        this.bill = bill;
    }

    public Integer getIva5() {
        return iva5;
    }

    public void setIva5(Integer iva5) {
        this.iva5 = iva5;
    }

    public Integer getExenta() {
        return exenta;
    }

    public void setExenta(Integer exenta) {
        this.exenta = exenta;
    }

    public Integer getUnitary() {
        return unitary;
    }

    public void setUnitary(Integer unitary) {
        this.unitary = unitary;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getIva10() {
        return iva10;
    }

    public void setIva10(Integer iva10) {
        this.iva10 = iva10;
    }

    public BillsB getBills() {
        return bills;
    }

    public void setBills(BillsB bills) {
        this.bills = bills;
    }





    public BillsDetailsB(Map<String, String> params)  {
        super(params);
    }
    @Override
    protected void create(Map<String, String> params) {
        if (!StringUtils.isBlank(params.get("id"))) {
            setId(Integer.valueOf(params.get("id")));
        }
        if (!StringUtils.isBlank(params.get("amount"))) {
            setAmount(Integer.valueOf(params.get("amount")));
        }
        if (!StringUtils.isBlank(params.get("iva10"))) {
            setIva10(Integer.valueOf(params.get("iva10")));
        }
        if (!StringUtils.isBlank(params.get("iva5"))) {
            setIva5(Integer.valueOf(params.get("iva5")));
        }
        if (!StringUtils.isBlank(params.get("exenta"))) {
            setExenta(Integer.valueOf(params.get("exenta")));
        }
        if (!StringUtils.isBlank(params.get("unitary"))) {
            setUnitary(Integer.valueOf(params.get("unitary")));
        }
        if (!StringUtils.isBlank(params.get("quantity"))) {
            setQuantity(Integer.valueOf(params.get("quantity")));
        }
    }

}

