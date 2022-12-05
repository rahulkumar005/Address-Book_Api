package com.trantor.addressbookapi.externalservice.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.trantor.addressbookapi.dto.ContactDto;
import com.trantor.addressbookapi.externalservice.ExternalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ExternalServiceImpl implements ExternalService {

    @Autowired
    RestTemplate restTemplateConfig;

    ObjectMapper objectMapper = null;

    @Value("${external.url}")
    String url;

    @Override
    public ContactDto[] getAllContact() {

        final String uri = url + "/search/connectToExternalMachine=n";
        restTemplateConfig = new RestTemplate();
        return restTemplateConfig.getForObject(uri, ContactDto[].class);
    }

    @Override
    public ContactDto[] getContactByName(String name) {
        final String uri = url + "/getCustomer/"+ name+"/connectToExternalMachine=n";
        restTemplateConfig = new RestTemplate();
        return restTemplateConfig.getForObject(uri, ContactDto[].class);


    }

    @Override
    public ContactDto saveContact(ContactDto dto) throws JsonProcessingException {
        final String uri = url + "/save/connectToExternalMachine=n";

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        objectMapper = new ObjectMapper();
        String value = objectMapper.writeValueAsString(dto);

        HttpEntity<String> httpEntity = new HttpEntity<>(value, httpHeaders);
        return restTemplateConfig.postForObject(uri, httpEntity, ContactDto.class);

    }

    @Override
    public String updateCustomer(Long id) {

        final String uri = url + "/update/"+ id+"/connectToExternalMachine=n/";
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(List.of((MediaType.APPLICATION_JSON)));
        HttpEntity<Object> httpEntity = new HttpEntity<>(httpHeaders);
        restTemplateConfig.exchange(uri, HttpMethod.PUT, httpEntity, String.class);
        return "Updated SuccessFully";
    }
}



