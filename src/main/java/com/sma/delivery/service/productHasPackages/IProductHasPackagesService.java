package com.sma.delivery.service.productHasPackages;

import com.sma.delivery.beans.productHasPackages.ProductHasPackagesB;
import com.sma.delivery.dto.product_has_packages.ProductHasPackagesDTO;
import com.sma.delivery.service.base.IBaseService;

import java.util.Map;
import java.util.Set;

public interface IProductHasPackagesService extends IBaseService<ProductHasPackagesB, ProductHasPackagesDTO> {
    Set<ProductHasPackagesB> getAllBy(Map<String, String> args);
    public ProductHasPackagesDTO convertBeanToDto(ProductHasPackagesB bean);
}
