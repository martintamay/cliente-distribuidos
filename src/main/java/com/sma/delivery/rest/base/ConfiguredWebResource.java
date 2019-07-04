package com.sma.delivery.rest.base;

import com.sma.delivery.rest.user.UserResourceImpl;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.ClientFilter;

public class ConfiguredWebResource {
    private final WebResource _webResource;
    public ConfiguredWebResource(WebResource wr){
        _webResource = wr;
    }

    public ConfiguredWebResource path(String path){
        return new ConfiguredWebResource(_webResource.path(path));
    }

    public ConfiguredWebResource queryParam(String key, String value){
        return new ConfiguredWebResource(_webResource.queryParam(key, value));
    }

    public void addFilter(ClientFilter f){
        _webResource.addFilter(f);
    }

    public WebResource.Builder entity(Object entity){
        return getBuilder().entity(entity);
    }

    public <T> T get(Class<T> tClass){
        return getBuilder().get(tClass);
    }

    public <T> T put(Class<T> tClass){
        return getBuilder().put(tClass);
    }

    public <T> T post(Class<T> tClass){
        return getBuilder().post(tClass);
    }

    public <T> T delete(Class<T> tClass){
        return getBuilder().delete(tClass);
    }

    public void delete(){
        getBuilder().delete();
    }

    public WebResource.Builder getBuilder(){
        return _webResource.header("token", BaseResourceImpl.TOKEN);
    }

    public WebResource getWebResource(){
        return _webResource;
    }
}
