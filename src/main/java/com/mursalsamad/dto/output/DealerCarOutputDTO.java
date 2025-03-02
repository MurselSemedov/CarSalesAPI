package com.mursalsamad.dto.output;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DealerCarOutputDTO {

    private DealerOutputDTO dealer;
    private CarOutputDTO car;
}
