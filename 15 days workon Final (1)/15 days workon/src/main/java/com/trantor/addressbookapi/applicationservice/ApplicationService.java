package com.trantor.addressbookapi.applicationservice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.trantor.addressbookapi.dto.ContactDto;

import java.util.List;

public interface ApplicationService {

    public ContactDto saveContact(ContactDto dto, String flag) throws JsonProcessingException;

    public List<ContactDto> getContact(String name, String flag);

    public List<ContactDto> getAllContact(String flag);

    public String updateContact(Long contactId, String flag);
}
