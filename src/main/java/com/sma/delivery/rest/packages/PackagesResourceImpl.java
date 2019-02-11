package com.sma.delivery.rest.packages;

import org.springframework.stereotype.Repository;

import com.sma.delivery.dto.packages.PackageDTO;
import com.sma.delivery.dto.packages.PackageResult;
import com.sma.delivery.rest.base.BaseResourceImpl;
import javax.xml.bind.annotation.XmlRootElement;
@Repository("packagesResource")
public class PackagesResourceImpl extends BaseResourceImpl<PackageDTO> implements IPackagesResource {

    public PackagesResourceImpl() {
        super(PackageDTO.class, "/package");
    }

    @Override
    public PackageResult getAll(Integer page) {
        final PackageResult result = getWebResource().path("/"+page+"/"+20).get(PackageResult.class);        return result;
    }

    @Override
    public PackageDTO getById(Integer id) {
        return getWebResource().path("/" + id).get(getDtoClass());
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
