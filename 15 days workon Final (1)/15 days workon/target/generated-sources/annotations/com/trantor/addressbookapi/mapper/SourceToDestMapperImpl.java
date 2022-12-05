package com.trantor.addressbookapi.mapper;

import com.trantor.addressbookapi.dto.ContactDto;
import com.trantor.addressbookapi.dto.MobileDto;
import com.trantor.addressbookapi.model.ContactEntity;
import com.trantor.addressbookapi.model.MobileEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-04-07T23:57:04+0530",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.12 (Oracle Corporation)"
)
public class SourceToDestMapperImpl implements SourceToDestMapper {

    @Override
    public ContactEntity dtoToEntity(ContactDto contactDto) {
        if ( contactDto == null ) {
            return null;
        }

        ContactEntity contactEntity = new ContactEntity();

        contactEntity.setContactId( contactDto.getContactId() );
        contactEntity.setFirstName( contactDto.getFirstName() );
        contactEntity.setLastName( contactDto.getLastName() );
        contactEntity.setEmailAddress( contactDto.getEmailAddress() );
        contactEntity.setCreatedBy( contactDto.getCreatedBy() );
        contactEntity.setCreatedDate( contactDto.getCreatedDate() );
        contactEntity.setUpdatedBy( contactDto.getUpdatedBy() );
        contactEntity.setUpdatedDate( contactDto.getUpdatedDate() );
        contactEntity.setIsActive( contactDto.getIsActive() );
        contactEntity.setMobileEntities( mobileDtoListToMobileEntityList( contactDto.getMobileEntities() ) );

        return contactEntity;
    }

    @Override
    public ContactDto entityToDto(ContactEntity entity) {
        if ( entity == null ) {
            return null;
        }

        ContactDto contactDto = new ContactDto();

        contactDto.setContactId( entity.getContactId() );
        contactDto.setFirstName( entity.getFirstName() );
        contactDto.setLastName( entity.getLastName() );
        contactDto.setEmailAddress( entity.getEmailAddress() );
        contactDto.setCreatedBy( entity.getCreatedBy() );
        contactDto.setCreatedDate( entity.getCreatedDate() );
        contactDto.setUpdatedBy( entity.getUpdatedBy() );
        contactDto.setUpdatedDate( entity.getUpdatedDate() );
        contactDto.setIsActive( entity.getIsActive() );
        contactDto.setMobileEntities( mobileEntityListToMobileDtoList( entity.getMobileEntities() ) );

        return contactDto;
    }

    @Override
    public List<ContactDto> entityToDtoList(List<ContactEntity> contactEntities) {
        if ( contactEntities == null ) {
            return null;
        }

        List<ContactDto> list = new ArrayList<ContactDto>( contactEntities.size() );
        for ( ContactEntity contactEntity : contactEntities ) {
            list.add( entityToDto( contactEntity ) );
        }

        return list;
    }

    protected MobileEntity mobileDtoToMobileEntity(MobileDto mobileDto) {
        if ( mobileDto == null ) {
            return null;
        }

        MobileEntity mobileEntity = new MobileEntity();

        mobileEntity.setMobileId( mobileDto.getMobileId() );
        mobileEntity.setMobileNumber( mobileDto.getMobileNumber() );
        mobileEntity.setCountryCode( mobileDto.getCountryCode() );
        mobileEntity.setType( mobileDto.getType() );
        mobileEntity.setCreatedBy( mobileDto.getCreatedBy() );
        mobileEntity.setCreatedDate( mobileDto.getCreatedDate() );
        mobileEntity.setUpdatedBy( mobileDto.getUpdatedBy() );
        mobileEntity.setUpdatedDate( mobileDto.getUpdatedDate() );

        return mobileEntity;
    }

    protected List<MobileEntity> mobileDtoListToMobileEntityList(List<MobileDto> list) {
        if ( list == null ) {
            return null;
        }

        List<MobileEntity> list1 = new ArrayList<MobileEntity>( list.size() );
        for ( MobileDto mobileDto : list ) {
            list1.add( mobileDtoToMobileEntity( mobileDto ) );
        }

        return list1;
    }

    protected MobileDto mobileEntityToMobileDto(MobileEntity mobileEntity) {
        if ( mobileEntity == null ) {
            return null;
        }

        MobileDto mobileDto = new MobileDto();

        mobileDto.setMobileId( mobileEntity.getMobileId() );
        mobileDto.setMobileNumber( mobileEntity.getMobileNumber() );
        mobileDto.setCountryCode( mobileEntity.getCountryCode() );
        mobileDto.setType( mobileEntity.getType() );
        mobileDto.setCreatedBy( mobileEntity.getCreatedBy() );
        mobileDto.setCreatedDate( mobileEntity.getCreatedDate() );
        mobileDto.setUpdatedBy( mobileEntity.getUpdatedBy() );
        mobileDto.setUpdatedDate( mobileEntity.getUpdatedDate() );

        return mobileDto;
    }

    protected List<MobileDto> mobileEntityListToMobileDtoList(List<MobileEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<MobileDto> list1 = new ArrayList<MobileDto>( list.size() );
        for ( MobileEntity mobileEntity : list ) {
            list1.add( mobileEntityToMobileDto( mobileEntity ) );
        }

        return list1;
    }
}
