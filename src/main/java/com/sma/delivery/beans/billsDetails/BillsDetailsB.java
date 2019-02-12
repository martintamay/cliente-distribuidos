package com.sma.delivery.beans.billsDetails;

import com.sma.delivery.beans.base.BaseBean;
import com.sma.delivery.beans.bills.BillsB;
import org.apache.commons.lang.StringUtils;

import java.text.ParseException;
import java.util.Map;

public class BillsDetailsB extends BaseBean{

        private static final long serialVersionUID = 1L;

    private BillsB bills;

        private Integer amount;
        private Integer iva10;

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

            if (!StringUtils.isBlank(params.get("iva"))) {
                setIva10(Integer.valueOf(params.get("iva")));
            }

        }

    }

