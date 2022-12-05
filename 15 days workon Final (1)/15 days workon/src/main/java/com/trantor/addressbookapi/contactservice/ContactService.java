package com.trantor.addressbookapi.contactservice;

import com.trantor.addressbookapi.dto.ContactDto;
import com.trantor.addressbookapi.exception.custom.ContactNotFoundException;

import java.util.List;

public interface ContactService {
    ContactDto saveContact(ContactDto dto);

    List<ContactDto> getContact(String firstName) throws ContactNotFoundException;

    List<ContactDto> getAllContact();

    String updateContact(Long id);
}
