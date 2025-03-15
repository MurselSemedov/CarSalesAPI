package com.mursalsamad.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressOutputDTO {

    private String city;
    private String district;
    private String village;
    private String street;
    private Date createDate;
}
