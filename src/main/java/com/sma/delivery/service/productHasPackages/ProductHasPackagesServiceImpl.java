package com.sma.delivery.service.productHasPackages;

import com.sma.delivery.beans.productHasPackages.ProductHasPackagesB;
import com.sma.delivery.dto.product_has_packages.ProductHasPackagesDTO;
import com.sma.delivery.dto.product_has_packages.ProductHasPackagesResult;
import com.sma.delivery.rest.productHasPackages.IProductHasPackagesResource;
import com.sma.delivery.service.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("productHasPackagesService")
public class ProductHasPackagesServiceImpl extends BaseServiceImpl<ProductHasPackagesB, ProductHasPackagesDTO> implements IProductHasPackagesService {
    @Autowired
    private IProductHasPackagesResource _productHasPackagesResource;

    @Override
    public Set<ProductHasPackagesB> getAllBy(Map<String, String> args) {
        final ProductHasPackagesResult result = _productHasPackagesResource.getAllBy(args);
        final List<ProductHasPackagesDTO> cList = null == result.getProductHasPackages() ? new ArrayList<>()
                : result.getProductHasPackages();
        final Set<ProductHasPackagesB> productsHasPackages = new HashSet<>();
        for (ProductHasPackagesDTO dto : cList) {
            final ProductHasPackagesB productHasPackages = convertDtoToBean(dto);
            productsHasPackages.add(productHasPackages);
        }
        return productsHasPackages;
    }

    @Override
    protected ProductHasPackagesB convertDtoToBean(ProductHasPackagesDTO dto) {
        final Map<String, String> params = new HashMap<>();
        params.put("id", String.valueOf(dto.getId()));
        params.put("quantity", String.valueOf(dto.getCuantity()));
        params.put("cost", String.valueOf(dto.getCost()));
        params.put("comment", String.valueOf(dto.getComment()));
        params.put("product", String.valueOf(dto.getProductId()));
        params.put("packages", String.valueOf(dto.getPromotionId()));
        ProductHasPackagesB productHasPromotions = new ProductHasPackagesB(params);

        return productHasPromotions;
    }

    @Override
    public ProductHasPackagesDTO convertBeanToDto(ProductHasPackagesB bean) {
        final ProductHasPackagesDTO dto = new ProductHasPackagesDTO();
        dto.setId(bean.getId());
        dto.setCost(bean.getCost());
        dto.setCuantity(bean.getQuantity());
        dto.setComment(bean.getComment());
        dto.setPromotionId(bean.getPackages());
        dto.setProductId(bean.getProduct());
        return dto;
    }

    @Override
    public ProductHasPackagesB save(ProductHasPackagesB bean) {
        return null;
    }

    @Override
    public void delete(Integer id){
        _productHasPackagesResource.delete(id);
    }

    @Override
    public List<ProductHasPackagesB> getAll(Integer page) {
        return null;
    }

    @Override
    public ProductHasPackagesB getById(Integer id) {
        return null;
    }

    @Override
    public List<ProductHasPackagesB> find(String text, Integer page) {
        return null;
    }
}
