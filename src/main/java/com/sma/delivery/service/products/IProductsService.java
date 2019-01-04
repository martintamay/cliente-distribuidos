package com.sma.delivery.service.products;

import com.sma.delivery.beans.products.ProductsB;
import com.sma.delivery.dto.products.ProductsDTO;
import com.sma.delivery.service.base.IBaseService;

import java.util.List;

public interface IProductsService extends IBaseService<ProductsB, ProductsDTO> {
    public List<ProductsB> getProducts();
}
