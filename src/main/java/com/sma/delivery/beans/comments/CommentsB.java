package com.sma.delivery.beans.comments;



import com.sma.delivery.beans.base.BaseBean;
import com.sma.delivery.beans.establishments.EstablishmentsB;
import com.sma.delivery.beans.user.UserB;

import org.apache.commons.lang.StringUtils;

import java.util.Map;

public class CommentsB extends BaseBean {

    private static final long serialVersionUID = 1L;
    private String content;
    private  Boolean deleted;
    private String title;
    private EstablishmentsB establishments;
    private UserB user;

    public UserB get_user() {
        return user;
    }

    public void set_user(UserB user) {
        this.user = user;
    }


    public EstablishmentsB get_establishments() {
        return establishments;
    }

    public void set_establishments(EstablishmentsB establishments) {
        this.establishments = establishments;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }







    public CommentsB(Map<String, String> params) {
        super(params);
    }
    @Override
    protected void create(Map<String, String> params) {
        if (!StringUtils.isBlank(params.get("id"))) {
            setId(Integer.valueOf(params.get("id")));
        }

        setContent(params.get("content"));
        setDeleted (Boolean.valueOf(params.get("deleted")));
        setTitle(params.get("title"));


    }

}
