package com.sma.delivery.service.contacts;

import com.sma.delivery.beans.contacts.ContactB;
import com.sma.delivery.dto.contacts.ContactDTO;
import com.sma.delivery.rest.contacts.IContactsResource;
import com.sma.delivery.service.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("contactsService")
public class ContactsServiceImpl extends BaseServiceImpl<ContactB, ContactDTO> implements IContactsService {

    @Autowired
    private IContactsResource contactsResource;

    public ContactsServiceImpl() {
    }

    @Override
    public ContactB save(ContactB bean)  {
        final ContactDTO contacts = convertBeanToDto(bean);
        final ContactDTO dto = contactsResource.save(contacts);
        final ContactB contactB = convertDtoToBean(dto);
        return contactB;
    }

    @Override
    protected ContactB convertDtoToBean(ContactDTO dto)  {
        final Map<String, String> params = new HashMap<>();
        params.put("id", String.valueOf(dto.getId()!=null ? dto.getId() : "0"));
        params.put("from", dto.getFrom());
        params.put("fullname", dto.getFullname());
        params.put("message", dto.getMessage());
        params.put("phoneNumber", dto.getPhoneNumber());
        final ContactB contactB = new ContactB(params);
        return contactB;
    }

    @Override
    protected ContactDTO convertBeanToDto(ContactB bean) {
        final ContactDTO dto = new ContactDTO();
        dto.setFrom(bean.getFrom());
        dto.setFullname(bean.getFullname());
        dto.setMessage(bean.getMessage());
        dto.setPhoneNumber(bean.getPhoneNumber());
        return dto;
    }


    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<ContactB> getAll(Integer page) {
        return null;
    }

    @Override
    public ContactB getById(Integer id) {
        return null;
    }

    @Override
    public List<ContactB> find(String text, Integer page) {
        return null;
    }
}
