package com.sma.delivery.rest.products;

import com.sma.delivery.dto.products.ProductsResult;
import org.springframework.stereotype.Repository;

import com.sma.delivery.dto.products.ProductsDTO;
import com.sma.delivery.rest.base.BaseResourceImpl;
import javax.xml.bind.annotation.XmlRootElement;
@Repository("productsResource")
@XmlRootElement(name = "productsResult")
public class ProductsResourceImpl extends BaseResourceImpl<ProductsDTO> implements IProductsResource {

    public ProductsResourceImpl() {
        super(ProductsDTO.class, "/products");
    }

    @Override
    public ProductsResult getAll(Integer page) {
        final ProductsResult result = getWebResource().path("/"+page+"/"+3).get(ProductsResult.class);
        return result;
    }

    @Override
    public ProductsDTO getById(Integer id) {
        return getWebResource().path("/" + id).get(getDtoClass());
    }

    @Override
    public ProductsResult find(String text) {
        final ProductsResult result = getWebResource().path("/search/"+text).get(ProductsResult.class);
        return result;
    }


    @Override
    public ProductsResult getProducts() {
        return getWebResource().path("/" + 1 + "/" + 200).get(ProductsResult.class);
    }
}

