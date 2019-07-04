package com.sma.delivery.rest.products;

import com.sma.delivery.dto.products.ProductDTO;
import com.sma.delivery.dto.products.ProductResult;
import com.sma.delivery.rest.base.BaseResourceImpl;
import org.springframework.stereotype.Repository;

import javax.xml.bind.annotation.XmlRootElement;
@Repository("productsResource")
@XmlRootElement(name = "productsResult")
public class ProductsResourceImpl extends BaseResourceImpl<ProductDTO> implements IProductsResource {

    public ProductsResourceImpl() {
        super(ProductDTO.class, "/products");
    }

    @Override
    public ProductResult getAll(Integer page) {
        final ProductResult result = getWebResource().path("/"+page+"/"+3).get(ProductResult.class);
        return result;
    }

    @Override
    public ProductDTO getById(Integer id) {
        return getWebResource().path("/" + id).get(getDtoClass());
    }

    @Override
    public ProductResult find(String text, Integer page) {
        final ProductResult result = getWebResource().path("/search/"+page+"/"+3+"/"+text).get(ProductResult.class);
        return result;
    }


    @Override
    public ProductResult getProducts() {
        return getWebResource().path("/" + 1 + "/" + 200).get(ProductResult.class);
    }

    @Override
    public ProductResult byEstablishment(Integer establishmentId, String text, Integer page) {
        final ProductResult result = getWebResource().path("/establishment/"+establishmentId+"/"+page+"/"+3+"/"+text).get(ProductResult.class);
        return result;
    }
}

