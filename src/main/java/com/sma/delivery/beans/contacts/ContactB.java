package com.sma.delivery.beans.contacts;

import com.sma.delivery.beans.base.BaseBean;

import java.util.Map;

public class ContactB extends BaseBean {
    private static final long serialVersionUID = 1L;

    public ContactB(Map<String, String> params) {
        super(params);
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String from;
    private String fullname;
    private String phoneNumber;
    private String message;

    @Override
    protected void create(Map<String, String> params) {
        setFrom(params.get("from"));
        setFullname(params.get("fullname"));
        setMessage(params.get("message"));
        setPhoneNumber(params.get("phoneNumber"));

    }
}
