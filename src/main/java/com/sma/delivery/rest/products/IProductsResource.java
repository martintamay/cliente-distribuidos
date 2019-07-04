package com.sma.delivery.rest.products;

import com.sma.delivery.dto.products.ProductDTO;
import com.sma.delivery.dto.products.ProductResult;
import com.sma.delivery.rest.base.IBaseResource;


public interface IProductsResource extends IBaseResource<ProductDTO> {

    ProductResult find(String text, Integer page);
    ProductResult getAll(Integer page);
    ProductResult getProducts();
    ProductResult byEstablishment(Integer establishmentId, String text, Integer page);
}
