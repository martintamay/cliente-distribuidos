package com.sma.delivery.service.packages;


import com.sma.delivery.beans.packages.PackagesB;
import com.sma.delivery.dto.packaged.PackageDTO;
import com.sma.delivery.dto.packaged.PackageResult;
import com.sma.delivery.service.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sma.delivery.rest.packages.IPackagesResource;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("packagesService")
public class PackagesServiceImpl extends BaseServiceImpl<PackagesB, PackageDTO> implements IPackagesService {

    @Autowired
    private IPackagesResource _packageResource;

    public PackagesServiceImpl() {
    }

    @Override
    public PackagesB save(PackagesB bean) {
        final PackageDTO packages = convertBeanToDto(bean);
        final PackageDTO dto = _packageResource.save(packages);

        final PackagesB packageB = convertDtoToBean(dto);
        return packageB;
    }

    @Override
    public void delete(Integer id){
        _packageResource.delete(id);
    }

    @Override
    public List<PackagesB> getAll(Integer page) {
        final PackageResult result = _packageResource.getAll(page);
        final List<PackageDTO> cList = null == result.getPackages() ? new ArrayList<PackageDTO>()
                : result.getPackages();

        final List<PackagesB> packages = new ArrayList<PackagesB>();
        for (PackageDTO dto : cList) {
            final PackagesB bean = convertDtoToBean(dto);
            packages.add(bean);
        }
        return packages;
    }

    @Override
    public PackagesB getById(Integer id) {
        final PackageDTO dto = _packageResource.getById(id);
        final PackagesB bean = convertDtoToBean(dto);

        return bean;
    }

    @Override
    public List<PackagesB> find(String text, Integer page) {
        final PackageResult result = _packageResource.find(text, page);
        final List<PackageDTO> cList = null == result.getPackages() ? new ArrayList<PackageDTO>()
                : result.getPackages();

        final List<PackagesB> packages = new ArrayList<PackagesB>();
        for (PackageDTO dto : cList) {
            final PackagesB bean = convertDtoToBean(dto);
            packages.add(bean);
        }
        return packages;
    }

    @Override
    protected PackagesB convertDtoToBean(PackageDTO dto) {
        final Map<String, String> params = new HashMap<String, String>();
        params.put("id", String.valueOf(dto.getId()));
        params.put("name", dto.getName());
        params.put("cost", String.valueOf(dto.getCost()));
        final PackagesB packagesB = new PackagesB(params);

        return packagesB;
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
    public List<PackagesB> getPackages() {
        final PackageResult result = _packageResource.getPackages();
        final List<PackageDTO> cList = null == result.getPackages() ? new ArrayList<PackageDTO>() : result.getPackages();
        final List<PackagesB> packages = new ArrayList<PackagesB>();
        for (PackageDTO dto : cList) {
            packages.add(convertDtoToBean(dto));
        }
        return packages;
    }
}
