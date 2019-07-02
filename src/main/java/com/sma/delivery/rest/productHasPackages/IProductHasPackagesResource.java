package com.sma.delivery.rest.productHasPackages;

import com.sma.delivery.dto.product_has_packages.ProductHasPackagesDTO;
import com.sma.delivery.dto.product_has_packages.ProductHasPackagesResult;
import com.sma.delivery.rest.base.IBaseResource;

import java.util.Map;

public interface IProductHasPackagesResource extends IBaseResource<ProductHasPackagesDTO> {
    public ProductHasPackagesResult getAllBy(Map<String, String> args);
}
