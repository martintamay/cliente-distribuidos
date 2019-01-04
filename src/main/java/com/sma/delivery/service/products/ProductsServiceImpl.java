package com.sma.delivery.service.products;

import com.sma.delivery.beans.products.ProductsB;
import com.sma.delivery.dto.products.ProductsDTO;
import com.sma.delivery.dto.products.ProductsResult;
import com.sma.delivery.service.base.BaseServiceImpl;
import com.sma.delivery.service.establishments.IEstablishmentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sma.delivery.rest.products.IProductsResource;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("productsService")
public class ProductsServiceImpl extends BaseServiceImpl<ProductsB, ProductsDTO> implements IProductsService {

    @Autowired
    private IProductsResource _productsResource;
    @Autowired
    private IEstablishmentsService _establishmentsService;

    public ProductsServiceImpl() {
    }

    @Override
    public ProductsB save(ProductsB bean) {
        final ProductsDTO products = convertBeanToDto(bean);
        final ProductsDTO dto = _productsResource.save(products);

        final ProductsB productsB = convertDtoToBean(dto);
        return productsB;
    }

    @Override
    public void delete(Integer id){
        _productsResource.delete(id);
    }

    @Override
    public List<ProductsB> getAll(Integer page) {
        final ProductsResult result = _productsResource.getAll(page);
        final List<ProductsDTO> cList = null == result.getProducts() ? new ArrayList<ProductsDTO>()
                : result.getProducts();

        final List<ProductsB> products = new ArrayList<ProductsB>();
        for (ProductsDTO dto : cList) {
            final ProductsB bean = convertDtoToBean(dto);
            products.add(bean);
        }
        return products;
    }

    @Override
    public ProductsB getById(Integer id) {
        final ProductsDTO dto = _productsResource.getById(id);
        final ProductsB bean = convertDtoToBean(dto);

        return bean;
    }

    @Override
    public List<ProductsB> find(String text) {

        final ProductsResult result = _productsResource.find(text);
        final List<ProductsDTO> cList = null == result.getProducts() ? new ArrayList<ProductsDTO>()
                : result.getProducts();

        final List<ProductsB> products = new ArrayList<ProductsB>();
        for (ProductsDTO dto : cList) {
            final ProductsB bean = convertDtoToBean(dto);
            products.add(bean);
        }
        return products;
    }

    @Override
    protected ProductsB convertDtoToBean(ProductsDTO dto) {
        final Map<String, String> params = new HashMap<String, String>();
        params.put("id", String.valueOf(dto.getId()));
        params.put("name", dto.getName());
        params.put("description", dto.getDescription());
        params.put("cost", String.valueOf(dto.getCost()));
        final ProductsB productsB = new ProductsB(params);

        productsB.setEstablishments(_establishmentsService.getById(dto.getEstablishments()));
        return productsB;
    }

    @Override
    protected ProductsDTO convertBeanToDto(ProductsB bean) {
        final ProductsDTO dto = new ProductsDTO();
        dto.setId(bean.getId());
        dto.setName(bean.getName());
        dto.setDescription(bean.getDescription());
        dto.setCost(bean.getCost());
        dto.setEstablishments(bean.getEstablishments().getId());


        return dto;
    }

    @Override
    public List<ProductsB> getProducts() {
        final ProductsResult result = _productsResource.getProducts();
        final List<ProductsDTO> cList = null == result.getProducts() ? new ArrayList<ProductsDTO>() : result.getProducts();
        final List<ProductsB> products = new ArrayList<ProductsB>();
        for (ProductsDTO dto : cList) {
            products.add(convertDtoToBean(dto));
        }
        return products;
    }
}
