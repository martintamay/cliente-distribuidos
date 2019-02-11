package com.sma.delivery.service.packages;

import com.sma.delivery.beans.packages.PackagesB;
import com.sma.delivery.dto.packages.PackageDTO;
import com.sma.delivery.service.base.IBaseService;

import java.text.ParseException;
import java.util.List;

public interface IPackagesService extends IBaseService<PackagesB, PackageDTO> {
    public List<PackagesB> getPackages() throws ParseException;
}
