package com.mursalsamad.dto.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DealerInputDTO {

    private String firstName;
    private String lastName;
    private long address;
}
