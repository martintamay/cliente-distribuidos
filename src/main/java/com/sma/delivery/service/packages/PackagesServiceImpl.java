package com.sma.delivery.service.packages;


import com.sma.delivery.beans.packages.PackagesB;
import com.sma.delivery.dto.packages.PackageDTO;
import com.sma.delivery.dto.packages.PackageResult;
import com.sma.delivery.rest.packages.IPackagesResource;
import com.sma.delivery.service.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("packagesService")
public class PackagesServiceImpl extends BaseServiceImpl<PackagesB, PackageDTO> implements IPackagesService {

    @Autowired
    private IPackagesResource _packagesResource;

    public PackagesServiceImpl() {
    }

    @Override
    public PackagesB save(PackagesB bean)  {
        final PackageDTO user = convertBeanToDto(bean);
        final PackageDTO dto = _packagesResource.save(user);
        final PackagesB userB = convertDtoToBean(dto);
        return userB;
    }
    public void delete(Integer id){
        _packagesResource.delete(id);
    }




    @Override
    public List<PackagesB> getAll(Integer page)  {
        final PackageResult result = _packagesResource.getAll(page);
        final List<PackageDTO> cList = null == result.getPackages() ? new ArrayList<PackageDTO>()
                : result.getPackages();

        final List<PackagesB> users = new ArrayList<PackagesB>();
        for (PackageDTO dto : cList) {
            final PackagesB bean = convertDtoToBean(dto);
            users.add(bean);
        }
        return users;
    }
    @Override
    public List<PackagesB> find(String text, Integer page)  {
        final PackageResult result = _packagesResource.find(text, page);
        final List<PackageDTO> cList = null == result.getPackages() ? new ArrayList<PackageDTO>()
                : result.getPackages();

        final List<PackagesB> users = new ArrayList<PackagesB>();
        for (PackageDTO dto : cList) {
            final PackagesB bean = convertDtoToBean(dto);
            users.add(bean);
        }
        return users;
    }






    @Override
    public PackagesB getById(Integer id)  {
        final PackageDTO dto = _packagesResource.getById(id);
        final PackagesB bean = convertDtoToBean(dto);

        return bean;
    }

    @Override
    protected PackagesB convertDtoToBean(PackageDTO dto)  {
        final Map<String, String> params = new HashMap<String, String>();
        params.put("id", String.valueOf(dto.getId()));
        params.put("name", dto.getName());
        params.put("cost", String.valueOf(dto.getCost()));

        final PackagesB userB = new PackagesB(params);
        return userB;
    }

    @Override
    protected PackageDTO convertBeanToDto(PackagesB bean) {
        final PackageDTO dto = new PackageDTO();
        dto.setId(bean.getId());
        dto.setName(bean.getName());
        dto.setCost(bean.getCost());

        return dto;
    }

    @Override
    public List<PackagesB> getPackages()  {
        final PackageResult result = _packagesResource.getPackages();
        final List<PackageDTO> cList = null == result.getPackages() ? new ArrayList<PackageDTO>() : result.getPackages();
        final List<PackagesB> users = new ArrayList<PackagesB>();
        for (PackageDTO dto : cList) {
            users.add(convertDtoToBean(dto));
        }
        return users;
    }
}
