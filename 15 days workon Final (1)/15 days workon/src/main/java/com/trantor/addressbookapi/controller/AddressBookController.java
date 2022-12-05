package com.trantor.addressbookapi.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.trantor.addressbookapi.applicationservice.impl.ApplicationServiceImpl;
import com.trantor.addressbookapi.dto.ContactDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class AddressBookController {

    @Autowired
    ApplicationServiceImpl applicationServiceimpl;


    @PostMapping("/saveContact/{ConnectToExternalSystem}")
    @ApiOperation(value = "Save New Contact In Database")
    public ResponseEntity<ContactDto> saveContact(@RequestBody @Valid ContactDto dto, @PathVariable("ConnectToExternalSystem") String flag) throws JsonProcessingException {
        return new ResponseEntity<>(applicationServiceimpl.saveContact(dto, flag), HttpStatus.OK);
    }


    @GetMapping("/getContactByName/{name}/{ConnectToExternalSystem}")
    @ApiOperation(value = "Get Contact By Name")
    public ResponseEntity<List<ContactDto>> getContact(@PathVariable("name") String name, @PathVariable("ConnectToExternalSystem") String flag) {
        return new ResponseEntity<>(applicationServiceimpl.getContact(name, flag), HttpStatus.OK);
    }

    @GetMapping("/getAllContact/{ConnectToExternalSystem}")
    @ApiOperation(value = "Get All Contacts ")
    public ResponseEntity<List<ContactDto>> getAllContact(@PathVariable("ConnectToExternalSystem") String flag) {
        return new ResponseEntity<>(applicationServiceimpl.getAllContact(flag), HttpStatus.OK);

    }

    @PutMapping("/partialUpdateContact/{contactId}/{ConnectToExternalSystem}")
    @ApiOperation(value = "Update Contact IsActive")
    public ResponseEntity<String> updateContact(@PathVariable("contactId") Long contactId, @PathVariable("ConnectToExternalSystem") String flag) {
        return new ResponseEntity<>(applicationServiceimpl.updateContact(contactId, flag), HttpStatus.OK);
    }
}