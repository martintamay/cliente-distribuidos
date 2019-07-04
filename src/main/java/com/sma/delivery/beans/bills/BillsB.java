package com.sma.delivery.beans.bills;

import com.sma.delivery.beans.base.BaseBean;
import com.sma.delivery.beans.billsDetails.BillsDetailsB;
import com.sma.delivery.beans.order.OrderB;
import org.grails.web.json.JSONObject;

import java.util.Map;
import java.util.Set;

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

    public void setBillsDetails(Set<BillsDetailsB> billsDetails) {
        this.billsDetails = billsDetails;
    }

    public Set<BillsDetailsB> getBillsDetails() {
        return this.billsDetails;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getTimbrado() {
        return timbrado;
    }

    public void setTimbrado(String timbrado) {
        this.timbrado = timbrado;
    }

    public Integer getNum1() {
        return num1;
    }

    public void setNum1(Integer num1) {
        this.num1 = num1;
    }

    public Integer getNum2() {
        return num2;
    }

    public void setNum2(Integer num2) {
        this.num2 = num2;
    }

    public Integer getNum3() {
        return num3;
    }

    public void setNum3(Integer num3) {
        this.num3 = num3;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    private String total;
    private Integer iva10;
    private OrderB order;
    private Set<BillsDetailsB> billsDetails;
    private String ruc;
    private String timbrado;
    private Integer num1;
    private Integer num2;
    private Integer num3;
    private String fecha;
    private String nombre;
    private String direccion;


    public BillsB(Map<String, String> params) {
        super(params);
    }

    @Override
    protected void create(Map<String, String> params) {
        if(params.get("bill")!=null) {
            JSONObject json = new JSONObject(params.get("bill"));
            JSONObject bill = new JSONObject(json.getString("bill"));
            if(bill.containsKey("id"))
            setId(Integer.valueOf(bill.getString("id")));
            setIva10(Integer.valueOf(bill.getString("iva10")));
            setTotal(bill.getString("total"));
            setNum1(Integer.valueOf(bill.getString("num1")));
            setNum2(Integer.valueOf(bill.getString("num2")));
            setNum3(Integer.valueOf(bill.getString("num3")));
            setTimbrado(bill.getString("timbrado"));
            setRuc(bill.getString("ruc"));
            setNombre(bill.getString("nombre"));
            setFecha(bill.getString("fecha"));
            setDireccion(bill.getString("direccion"));
        }
    }
}