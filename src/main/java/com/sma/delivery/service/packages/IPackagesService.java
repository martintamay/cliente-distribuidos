package com.sma.delivery.service.packages;

import com.sma.delivery.beans.packages.PackagesB;
import com.sma.delivery.dto.packaged.PackageDTO;
import com.sma.delivery.service.base.IBaseService;

import java.util.List;

public interface IPackagesService extends IBaseService<PackagesB, PackageDTO> {
    public List<PackagesB> getPackages();
}
