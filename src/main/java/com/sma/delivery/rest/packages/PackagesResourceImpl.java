package com.sma.delivery.rest.packages;

import com.sma.delivery.dto.packages.PackageDTO;
import com.sma.delivery.dto.packages.PackageResult;
import com.sma.delivery.rest.base.BaseResourceImpl;
import org.springframework.stereotype.Repository;

@Repository("packagesResource")
public class PackagesResourceImpl extends BaseResourceImpl<PackageDTO> implements IPackagesResource {

    public PackagesResourceImpl() {
        super(PackageDTO.class, "/packages");
    }

    @Override
    public PackageResult getAll(Integer page) {
        setWebResourceBasicAuthFilter();
        final PackageResult result = getWebResource().path("/"+page+"/"+5).get(PackageResult.class);
        return result;
    }


    @Override
    public PackageResult find(String text, Integer page) {
        final PackageResult result = getWebResource().path("/search/"+page+"/"+3+"/"+text).get(PackageResult.class);
        return result;
    }


    @Override
    public PackageResult getPackages() {
        return getWebResource().path("/" + 1 + "/" + 200).get(PackageResult.class);

    }
}
