package com.sma.delivery.service.products;

import com.sma.delivery.beans.ingredientsProducts.IngredientsProductsB;
import com.sma.delivery.beans.products.ProductsB;
import com.sma.delivery.dto.ingredients_products.IngredientsProductsDTO;
import com.sma.delivery.dto.products.ProductDTO;
import com.sma.delivery.dto.products.ProductResult;
import com.sma.delivery.rest.products.IProductsResource;
import com.sma.delivery.service.base.BaseServiceImpl;
import com.sma.delivery.service.establishments.IEstablishmentsService;
import com.sma.delivery.service.ingredientsProducts.IIngredientsProductsService;
import org.grails.web.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("productsService")
public class ProductsServiceImpl extends BaseServiceImpl<ProductsB, ProductDTO> implements IProductsService {

    @Autowired
    private IProductsResource _productsResource;

    @Autowired
    private IEstablishmentsService _establishmentsService;

    @Autowired
    private IIngredientsProductsService _ingredientsProductsService;

    public ProductsServiceImpl() {
    }

    @Override
    public ProductsB save(ProductsB bean)  {
        final ProductDTO products = convertBeanToDto(bean);
        final ProductDTO dto = _productsResource.save(products);

        final ProductsB productsB = convertDtoToBean(dto);
        if (bean.getId() == null) {
            getCacheManager().getCache("delivery-cacheC").put("productClients_" + dto.getId(), productsB);
        }
        return productsB;
    }

    @Override
    @CacheEvict(value = "delivery-cacheC", key = "'productClients_' + #id")
    public void delete(Integer id){
        _productsResource.delete(id);
    }

    @Override
    public List<ProductsB> getAll(Integer page)  {
        final ProductResult result = _productsResource.getAll(page);
        final List<ProductDTO> cList = null == result.getProducts() ? new ArrayList<ProductDTO>()
                : result.getProducts();

        final List<ProductsB> products = new ArrayList<ProductsB>();
        for (ProductDTO dto : cList) {
            final ProductsB bean = convertDtoToBean(dto);
            products.add(bean);
            if (bean.getId() == null) {
                getCacheManager().getCache("delivery-cacheC").put("productClients_" + dto.getId(), bean);
            }
        }
        return products;
    }

    @Override
    @Cacheable(value= "delivery-cacheC", key= "'productClients_'+#id")
    public ProductsB getById(Integer id)  {
        final ProductDTO dto = _productsResource.getById(id);
        final ProductsB bean = convertDtoToBean(dto);

        return bean;
    }

    @Override
    public List<ProductsB> find(String text, Integer page)  {
        final ProductResult result = _productsResource.find(text, page);
        final List<ProductDTO> cList = null == result.getProducts() ? new ArrayList<ProductDTO>()
                : result.getProducts();

        final List<ProductsB> products = new ArrayList<ProductsB>();
        for (ProductDTO dto : cList) {
            final ProductsB bean = convertDtoToBean(dto);
            products.add(bean);
            if (bean.getId() != null) {
                getCacheManager().getCache("delivery-cacheC").put("productClients_" + bean.getId(), bean);
            }
        }
        return products;
    }

    @Override
    public List<ProductsB> byEstablishment(Integer establishmentId, String text, Integer page){
        final ProductResult result = _productsResource.byEstablishment(establishmentId, text, page);
        final List<ProductDTO> cList = null == result.getProducts() ? new ArrayList<>()
                : result.getProducts();

        final List<ProductsB> products = new ArrayList<ProductsB>();
        for (ProductDTO dto : cList) {
            final ProductsB bean = convertDtoToBean(dto);
            products.add(bean);
            if (bean.getId() != null) {
                getCacheManager().getCache("delivery-cacheC").put("productClients_" + bean.getId(), bean);
            }
        }
        return products;
    }

    @Override
    protected ProductsB convertDtoToBean(ProductDTO dto)  {
        final Map<String, String> params = new HashMap<String, String>();
        JSONObject products = new JSONObject();
        products.put("id",String.valueOf(dto.getId()));
        products.put("name",dto.getName());
        products.put("description",dto.getDescription());
        products.put("cost",String.valueOf(dto.getCost()));
        products.put("establishmentId", String.valueOf(dto.getEstablishmentId()));
        JSONObject productParams = new JSONObject();
        productParams.put("Product",products);
        params.put("product",productParams.toString());
        final ProductsB productsB = new ProductsB(params);
        productsB.setEstablishments(_establishmentsService.getById(dto.getEstablishmentId()));
        return productsB;
    }

    @Override
    protected ProductDTO convertBeanToDto(ProductsB bean) {
        final ProductDTO dto = new ProductDTO();
        dto.setId(bean.getId());
        dto.setName(bean.getName());
        dto.setDescription(bean.getDescription());
        dto.setCost(bean.getCost());
        dto.setEstablishmentId(bean.getEstablishments().getId());
        Set<IngredientsProductsDTO> ingredientsProductsDTO = new HashSet<>();
        for(IngredientsProductsB ingredientsProductsB: bean.getIngredientsProducts()){
            ingredientsProductsDTO.add(_ingredientsProductsService.convertBeanToDto(ingredientsProductsB));
        }
        dto.setIngredientsProducts(ingredientsProductsDTO);
        return dto;
    }

    @Override
    public List<ProductsB> getProducts()  {
        final ProductResult result = _productsResource.getProducts();
        final List<ProductDTO> cList = null == result.getProducts() ? new ArrayList<ProductDTO>() : result.getProducts();
        final List<ProductsB> products = new ArrayList<ProductsB>();
        for (ProductDTO dto : cList) {
            products.add(convertDtoToBean(dto));
        }
        return products;
    }
}
