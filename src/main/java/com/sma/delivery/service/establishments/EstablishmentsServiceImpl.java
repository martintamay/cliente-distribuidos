package com.sma.delivery.service.establishments;

import com.sma.delivery.beans.establishments.EstablishmentsB;
import com.sma.delivery.dto.establishments.EstablishmentDTO;
import com.sma.delivery.dto.establishments.EstablishmentResult;
import com.sma.delivery.service.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sma.delivery.rest.establishments.IEstablishmentsResource;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("establishmentsService")
public class EstablishmentsServiceImpl extends BaseServiceImpl<EstablishmentsB, EstablishmentDTO> implements IEstablishmentsService {

    @Autowired
    private IEstablishmentsResource _establishmentsResources;

    public EstablishmentsServiceImpl() {
    }

    @Override
    public EstablishmentsB save(EstablishmentsB bean)  {
        final EstablishmentDTO establishments = convertBeanToDto(bean);
        final EstablishmentDTO dto = _establishmentsResources.save(establishments);
        final EstablishmentsB establishmentsB = convertDtoToBean(dto);
        return establishmentsB;
    }

    @Override
    public void delete(Integer id) {
        _establishmentsResources.delete(id);
    }

    @Override
    public List<EstablishmentsB> getAll(Integer page)  {
        final EstablishmentResult result = _establishmentsResources.getAll(page);
        final List<EstablishmentDTO> cList = null == result.getEstablishments() ? new ArrayList<EstablishmentDTO>()
                : result.getEstablishments();

        final List<EstablishmentsB> establishments = new ArrayList<EstablishmentsB>();
        for (EstablishmentDTO dto : cList) {
            final EstablishmentsB bean = convertDtoToBean(dto);
            establishments.add(bean);
        }
        return establishments;
    }

    @Override
    public EstablishmentsB getById(Integer id)  {
        final EstablishmentDTO dto = _establishmentsResources.getById(id);
        final EstablishmentsB bean = convertDtoToBean(dto);

        return bean;
    }

    @Override
    public List<EstablishmentsB> find(String text, Integer page)  {
        final EstablishmentResult result = _establishmentsResources.find(text, page);
        final List<EstablishmentDTO> cList = null == result.getEstablishments() ? new ArrayList<EstablishmentDTO>()
                : result.getEstablishments();

        final List<EstablishmentsB> users = new ArrayList<EstablishmentsB>();
        for (EstablishmentDTO dto : cList) {
            final EstablishmentsB bean = convertDtoToBean(dto);
            users.add(bean);
            if (bean.getId() != null) {
                getCacheManager().getCache("delivery-cacheC").put("establishmentsC_" + bean.getId(), bean);
            }
        }
        return users;
    }

    @Override
    protected EstablishmentsB convertDtoToBean(EstablishmentDTO dto)  {
        final Map<String, String> params = new HashMap<String, String>();
        params.put("id", String.valueOf(dto.getId()));
        params.put("name", dto.getName());
        params.put("address", dto.getAddress());
        params.put("description", dto.getDescription());
        params.put("email", dto.getEmail());
        params.put("phoneNumber", dto.getPhoneNumber());
        params.put("schedule", dto.getSchedule());

        final EstablishmentsB establishmentsB = new EstablishmentsB(params);
        return establishmentsB;
    }

    @Override
    protected EstablishmentDTO convertBeanToDto(EstablishmentsB bean) {
        final EstablishmentDTO dto = new EstablishmentDTO();
        dto.setId(bean.getId());
        dto.setAddress(bean.getAddress());
        dto.setDescription(bean.getDescription());
        dto.setEmail(bean.getEmail());
        dto.setName(bean.getName());
        dto.setPhoneNumber(bean.getPhone_number());
        dto.setSchedule(bean.getSchedule());

        return dto;
    }

    @Override
    public List<EstablishmentsB> getEstablishments()  {
        final EstablishmentResult result = _establishmentsResources.getEstablishments();
        final List<EstablishmentDTO> cList = null == result.getEstablishments() ? new ArrayList<EstablishmentDTO>() : result.getEstablishments();
        final List<EstablishmentsB> establishments = new ArrayList<EstablishmentsB>();
        for (EstablishmentDTO dto : cList) {
            establishments.add(convertDtoToBean(dto));
        }
        return establishments;
    }
}
