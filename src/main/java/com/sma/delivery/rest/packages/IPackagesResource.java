package com.sma.delivery.rest.packages;

import com.sma.delivery.dto.packages.PackageDTO;
import com.sma.delivery.dto.packages.PackageResult;
import com.sma.delivery.rest.base.IBaseResource;

public interface IPackagesResource extends IBaseResource<PackageDTO> {

    public PackageResult find(String text, Integer page);
    public PackageResult getAll(Integer page);
    public PackageResult getPackages();


}