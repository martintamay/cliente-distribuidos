package com.sma.delivery.rest.products;

import com.sma.delivery.dto.products.ProductResult;
import com.sma.delivery.dto.products.ProductDTO;
import com.sma.delivery.rest.base.IBaseResource;


public interface IProductsResource extends IBaseResource<ProductDTO> {

    public ProductResult find(String text, Integer page);
    public ProductResult getAll(Integer page);
    public ProductResult getProducts();
}
