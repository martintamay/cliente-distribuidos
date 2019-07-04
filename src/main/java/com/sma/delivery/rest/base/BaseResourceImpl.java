package com.sma.delivery.rest.base;

import com.sma.delivery.dto.base.BaseDTO;
import com.sma.delivery.service.auth.IAuthService;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import grails.config.Config;
import grails.core.support.GrailsConfigurationAware;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseResourceImpl<DTO extends BaseDTO> implements IBaseResource<DTO>, GrailsConfigurationAware {
    private final String _resourcePath;
    private final Class<DTO> _dtoClass;
    private final ConfiguredWebResource _webResource;

    //private static final String BASE_URL = "http://localhost:28080/delivery/rest";
    private static String BASE_URL;
    public static String TOKEN;


    @Autowired
    private IAuthService authService;

    @Override
    public void setConfiguration(Config co) {
        BASE_URL = co.getRequiredProperty("api.base_url");
        TOKEN = co.getRequiredProperty("api.token");
        System.out.println("api url " + BASE_URL);
    }

    public BaseResourceImpl(Class<DTO> dtoClass, String resourcePath) {
        _dtoClass = dtoClass;
        _resourcePath = BASE_URL + resourcePath;

        final Client jerseyClient = Client.create();

        _webResource = new ConfiguredWebResource(jerseyClient.resource(_resourcePath));
    }

    protected ConfiguredWebResource getWebResource(boolean withAuth) {
        if (withAuth) setWebResourceBasicAuthFilter();
        return _webResource;
    }
    protected ConfiguredWebResource getWebResource() {
        return getWebResource(true);
    }

    public void setWebResourceBasicAuthFilter(){
        String u = authService.getUsername();
        String p = authService.getPassword();
        System.out.println(String.format("Conectando con usuario %s", u));
        _webResource.addFilter(new HTTPBasicAuthFilter(u,p));
    }

    protected Class<DTO> getDtoClass() {
        return _dtoClass;
    }

    @Override
    public DTO save(DTO dto) {
        setWebResourceBasicAuthFilter();
        if(dto.getId()!=null){
            return getWebResource().path("/" + dto.getId()).entity(dto).put(getDtoClass());
        }else {
            return getWebResource().entity(dto).post(getDtoClass());
        }

    }

    @Override
    public DTO getById(Integer id) {
        setWebResourceBasicAuthFilter();
        return getWebResource().path("/" + id).get(getDtoClass());
    }

    @Override
    public void delete(Integer id) {
        setWebResourceBasicAuthFilter();
        getWebResource().path("/" + id).delete();
    }

}
