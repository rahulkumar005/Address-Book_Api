package com.trantor.addressbookapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactDto {
    private Long contactId;

   @NotNull(message = "firstName should not be null")
    private String firstName;

    private String lastName;

    @Email(message = "invalid email address")
    private String emailAddress;

    private String createdBy;

    private Date createdDate;

    private String updatedBy;

    private Date updatedDate;

    private String isActive;

    private List<MobileDto> mobileEntities;

}
