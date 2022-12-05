package com.trantor.addressbookapi.contactservice.impl;

import com.trantor.addressbookapi.dto.ContactDto;
import com.trantor.addressbookapi.exception.custom.ContactNotFoundException;
import com.trantor.addressbookapi.mapper.SourceToDestMapper;
import com.trantor.addressbookapi.model.ContactEntity;
import com.trantor.addressbookapi.repositories.ContactRepository;
import com.trantor.addressbookapi.contactservice.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    ContactRepository customerRepo;

    @Override
    public ContactDto saveContact(ContactDto dto){
        return SourceToDestMapper.MAPPER.entityToDto(customerRepo.save(SourceToDestMapper.MAPPER.dtoToEntity(dto)));
    }

    @Override
    public List<ContactDto> getContact(String firstName) {
        List<ContactEntity> byFirstName = customerRepo.findByFirstName(firstName);
        if (byFirstName.isEmpty()) {
            throw new ContactNotFoundException("Contact Is not in database");
        }
        return SourceToDestMapper.MAPPER.entityToDtoList(byFirstName);

    }

    @Override
    public List<ContactDto> getAllContact() {
        return SourceToDestMapper.MAPPER.entityToDtoList(customerRepo.findAll());

    }

    @Override
    public String updateContact(Long id) {
        Optional<ContactEntity> optionalContactEntity = customerRepo.findById(id);
        if (optionalContactEntity.isPresent()) {
            ContactEntity entity = optionalContactEntity.get();
            entity.setIsActive("N");
            customerRepo.save(entity);
            return "updated successfully";
        } else {
            return "Invalid Id number";
        }

    }
}
