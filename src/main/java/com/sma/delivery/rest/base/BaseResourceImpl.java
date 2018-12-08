package com.sma.delivery.rest.base;

import com.sma.delivery.dto.base.BaseDTO;
import com.sma.delivery.service.auth.IAuthService;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseResourceImpl<DTO extends BaseDTO> implements IBaseResource<DTO> {
    private final String _resourcePath;
    private final Class<DTO> _dtoClass;
    private final WebResource _webResource;

    private static final String BASE_URL = "http://localhost:28080/delivery/rest";
    private static final String TOKEN = "$2a$11$4oHHbmgsIgx9ISBVDn0h6ezUiOD.Pof0TEkFUJFllk3ms7JPjzQFC";


    @Autowired
    private IAuthService authService;

    public BaseResourceImpl(Class<DTO> dtoClass, String resourcePath) {
        _dtoClass = dtoClass;
        _resourcePath = BASE_URL + resourcePath;

        final Client jerseyClient = Client.create();

        _webResource = jerseyClient.resource(_resourcePath);
        _webResource.header("token", TOKEN);
    }

    protected WebResource getWebResource() {
        return _webResource;
    }

    public void setWebResourceBasicAuthFilter(){
        String u = authService.getUsername();
        String p = authService.getPassword();

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
