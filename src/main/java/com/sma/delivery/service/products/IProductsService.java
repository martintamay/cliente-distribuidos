package com.sma.delivery.service.products;

import com.sma.delivery.beans.products.ProductsB;
import com.sma.delivery.dto.products.ProductDTO;
import com.sma.delivery.service.base.IBaseService;

import java.text.ParseException;
import java.util.List;

public interface IProductsService extends IBaseService<ProductsB, ProductDTO> {
    public List<ProductsB> getProducts() throws ParseException;
}
