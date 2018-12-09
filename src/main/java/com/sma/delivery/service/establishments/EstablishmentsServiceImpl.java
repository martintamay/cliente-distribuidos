package com.sma.delivery.service.establishments;

import com.sma.delivery.beans.establishments.EstablishmentsB;
import com.sma.delivery.dto.establishments.EstablishmentsDTO;
import com.sma.delivery.dto.establishments.EstablishmentsResult;
import com.sma.delivery.service.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sma.delivery.rest.establishments.IEstablishmentsResource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("establishmentsService")
public class EstablishmentsServiceImpl extends BaseServiceImpl<EstablishmentsB, EstablishmentsDTO> implements IEstablishmentsService {

    @Autowired
    private IEstablishmentsResource _establishmentsResources;

    public EstablishmentsServiceImpl() {
    }

    @Override
    public EstablishmentsB save(EstablishmentsB bean) {
        final EstablishmentsDTO establishments = convertBeanToDto(bean);
        final EstablishmentsDTO dto = _establishmentsResources.save(establishments);
        final EstablishmentsB establishmentsB = convertDtoToBean(dto);
        return establishmentsB;
    }

    @Override
    public void delete(Integer id) {
        _establishmentsResources.delete(id);
    }

    @Override
    public List<EstablishmentsB> getAll(Integer page) {
        final EstablishmentsResult result = _establishmentsResources.getAll(page);
        final List<EstablishmentsDTO> cList = null == result.getEstablishments() ? new ArrayList<EstablishmentsDTO>()
                : result.getEstablishments();

        final List<EstablishmentsB> establishments = new ArrayList<EstablishmentsB>();
        for (EstablishmentsDTO dto : cList) {
            final EstablishmentsB bean = convertDtoToBean(dto);
            establishments.add(bean);
        }
        return establishments;
    }

    @Override
    public EstablishmentsB getById(Integer id) {
        final EstablishmentsDTO dto = _establishmentsResources.getById(id);
        final EstablishmentsB bean = convertDtoToBean(dto);

        return bean;
    }

    @Override
    public List<EstablishmentsB> find(String text) {
        final EstablishmentsResult result = _establishmentsResources.find(text);
        final List<EstablishmentsDTO> cList = null == result.getEstablishments() ? new ArrayList<EstablishmentsDTO>()
                : result.getEstablishments();

        final List<EstablishmentsB> establishments = new ArrayList<EstablishmentsB>();
        for (EstablishmentsDTO dto : cList) {
            final EstablishmentsB bean = convertDtoToBean(dto);
            establishments.add(bean);
        }
        return establishments;
    }

    @Override
    protected EstablishmentsB convertDtoToBean(EstablishmentsDTO dto) {
        final Map<String, String> params = new HashMap<String, String>();
        params.put("id", String.valueOf(dto.getId()));
        params.put("name", dto.get_name());
        params.put("address", dto.get_address());
        params.put("description", dto.get_description());
        params.put("email", dto.get_email());
        params.put("phoneNumber", dto.get_phone_number());
        params.put("schedule", dto.get_schedule());

        final EstablishmentsB establishmentsB = new EstablishmentsB(params);
        return establishmentsB;
    }

    @Override
    protected EstablishmentsDTO convertBeanToDto(EstablishmentsB bean) {
        final EstablishmentsDTO dto = new EstablishmentsDTO();
        dto.setId(bean.getId());
        dto.set_address(bean.getAddress());
        dto.set_description(bean.getDescription());
        dto.set_email(bean.getEmail());
        dto.set_name(bean.getName());
        dto.set_phone_number(bean.getPhone_number());
        dto.set_schedule(bean.getSchedule());

        return dto;
    }

    @Override
    public List<EstablishmentsB> getEstablishments() {
        final EstablishmentsResult result = _establishmentsResources.getEstablishments();
        final List<EstablishmentsDTO> cList = null == result.getEstablishments() ? new ArrayList<EstablishmentsDTO>() : result.getEstablishments();
        final List<EstablishmentsB> establishments = new ArrayList<EstablishmentsB>();
        for (EstablishmentsDTO dto : cList) {
            establishments.add(convertDtoToBean(dto));
        }
        return establishments;
    }
}
