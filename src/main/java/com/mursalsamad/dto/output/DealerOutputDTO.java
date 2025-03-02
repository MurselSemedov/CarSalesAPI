package com.mursalsamad.dto.output;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DealerOutputDTO {

    private String firstName;
    private String lastName;
    private AddressOutputDTO address;
}
