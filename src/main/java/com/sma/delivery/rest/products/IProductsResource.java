package com.sma.delivery.rest.products;

import com.sma.delivery.dto.products.ProductsResult;
import com.sma.delivery.dto.products.ProductsDTO;
import com.sma.delivery.rest.base.IBaseResource;


public interface IProductsResource extends IBaseResource<ProductsDTO> {

    public ProductsResult find(String text, Integer page);
    public ProductsResult getAll(Integer page);
    public ProductsResult getProducts();
}
