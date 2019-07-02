package com.sma.delivery.rest.contacts;

import com.sma.delivery.dto.contacts.ContactDTO;
import com.sma.delivery.rest.base.BaseResourceImpl;
import org.springframework.stereotype.Repository;

@Repository("contactsResource")
public class ContactsResourceImpl extends BaseResourceImpl<ContactDTO> implements IContactsResource {

    public ContactsResourceImpl() {
        super(ContactDTO.class, "/contacts");
    }


    @Override
    public ContactDTO getById(Integer id) {
        return new ContactDTO();
    }
}
