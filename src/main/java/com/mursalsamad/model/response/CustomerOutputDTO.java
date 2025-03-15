package com.mursalsamad.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerOutputDTO {
    private String firstName;
    private String lastName;
    private String serialNumber;
    private String finCode;
    private Date birthOfDate;
    private AddressOutputDTO address;
    private AccountOutputDTO account;
    private Date createDate;
}
