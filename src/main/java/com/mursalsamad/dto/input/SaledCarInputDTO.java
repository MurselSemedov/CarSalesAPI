package com.mursalsamad.dto.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaledCarInputDTO {

    private long dealer;
    private long car;
    private long customer;
}
