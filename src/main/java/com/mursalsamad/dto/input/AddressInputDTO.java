package com.mursalsamad.dto.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressInputDTO {

    private String city;
    private String district;
    private String village;
    private String street;
}
