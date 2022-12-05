package com.trantor.addressbookapi.applicationservice.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.trantor.addressbookapi.applicationservice.ApplicationService;
import com.trantor.addressbookapi.contactservice.impl.ContactServiceImpl;
import com.trantor.addressbookapi.dto.ContactDto;
import com.trantor.addressbookapi.externalservice.impl.ExternalServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    @Autowired
    ContactServiceImpl contactService;
    @Autowired
    ExternalServiceImpl externalService;

    @Override
    public ContactDto saveContact(ContactDto dto, String flag) throws JsonProcessingException {
        if (flag.equals("y")) {
            return externalService.saveContact(dto);
        } else {
            return contactService.saveContact(dto);
        }

    }

    @Override
    public List<ContactDto> getContact(String name, String flag) {
        if ((flag.equals("y"))) {
            return List.of(externalService.getContactByName(name));
        } else {
            return contactService.getContact(name);
        }
    }

    @Override
    public List<ContactDto> getAllContact(String flag) {
        if (flag.equals("y")) {
            return List.of(externalService.getAllContact());
        } else {
            return contactService.getAllContact();
        }

    }

    @Override
    public String updateContact(Long contactId, String flag) {
        if (flag.equals("y")) {
            return externalService.updateCustomer(contactId);
        } else {
            return contactService.updateContact(contactId);
        }
    }
}
