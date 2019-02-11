package com.sma.delivery.beans.establishments;



import com.sma.delivery.beans.base.BaseBean;
import org.apache.commons.lang.StringUtils;

import java.text.ParseException;
import java.util.Map;

public class EstablishmentsB extends BaseBean {

    private static final long serialVersionUID = 1L;

    private String address;
    private String  description;
    private String email;
    private String name;
    private String phoneNumber;
    private String schedule;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone_number() {
        return phoneNumber;
    }

    public void setPhone_number(String phone_number) {
        this.phoneNumber = phone_number;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }




    public EstablishmentsB(Map<String, String> params)  {
        super(params);
    }
    @Override
    protected void create(Map<String, String> params) {
        if (!StringUtils.isBlank(params.get("id"))) {
            setId(Integer.valueOf(params.get("id")));
        }
        System.out.print(params.get("name"));
        setDescription(params.get("description"));
        setAddress (params.get("address"));
        setEmail(params.get("email"));
        setPhone_number(params.get("phoneNumber"));
        setSchedule(params.get("schedule"));
    }

}