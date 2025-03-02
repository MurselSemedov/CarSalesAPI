package com.mursalsamad.dto.output;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaledCarOutputDTO {

    private DealerOutputDTO dealer;
    private CarOutputDTO car;
    private CustomerOutputDTO customer;
}
