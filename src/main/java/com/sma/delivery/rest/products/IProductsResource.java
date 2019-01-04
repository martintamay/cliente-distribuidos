package com.sma.delivery.rest.products;

import com.sma.delivery.dto.products.ProductsResult;
import com.sma.delivery.dto.products.ProductsDTO;
import com.sma.delivery.rest.base.IBaseResource;


public interface IProductsResource extends IBaseResource<ProductsDTO> {
    public ProductsResult getAll(Integer page);
    public ProductsResult find(String text);
    public ProductsResult getProducts();
}
