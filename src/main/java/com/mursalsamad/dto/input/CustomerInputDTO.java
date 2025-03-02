package com.mursalsamad.dto.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerInputDTO {

    private String firstName;
    private String lastName;
    private String serialNumber;
    private String finCode;
    private String birthOfDate;
    private long address;
    private long account;
}
