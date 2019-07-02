package com.sma.delivery.service.productHasPromotions;

import com.sma.delivery.beans.productHasPromotions.ProductHasPromotionsB;
import com.sma.delivery.dto.product_has_promotions.ProductHasPromotionDTO;
import com.sma.delivery.dto.product_has_promotions.ProductHasPromotionResult;
import com.sma.delivery.rest.productHasPromotions.IProductHasPromotionsResource;
import com.sma.delivery.service.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("productHasPromotionsService")
public class ProductHasPromotionsServiceImpl extends BaseServiceImpl<ProductHasPromotionsB, ProductHasPromotionDTO> implements IProductHasPromotionsService {
    @Autowired
    private IProductHasPromotionsResource _productHasPromotionsResource;

    @Override
    public Set<ProductHasPromotionsB> getAllBy(Map<String, String> args) {
        final ProductHasPromotionResult result = _productHasPromotionsResource.getAllBy(args);
        final List<ProductHasPromotionDTO> cList = null == result.getProductHasPromotions() ? new ArrayList<>()
                : result.getProductHasPromotions();
        final Set<ProductHasPromotionsB> productsHasPromotions = new HashSet<>();
        for (ProductHasPromotionDTO dto : cList) {
            final ProductHasPromotionsB productHasPromotions = convertDtoToBean(dto);
            productsHasPromotions.add(productHasPromotions);
        }
        return productsHasPromotions;
    }

    @Override
    protected ProductHasPromotionsB convertDtoToBean(ProductHasPromotionDTO dto) {
        final Map<String, String> params = new HashMap<>();
        params.put("id", String.valueOf(dto.getId()));
        params.put("quantity", String.valueOf(dto.getCuantity()));
        params.put("cost", String.valueOf(dto.getCost()));
        params.put("comment", String.valueOf(dto.getComment()));
        params.put("product", String.valueOf(dto.getProductId()));
        params.put("promotion", String.valueOf(dto.getPromotionId()));
        ProductHasPromotionsB productHasPromotions = new ProductHasPromotionsB(params);

        return productHasPromotions;
    }

    @Override
    public ProductHasPromotionDTO convertBeanToDto(ProductHasPromotionsB bean) {
        final ProductHasPromotionDTO dto = new ProductHasPromotionDTO();
        dto.setId(bean.getId());
        dto.setCost(bean.getCost());
        dto.setCuantity(bean.getQuantity());
        dto.setComment(bean.getComment());
        dto.setPromotionId(bean.getPromotion());
        dto.setProductId(bean.getProduct());
        return dto;
    }

    @Override
    public ProductHasPromotionsB save(ProductHasPromotionsB bean) {
        return null;
    }

    @Override
    public void delete(Integer id){
        _productHasPromotionsResource.delete(id);
    }

    @Override
    public List<ProductHasPromotionsB> getAll(Integer page) {
        return null;
    }

    @Override
    public ProductHasPromotionsB getById(Integer id) {
        return null;
    }

    @Override
    public List<ProductHasPromotionsB> find(String text, Integer page) {
        return null;
    }
}
