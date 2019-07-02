package com.sma.delivery.rest.productHasPackages;

import com.sma.delivery.dto.product_has_packages.ProductHasPackagesDTO;
import com.sma.delivery.dto.product_has_packages.ProductHasPackagesResult;
import com.sma.delivery.rest.base.BaseResourceImpl;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository("ingredientsProductsResource")
public class ProductHasPackagesResourceImpl extends BaseResourceImpl<ProductHasPackagesDTO> implements IProductHasPackagesResource {
    public ProductHasPackagesResourceImpl() {
        super(ProductHasPackagesDTO.class, "/product-has-packages");
    }

    @Override
    public ProductHasPackagesResult getAllBy(Map<String, String> args) {
        return getWebResource().path("/packagesId/" +args.get("packagesId")).get(ProductHasPackagesResult.class);
    }
}
