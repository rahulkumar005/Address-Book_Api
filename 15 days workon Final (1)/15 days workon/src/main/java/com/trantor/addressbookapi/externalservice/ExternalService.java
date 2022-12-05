package com.trantor.addressbookapi.externalservice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.trantor.addressbookapi.dto.ContactDto;

public interface ExternalService {
    ContactDto[] getAllContact();

    ContactDto[] getContactByName(String name);

    ContactDto saveContact(ContactDto dto) throws JsonProcessingException;

    String updateCustomer(Long id);
}
