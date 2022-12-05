package com.trantor.addressbookapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MobileDto {
    private Integer mobileId;
    @NotNull(message = "Mobile Number can not be empty")
    @Pattern(regexp = "^\\d{10}$", message = "invalid mobile number")
    private String mobileNumber;
    private String countryCode;
    private String type;
    private String createdBy;
    private Date createdDate;
    private String updatedBy;
    private Date updatedDate;
}
